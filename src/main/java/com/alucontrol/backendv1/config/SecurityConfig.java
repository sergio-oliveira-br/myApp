package com.alucontrol.backendv1.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;
import org.springframework.security.crypto.factory.PasswordEncoderFactories;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
public class SecurityConfig {

    private final CustomUserDetails customUserDetails;

    @Autowired
    public SecurityConfig(CustomUserDetails customUserDetails) {
        this.customUserDetails = customUserDetails;
    }


    @Bean
    SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {

        http
        // Desativa CSRF temporariamente para facilitar o teste
         .csrf(AbstractHttpConfigurer::disable)

        // Inicia a definição das regras de autorização.
        .authorizeHttpRequests((authorizeRequests -> authorizeRequests
            .requestMatchers("/images/login-img.pdf").permitAll()
            .requestMatchers("/login", "/login**", "/users").permitAll() // Permite acesso irrestrito
            .anyRequest().authenticated())  // O resto requer autenticação
        )
        .formLogin((form -> form
            .loginPage("/login.html").permitAll()
            .loginProcessingUrl("/login")
            .defaultSuccessUrl("/index.html", true)
            .failureUrl("/login.html?error=true"))
        )
        .logout((logout -> logout
            .logoutUrl("/perform_logout") // URL para logout
            .deleteCookies("JSESSIONID")
            .logoutSuccessUrl("/login.html")) // URL após logout;
        );
        return http.build();
    }


    @Bean
    public PasswordEncoder passwordEncoder() {
        return PasswordEncoderFactories.createDelegatingPasswordEncoder();
    }


    @Bean
    public AuthenticationManager authenticationManager(HttpSecurity http) throws Exception {

        return http.getSharedObject(AuthenticationManagerBuilder.class)
                .authenticationProvider(authenticationProvider())
                .build();
    }


    @Bean
    public DaoAuthenticationProvider authenticationProvider() {

        DaoAuthenticationProvider authProvider = new DaoAuthenticationProvider();
        authProvider.setUserDetailsService(customUserDetails);
        authProvider.setPasswordEncoder(passwordEncoder());

        return authProvider;
    }
}
