package br.com.patrimonio.gerenciador.repositorys;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import br.com.patrimonio.gerenciador.classes.Itens;
import br.com.patrimonio.gerenciador.classes.User;
public interface UserRepository extends JpaRepository<User,Long>{
 @Query("SELECT u FROM User u WHERE u.id = ?1")
 Optional<User> findByNAS(Long nas);
}
