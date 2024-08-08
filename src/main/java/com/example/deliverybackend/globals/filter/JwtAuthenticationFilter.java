package com.example.deliverybackend.globals.filter;

import com.example.deliverybackend.globals.jwt.JwtProvider;
import jakarta.servlet.*;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.util.StringUtils;

import java.io.IOException;

public class JwtAuthenticationFilter extends GenericFilter {
    private final JwtProvider jwtProviders;

    public JwtAuthenticationFilter(JwtProvider jwtProviders) {
        this.jwtProviders = jwtProviders;
    }

    @Override
    public void doFilter(
            ServletRequest servletRequest,
            ServletResponse servletResponse,
            FilterChain filterChain
    ) throws IOException, ServletException {
        String token = resolveToken((HttpServletRequest) servletRequest);
        if(token != null && jwtProviders.validateToken(token)) {
            Authentication authentication = jwtProviders.getAuthentication(token);
            SecurityContextHolder.getContext().setAuthentication(authentication);
        }
        filterChain.doFilter(servletRequest, servletResponse);
    }

    public String resolveToken(HttpServletRequest request) {
        String bearToken = request.getHeader("Authorization");
        if(StringUtils.hasText(bearToken) &&
            bearToken.startsWith("Bearer")) {
            return bearToken.substring(7);
        }
    }
}
