package org.romanco.library.libraryaauth.service;

import io.jsonwebtoken.Clock;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.impl.DefaultClock;
import org.springframework.stereotype.Service;

import java.util.Date;

@Service
public class JwtServiceImpl implements JwtService {

    private final Clock clock = DefaultClock.INSTANCE;
    private final static int TTL_MINUTES = 5;
    private final static String SECRET = "secreteeffffffffffffffffffffffffffffffffffffffffffaf";

    @Override
    public String buildJwt(String login) {
        Date creationDate = clock.now();

        return Jwts.builder()
                .setSubject(login)
                .setIssuedAt(creationDate)
                .setExpiration(new Date(creationDate.getTime() + (long) TTL_MINUTES * 1000 * 60))
                .signWith(SignatureAlgorithm.HS512, SECRET)
                .compact();
    }
}
