package org.romanco.library.libraryaauth.service;

import io.jsonwebtoken.Clock;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.impl.DefaultClock;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.util.Date;

@Service
public class JwtServiceImpl implements JwtService {

    private final Clock clock = DefaultClock.INSTANCE;

    @Value("${jwt.ttlMinutes}")
    private int ttlMinutes;

    @Value("${jwt.secret}")
    private String secret;

    @Override
    public String buildJwt(String login) {
        Date creationDate = clock.now();

        return Jwts.builder()
                .setSubject(login)
                .setIssuedAt(creationDate)
                .setExpiration(new Date(creationDate.getTime() + (long) ttlMinutes * 1000 * 60))
                .signWith(SignatureAlgorithm.HS512, secret)
                .compact();
    }
}
