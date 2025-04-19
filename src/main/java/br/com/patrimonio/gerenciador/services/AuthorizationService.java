package br.com.patrimonio.gerenciador.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import br.com.patrimonio.gerenciador.repositorys.UserRepository;

@Service
public class AuthorizationService implements UserDetailsService {
    
    @Autowired
    private UserRepository usuarioRepository;
    
    @Override
    public UserDetails loadUserByUsername(String idString) throws UsernameNotFoundException {
        try {
            Long id = Long.parseLong(idString);
            return usuarioRepository.findById(id)
                    .orElseThrow(() -> new UsernameNotFoundException("Usuário não encontrado com ID: " + idString));
        } catch (NumberFormatException e) {
            throw new UsernameNotFoundException("ID inválido: " + idString);
        }
    }
}