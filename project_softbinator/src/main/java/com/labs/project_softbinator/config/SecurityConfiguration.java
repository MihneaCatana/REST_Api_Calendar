package com.labs.project_softbinator.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.crypto.factory.PasswordEncoderFactories;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
public class SecurityConfiguration {

    @Bean
    public PasswordEncoder passwordEncoder() {
        return PasswordEncoderFactories.createDelegatingPasswordEncoder();
    }

    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
        return http
                .csrf(csrf->csrf.disable())
                .authorizeHttpRequests(auth -> auth
                        .requestMatchers("/", "/signup", "register").permitAll() // Permit all users create users
                        .requestMatchers("/user/**").hasAuthority("ROLE_ADMIN") // Restrict buyers endpoints to only the buyer role
                        .requestMatchers("/calendar/**").hasAuthority("ROLE_EMPLOYEE") // Restrict sellers endpoints to only the seller role
                )
                .httpBasic(Customizer.withDefaults())
                .build();
    }

}