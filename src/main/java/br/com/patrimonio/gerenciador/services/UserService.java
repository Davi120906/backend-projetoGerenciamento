package br.com.patrimonio.gerenciador.services;

import java.util.List;

import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.patrimonio.gerenciador.classes.Itens;
import br.com.patrimonio.gerenciador.classes.User;
import br.com.patrimonio.gerenciador.repositorys.UserRepository;

@Service
public class UserService {
    @Autowired
    private UserRepository userRepository;
    public List<User> getAllUser(){
        return userRepository.findAll();
    }
    public void registerUser(User user){
       Optional<User> usn = userRepository.findByNAS(user.getId());
        if(usn.isPresent()){
            throw new IllegalArgumentException("ERRO ESSE ID JA ESTA NO DATABASE");
        }
        userRepository.save(user);
    }
}
