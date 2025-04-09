package br.com.patrimonio.gerenciador.controlers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.patrimonio.gerenciador.classes.Itens;
import br.com.patrimonio.gerenciador.services.ItensService;

@RestController
@RequestMapping("api/itens")
public class ItensController {
    @Autowired
    ItensService itensService;
    @GetMapping
    public List<Itens> getAllItens(){
       return itensService.getAllItens();
    }
    @PostMapping(path = "cadastrar")
    public void registerItem(@RequestBody Itens item){
        itensService.registerItem(item);
    }
    @DeleteMapping(path = "deletar/{npatrimonio}")
    public void deleteIten(@PathVariable("npatrimonio") String npatrimonio){
        itensService.deleteItem(npatrimonio);
    }
    @PutMapping(path = "atualizar/{npatrimonio}")
    public void updateItem(@PathVariable("npatrimonio") String npatrimonio, @RequestBody Itens item){
        itensService.updateItem(npatrimonio, item);
    }
    @PutMapping(path = "movimentacao/{npatrimonio}")
    public void moverItem(@PathVariable("npatrimonio") String npatrimonio, @RequestBody String salaAtual){
        itensService.moverItem(npatrimonio, salaAtual);
    }
}
