package com.example.testsecurityinnerfunction.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.annotation.Order;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityCustomizer;
import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity(debug = true)
public class SecurityConfig {

    public SecurityFilterChain filterChain(HttpSecurity httpSecurity) throws Exception {

        httpSecurity.cors(cors -> cors.disable());

        httpSecurity.csrf(csrf -> csrf.disable());

        //UsernamePasswordAuthenticationFilter 활성
        httpSecurity.formLogin(Customizer.withDefaults());
        //UsernamePasswordAuthenticationFilter 비활성
        httpSecurity.formLogin(login -> login.disable());

        // 로그인/로그아웃 페이지 필터 비활성화
        // 기본적으로 활성화되어 있는 상태임, 커스텀 시 기본 필터가 비활성화됨 -> 아래처럼 커스텀 시 로그아웃 페이지는 비활성화됨
        httpSecurity.formLogin(login -> login.loginPage("/login").permitAll());

        //BasicAuthenticationFilter 활성
        httpSecurity.httpBasic(Customizer.withDefaults());
        //BasicAuthenticationFilter 비활성
        httpSecurity.httpBasic(basic -> basic.disable());

        return httpSecurity.build();
    }

}
