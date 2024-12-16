package com.example.WebProject.config;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jws;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.JwtException;
import org.springframework.http.HttpHeaders;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

@Component
public class JwtAuthenticationFilter extends OncePerRequestFilter {

    private final String secretKey = "your-secret-key"; // Cambia esto por tu clave secreta real.

    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain)
            throws ServletException, IOException {
        String authHeader = request.getHeader(HttpHeaders.AUTHORIZATION);

        if (authHeader == null || !authHeader.startsWith("Bearer ")) {
            response.setStatus(HttpServletResponse.SC_UNAUTHORIZED);
            response.getWriter().write("Missing or invalid Authorization header.");
            return;
        }

        String token = authHeader.substring(7); // Remueve el prefijo "Bearer "
        try {
            // Analiza y valida el token
            Jws<Claims> claimsJws = Jwts.parserBuilder()
                    .setSigningKey(secretKey.getBytes()) // Clave secreta
                    .build()
                    .parseClaimsJws(token);

            Claims claims = claimsJws.getBody();
            request.setAttribute("userId", claims.getSubject()); // Extrae la información del token
        } catch (JwtException e) {
            response.setStatus(HttpServletResponse.SC_UNAUTHORIZED);
            response.getWriter().write("Invalid token.");
            return;
        }

        // Continúa con el siguiente filtro en la cadena
        filterChain.doFilter(request, response);
    }
}
