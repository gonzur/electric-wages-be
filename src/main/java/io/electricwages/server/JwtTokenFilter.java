package io.electricwages.server;

import io.electricwages.server.services.ElectricUserDetailsService;
import io.electricwages.server.services.JwtService;
import org.springframework.http.HttpHeaders;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.web.authentication.WebAuthenticationDetailsSource;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@Component
public class JwtTokenFilter extends OncePerRequestFilter {
    private final JwtService jwtService;
    private final ElectricUserDetailsService electricUserDetailsService;

    public JwtTokenFilter(JwtService jwtService, ElectricUserDetailsService electricUserDetailsService) {
        this.jwtService = jwtService;
        this.electricUserDetailsService =electricUserDetailsService;
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
        if(!jwtService.validateJWT(jwtToken)) {
            chain.doFilter(request, response);
            return;
        }

        String username;
        try {
            username = jwtService.getUsername(jwtToken);
        } catch (Exception e) {
           chain.doFilter(request, response);
           return;
        }
        UserDetails userDetails = electricUserDetailsService.loadUserByUsername(username);
        var token = new UsernamePasswordAuthenticationToken(userDetails, null, List.of());
        token.setDetails(
                new WebAuthenticationDetailsSource().buildDetails(request)
        );
        SecurityContextHolder.getContext().setAuthentication(token);
        chain.doFilter(request, response);
    }
}
