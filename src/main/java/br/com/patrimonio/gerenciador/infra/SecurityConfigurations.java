package br.com.patrimonio.gerenciador.infra;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

@Configuration
@EnableWebSecurity
public class SecurityConfigurations {
    
    @Autowired
    SecurityFilter securityFilter;
    
    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity httpSecurity) throws Exception {
        return httpSecurity
            .csrf(csrf -> csrf.disable())
            .sessionManagement(session -> session.sessionCreationPolicy(SessionCreationPolicy.STATELESS))
            .authorizeHttpRequests(authorize -> authorize
                .requestMatchers(HttpMethod.POST, "/auth/login").permitAll()
                .requestMatchers(HttpMethod.POST, "/auth/register").permitAll()
                .requestMatchers(HttpMethod.GET, "/api/itens").hasRole("USER")
                .requestMatchers(HttpMethod.POST, "/api/itens/cadastrar").hasRole("ADMIN")
                .requestMatchers(HttpMethod.DELETE, "/api/itens/deletar/**").hasRole("ADMIN")
                .requestMatchers(HttpMethod.PUT, "/api/itens/atualizar/**").hasRole("ADMIN")
                .requestMatchers(HttpMethod.PUT, "/api/itens/movimentacao/**").hasRole("USER")
                .requestMatchers(HttpMethod.GET, "/api/itens/buscar").hasRole("USER")
                .requestMatchers(HttpMethod.GET, "/api/usuario").hasRole("ADMIN")
                .requestMatchers(HttpMethod.POST, "/api/usuario/cadastrar").hasRole("ADMIN")
                .requestMatchers(HttpMethod.PUT, "/api/usuario/atualizar/**").hasRole("ADMIN")
                .requestMatchers(HttpMethod.DELETE, "/api/usuario/deletar/**").hasRole("ADMIN")
                .anyRequest().authenticated()
            )
            .addFilterBefore(securityFilter, UsernamePasswordAuthenticationFilter.class)
            .build();
    }
    
    @Bean
    public AuthenticationManager authenticationManager(AuthenticationConfiguration authenticationConfiguration) throws Exception {
        return authenticationConfiguration.getAuthenticationManager();
    }
    
    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }
}