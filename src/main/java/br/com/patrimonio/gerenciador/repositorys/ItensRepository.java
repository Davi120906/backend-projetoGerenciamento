package br.com.patrimonio.gerenciador.repositorys;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import br.com.patrimonio.gerenciador.classes.Itens;

public interface  ItensRepository extends JpaRepository<Itens,String>{
 @Query("SELECT i FROM Itens i WHERE i.nPatrimonio = ?1")
 Optional<Itens> findByNP(String np);

 @Query("SELECT i FROM Itens i WHERE i.nPatrimonio = ?1")
 List<Itens> findByNumeroPatrimonio(String np);

 @Query("SELECT i FROM Itens i WHERE i.nAntigo = ?1")
 List<Itens> findByNAntigo(String nAntigo);
 @Query("SELECT i FROM Itens i WHERE i.conservacao = ?1")
 List<Itens> findByConservacao(String conservacao);
 List<Itens> findByValorBem(float valorBem);
 List<Itens> findBySalaRegistrada(String salaRegistrada);
 List<Itens> findByDescricao(String descricao);
 List<Itens> findBySalaAtual(String salaAtual);
    
}
