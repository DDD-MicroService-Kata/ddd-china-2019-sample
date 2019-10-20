package com.victory.ddd.china.sample.api.integration.test.fixtures.stub;

import com.victory.ddd.china.sample.infrastructure.token.JwtTokenService;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;

import javax.inject.Named;
import java.time.LocalDate;
import java.util.UUID;

@Named
public class JwtTokenServiceImpl implements JwtTokenService {

    private static final String SERCERT_KEY = "sercertkey";
    private static final String PREFIX = "Token ";

    @Override
    public String issue(String currentUser) {
        final var tokenValue = Jwts.builder()
                .setId(UUID.randomUUID().toString())
                .setIssuer("Testing")
                .setAudience("api")
                .setSubject(currentUser)
                .setIssuedAt(java.sql.Date.valueOf(LocalDate.now()))
                .setExpiration(java.sql.Date.valueOf(LocalDate.now().plusYears(10)))
                .signWith(SignatureAlgorithm.HS256, SERCERT_KEY)
                .compact();
        return PREFIX + tokenValue;
    }

    @Override
    public String parse(String token) {
        final var tokenValue = token.substring(PREFIX.length(), token.length());
        final var claims = Jwts.parser().setSigningKey(SERCERT_KEY).parseClaimsJws(tokenValue).getBody();
        return claims.getSubject();
    }
}
