package com.example.pc1dbp.config;

import com.example.pc1dbp.auth.components.JwtAuthorizationFilter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
@EnableWebSecurity
@EnableMethodSecurity(secureEnabled=true)
public class SecurityConfig {
    private final UserService userDetailsService;
    private final JwtAuthorizationFilter jwtFilter;

    public SecurityConfig(UserService userDetailsService, JwtAuthorizationFilter jwtFilter){
        this.jwtFilter = jwtFilter;
        this.userDetailsService = userDetailsService;
    }

    @Bean
    public PasswordEncoder passwordEncoder(){
        return
    }
}
