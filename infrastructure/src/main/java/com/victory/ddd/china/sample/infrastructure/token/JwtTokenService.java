package com.victory.ddd.china.sample.infrastructure.token;

public interface JwtTokenService {
    String issue(String currentUser);

    String parse(String token);
}
