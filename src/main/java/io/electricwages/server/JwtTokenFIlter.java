package io.electricwages.server;

import io.electricwages.server.services.JwtService;
import org.springframework.http.HttpHeaders;
import org.springframework.web.filter.OncePerRequestFilter;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class JwtTokenFIlter extends OncePerRequestFilter {
    private final JwtService jwtService;

    public JwtTokenFIlter(JwtService jwtService) {
        this.jwtService = jwtService;
    }

    @Override
    public void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain chain)
    throws IOException, ServletException {
        final String authHeader = request.getHeader(HttpHeaders.AUTHORIZATION);

        if(authHeader.isEmpty() || !authHeader.startsWith("Bearer ")) {
            chain.doFilter(request, response);
            return;
        }

        final String jwtToken = authHeader.split(" ")[1].trim();

    }
}
