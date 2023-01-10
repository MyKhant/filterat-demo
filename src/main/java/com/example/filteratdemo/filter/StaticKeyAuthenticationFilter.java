package com.example.filteratdemo.filter;

import jakarta.servlet.*;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.core.log.LogMessage;
import org.springframework.security.web.FilterChainProxy;
import org.springframework.security.web.firewall.FirewalledRequest;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.util.List;

@Component
public class StaticKeyAuthenticationFilter implements Filter {

    @Value("${authentication.key}")
    private String authorizationKey;

    //    @Bean
//    private void doFilterInternal(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
//        var httpRequest = (HttpServletRequest) request;
//        var httpResponse = (HttpServletResponse) response;
//
//        String authKey = httpRequest.getHeader("Authorization");
//        if (authorizationKey.equals(authKey)){
//            chain.doFilter(request,response);
//        }else {
//            httpResponse.setStatus(HttpServletResponse.SC_UNAUTHORIZED);
//        }
//    }
    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        var httpRequest = (HttpServletRequest) request;
        var httpResponse = (HttpServletResponse) response;

        String authKey = httpRequest.getHeader("Authorization");
        if (authorizationKey.equals(authKey)) {
            chain.doFilter(request, response);
        } else {
            httpResponse.setStatus(HttpServletResponse.SC_UNAUTHORIZED);
        }
    }
}

