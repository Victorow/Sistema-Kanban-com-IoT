package br.com.meuprojeto.kanbanapi.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
public class SecurityConfig {

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http
            // 1. Desabilita o CSRF, pois nossa API será stateless (não usará sessões/cookies)
            .csrf(csrf -> csrf.disable())

            // 2. A API não criará ou usará sessões de usuário
            .sessionManagement(session -> session.sessionCreationPolicy(SessionCreationPolicy.STATELESS))

            // 3. Define as regras de autorização para os endpoints
            .authorizeHttpRequests(auth -> auth
                // Permite acesso público a todos os endpoints que começam com /api/
                .requestMatchers("/api/**").permitAll() 
                // Para qualquer outra requisição, o usuário precisa estar autenticado
                .anyRequest().authenticated() 
            );

        return http.build();
    }
}