package com.pramod.employeeauth.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

@EnableWebSecurity
@Configuration
public class SecurityConfig {
    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) {
        return http.csrf(c -> c.disable())
                .authorizeHttpRequests(request -> request
                        .requestMatchers("/actuator/prometheus").permitAll()
                        .requestMatchers("/actuator/health").permitAll()
                        .requestMatchers("/public/**").permitAll()
                        .requestMatchers("/users/**").permitAll()
                        .requestMatchers("/normal/**").hasRole("NORMAL")
                        .requestMatchers("/admin/**").hasRole("ADMIN")
                        .requestMatchers("/authority/read/**").hasAuthority("READ")
                        .requestMatchers("/authority/write/**").hasAuthority("WRITE")
                        .anyRequest().authenticated())
                .httpBasic(Customizer.withDefaults())
                .formLogin(Customizer.withDefaults())
                .build();


    }
}
