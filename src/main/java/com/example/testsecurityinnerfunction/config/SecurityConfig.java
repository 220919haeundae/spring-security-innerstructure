package com.example.testsecurityinnerfunction.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.annotation.Order;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityCustomizer;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity(debug = true)
public class SecurityConfig {

    @Bean
    @Order(1)
    public SecurityFilterChain securityFilterChain1(HttpSecurity httpSecurity) throws Exception {

        httpSecurity
                .securityMatchers(auth -> auth
                        .requestMatchers("/user"));

        httpSecurity
                .authorizeHttpRequests(auth -> auth
                        .requestMatchers("/user").permitAll());
        return httpSecurity.build();
    }

    @Bean
    @Order(2)
    public SecurityFilterChain securityFilterChain2(HttpSecurity httpSecurity) throws Exception {

        httpSecurity
                .securityMatchers(auth -> auth
                        .requestMatchers("/admin"));

        httpSecurity
                .authorizeHttpRequests(auth -> auth
                        .requestMatchers("/admin").permitAll());
        return httpSecurity.build();
    }

    @Bean
    public WebSecurityCustomizer webSecurityCustomizer() {
        return web -> web.ignoring().requestMatchers("/img/**");
    }

}
