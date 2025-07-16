package Fortis_Sidera.spotform.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.web.SecurityFilterChain;

import static org.springframework.security.config.Customizer.withDefaults;

@Configuration
@EnableWebSecurity
public class SecurityConfig {

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http
                // выключаем CSRF, т.к. у нас REST‑API без cookie‑сессий
                .csrf(csrf -> csrf.disable())

                // делаем API публичным
                .authorizeHttpRequests(auth -> auth
                        .requestMatchers(HttpMethod.POST, "/api/documents/**").permitAll()
                        .anyRequest().authenticated()
                )

                // базовая авторизация для остальных запросов (оставим на будущее)
                .httpBasic(withDefaults())

                // Stateless‑режим, т.к. не храним сессии
                .sessionManagement(sess ->
                        sess.sessionCreationPolicy(SessionCreationPolicy.STATELESS)
                );

        return http.build();
    }

}
