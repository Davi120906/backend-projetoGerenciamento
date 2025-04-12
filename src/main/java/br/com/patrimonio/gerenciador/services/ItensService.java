package br.com.patrimonio.gerenciador.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.patrimonio.gerenciador.classes.Itens;
import br.com.patrimonio.gerenciador.repositorys.ItensRepository;
import br.com.patrimonio.gerenciador.testes.ItensTest;
import jakarta.transaction.Transactional;
@Service
public class ItensService {
    @Autowired
    private ItensRepository itensRepository;


    @Autowired
    private ItensTest itensTest;
    public List<Itens> getAllItens(){
        return itensRepository.findAll();
    }
    public void registerItem(Itens item){
        Optional<Itens> itenNp = itensRepository.findByNP(item.getNPatrimonio());
        if(itenNp.isPresent()){
            throw new IllegalArgumentException("ESSE NUMERO DE PATRIMONIO JA EXISTE NO SISTEMA!");
        }
        else if(!itensTest.isFormatValid(item.getNPatrimonio())){
            throw new IllegalArgumentException("ERRO NO FORMATO DO NUMERO DE PATRIMONIO CONFIRA POR FAVOR!");
        }
        itensRepository.save(item);
    }
    public void deleteItem(String np){
        boolean exists = itensRepository.existsById(np);
        if(!exists){
            throw new IllegalStateException("ERRO O ITEM " + np + " NAO EXISTE");
        }
        itensRepository.deleteById(np);
    }
    @Transactional
    public void updateItem(String np, Itens item)
    {
        Itens item1 = itensRepository.findById(np).orElseThrow(() -> new IllegalArgumentException("ITEM NAO ENCONTRADO"));
        item1.setFoto(item.getFoto());
        item1.setSalaRegistrada(item.getSalaRegistrada());
        item1.setSalaAtual(item.getSalaAtual());
    }
    @Transactional
    public void moverItem(String np, String salaAtual){
        Itens item1 = itensRepository.findById(np).orElseThrow(() -> new IllegalArgumentException("ITEM NAO ENCONTRADO"));
        item1.setSalaAtual(salaAtual);
    }
    public List<Itens> buscarPorParametro(String tipoBusca, String busca){
        switch(tipoBusca.toLowerCase()){
            case "patrimonio":
            return itensRepository.findByNumeroPatrimonio(busca);
            case "antigo":
            return itensRepository.findByNAntigo(busca);
            case "nome":
            return itensRepository.findByDescricao(busca);
            case "valor":
            float valor = Float.parseFloat(busca.replace(",", "."));
            return itensRepository.findByValorBem(valor);
            case "localregistrado":
            return itensRepository.findBySalaRegistrada(busca);
            case "localatual":
            return itensRepository.findBySalaAtual(busca);
            case "conservacao":
            return itensRepository.findByConservacao(busca);
            default:
            throw new IllegalArgumentException("ERRO PARAMETRO INVALIDO");
        }
    }
}
