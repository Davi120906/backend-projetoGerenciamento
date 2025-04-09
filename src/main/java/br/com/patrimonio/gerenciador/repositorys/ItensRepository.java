package br.com.patrimonio.gerenciador.repositorys;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.patrimonio.gerenciador.classes.Itens;

public interface  ItensRepository extends JpaRepository<Itens,String>{
 
}
