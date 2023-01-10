package com.example.filteratdemo.config;

import com.example.filteratdemo.filter.StaticKeyAuthenticationFilter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.www.BasicAuthenticationFilter;

@Configuration
public class ProjectConfig {

    @Autowired
    private StaticKeyAuthenticationFilter filter;

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Throwable{
        http.addFilterAt(filter, BasicAuthenticationFilter.class)
                .authorizeHttpRequests()
                .anyRequest()
                .permitAll();
        return http.build();
    }
}
