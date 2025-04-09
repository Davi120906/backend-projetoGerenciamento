package br.com.patrimonio.gerenciador.repositorys;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import br.com.patrimonio.gerenciador.classes.Itens;

public interface  ItensRepository extends JpaRepository<Itens,String>{
 @Query("SELECT i FROM Itens i WHERE i.nPatrimonio = ?1")
 Optional<Itens> findByNP(String np);

}
