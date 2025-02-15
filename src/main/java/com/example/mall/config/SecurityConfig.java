package com.example.mall.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
public class SecurityConfig {

    @Bean
    public SecurityFilterChain filterChain(HttpSecurity httpSecurity) throws Exception {
        httpSecurity.csrf().disable();
        httpSecurity.authorizeHttpRequests(authorization -> {
            authorization
                    .requestMatchers("/user/create")
                    .permitAll();
            authorization
                    .requestMatchers("mall/products/create")
                    .hasRole("admin");
            authorization
                    .anyRequest()
                    .authenticated();
        });
        httpSecurity.httpBasic();
        return httpSecurity.build();
    }
}
