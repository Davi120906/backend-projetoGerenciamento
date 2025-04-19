package br.com.patrimonio.gerenciador.controlers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.patrimonio.gerenciador.classes.User;
import br.com.patrimonio.gerenciador.dtos.AuthenticationDTO;
import br.com.patrimonio.gerenciador.dtos.LoginResponseDTO;
import br.com.patrimonio.gerenciador.dtos.RegisterDTO;
import br.com.patrimonio.gerenciador.infra.TokenService;
import br.com.patrimonio.gerenciador.repositorys.UserRepository;
import jakarta.validation.Valid;

@RestController
@RequestMapping("auth")
public class AuthenticationController {
    
    @Autowired
    private AuthenticationManager authenticationManager;
    
    @Autowired
    private UserRepository userRepository;
    
    @Autowired
    private TokenService tokenService;
    
    @PostMapping("/login")
    public ResponseEntity<LoginResponseDTO> login(@RequestBody @Valid AuthenticationDTO data) {
        // Convert the ID string to Long for authentication
        try {
            Long userId = Long.parseLong(data.id());
            var usernamePassToken = new UsernamePasswordAuthenticationToken(userId.toString(), data.password());
            var auth = this.authenticationManager.authenticate(usernamePassToken);
            
            var token = tokenService.generateToken((User) auth.getPrincipal());
            return ResponseEntity.ok(new LoginResponseDTO(token));
        } catch (NumberFormatException e) {
            return ResponseEntity.badRequest().build();
        }
    }
    
    @PostMapping("/register")
    public ResponseEntity<Void> register(@RequestBody @Valid RegisterDTO data) {
        try {
            Long userId = Long.parseLong(data.id());
            
            if(this.userRepository.findById(userId).isPresent()) {
                return ResponseEntity.badRequest().build();
            }
            
            String encryptedPassword = new BCryptPasswordEncoder().encode(data.password());
            
            User newUser = new User();
            newUser.setId(userId);
            newUser.setNome(data.nome());
            newUser.setPassword(encryptedPassword);
            newUser.setRole(data.role());
            
            this.userRepository.save(newUser);
            return ResponseEntity.ok().build();
        } catch (NumberFormatException e) {
            return ResponseEntity.badRequest().build();
        }
    }
}