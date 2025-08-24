package org.romanco.library.librarycore.filter;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jws;
import io.jsonwebtoken.JwtException;
import io.jsonwebtoken.Jwts;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpHeaders;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.filter.OncePerRequestFilter;

import java.io.IOException;
import java.util.Collections;

@RequiredArgsConstructor
public class JwtFilter extends OncePerRequestFilter {

    private static final String TOKEN_PREFIX = "Bearer ";
    private final String secret;


    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain) throws ServletException, IOException {
        String headerValue = request.getHeader(HttpHeaders.AUTHORIZATION);
        if (headerValue == null || !headerValue.startsWith(TOKEN_PREFIX)) {
            filterChain.doFilter(request, response);
            return;
        }
        String jwtToken = headerValue.substring(TOKEN_PREFIX.length());
        try {

            Jws<Claims> claimsJws = Jwts.parser().setSigningKey(secret).parseClaimsJws(jwtToken);
            Claims body = claimsJws.getBody();
            String login = body.getSubject();
            //todo искать id пользователя по логину и кэшировать id за логином
            UsernamePasswordAuthenticationToken usernamePasswordAuthenticationToken =
                    new UsernamePasswordAuthenticationToken(login, null, Collections.emptySet());
            SecurityContextHolder.getContext().setAuthentication(usernamePasswordAuthenticationToken);
            filterChain.doFilter(request, response);

        } catch (JwtException e) {
            throw new IllegalArgumentException("Token is invalid %s".formatted(jwtToken));
        }
    }
}
