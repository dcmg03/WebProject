package com.example.WebProject.config;

import com.example.WebProject.service.JwtService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@Component
public class JwtAuthenticationFilter implements Filter {

    @Autowired
    private JwtService jwtService;

    private final String[] excludedPaths = {"/api/auth/register", "/api/auth/login"};

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
            throws IOException, ServletException {
        HttpServletRequest httpRequest = (HttpServletRequest) request;
        HttpServletResponse httpResponse = (HttpServletResponse) response;

        String path = httpRequest.getRequestURI();

        // Exclude specific paths from JWT validation
        for (String excluded : excludedPaths) {
            if (path.contains(excluded)) {
                chain.doFilter(request, response);
                return;
            }
        }

        String token = httpRequest.getHeader("Authorization");

        if (token != null && jwtService.isTokenValid(token)) {
            chain.doFilter(request, response);
        } else {
            httpResponse.sendError(HttpServletResponse.SC_UNAUTHORIZED, "Invalid JWT token");
        }
    }
}
