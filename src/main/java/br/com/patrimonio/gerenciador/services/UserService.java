package br.com.patrimonio.gerenciador.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.patrimonio.gerenciador.classes.User;
import br.com.patrimonio.gerenciador.classes.UserRoles;
import br.com.patrimonio.gerenciador.repositorys.UserRepository;
import jakarta.transaction.Transactional;

@Service
public class UserService {
    @Autowired
    private UserRepository userRepository;
    
    public List<User> getAllUser() {
        return userRepository.findAll();
    }
    
    public User registerUser(User user) {
        Optional<User> existingUser = userRepository.findById(user.getId());
        if (existingUser.isPresent()) {
            throw new IllegalArgumentException("ERRO: ESSE ID JÁ ESTÁ NO DATABASE");
        }
        return userRepository.save(user);
    }
    
    public Optional<User> getUserById(Long id) {
        return userRepository.findById(id);
    }
    
    @Transactional
    public User updateUser(Long id, User updatedUser) {
        User user = userRepository.findById(id)
            .orElseThrow(() -> new IllegalArgumentException("USUÁRIO NÃO ENCONTRADO"));
        
        user.setNome(updatedUser.getNome());
        user.setRole(updatedUser.getRole());
        user.setPassword(updatedUser.getPassword());
        
        return user;
    }
    
    public void deleteUser(Long id) {
        boolean exists = userRepository.existsById(id);
        if (!exists) {
            throw new IllegalArgumentException("ERRO: O USUÁRIO " + id + " NÃO EXISTE");
        }
        userRepository.deleteById(id);
    }
}