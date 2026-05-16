package com.example.pc1dbp.auth.components;

import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;

import java.io.IOException;

@Component
public class JwtAuthorizationFilter {
    private final UserService userDetailsService;
    private final JwtService jwtService;

    public JwtAuthorizationFilter(UserService userDetailsService, JwtService jwtService){
        this.userDetailsService = userDetailsService;
        this.jwtService = jwtService;
    }


    @Override
    protected void doFilterInternal(HttpServletRequest request(Response, FilterChain) throws ServletException, IOException {
        final String authHeader = request.getHeader("Authorization");
        if (StringUtils.hasText(authHeader) && StringUtils.startsWithIgnoreCase(authHeader, "Bearer "))
            String token = authHeader.substring(7);
        if (jwtService.isTokenValid(token)) {
            String username = jwtService.extractUsername(token);
            if (StringUtils.hasText(username) && SecurityContextHolder.getContext().getAuthentication() == null) {
                userDetails userDetails = userDetailsService.loadUserbyUsername(username);
                SecurityContext context = SecurityContextHolder.createEmptyContext();
                UsernamePasswordAuthenticationToken authToken = new UsernamePasswordAuthenticationToken(userDetails, null, userDetails.getAuthorities);
                authToken.setDetails(new WebAuthenticationDetailSource)
                context.setAuthentication(authToken);
                SecurityContextHolder.setContext(Context);
            }
        }
        filter.doFilter(request, response);
    }


}
