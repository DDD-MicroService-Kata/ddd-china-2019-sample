package com.victory.ddd.china.sample.infrastructure.providers;

import com.victory.ddd.china.sample.application.provider.AuthTokenServiceProvider;
import com.victory.ddd.china.sample.infrastructure.token.JwtTokenService;

import javax.inject.Inject;
import javax.inject.Named;

@Named
public class AuthTokenServiceProviderImpl implements AuthTokenServiceProvider {
        private final JwtTokenService jwtTokenService;

    @Inject
    public AuthTokenServiceProviderImpl(JwtTokenService jwtTokenService) {
        this.jwtTokenService = jwtTokenService;
    }

    @Override
    public String issue(String username) {
        return jwtTokenService.issue(username);
    }

    @Override
    public String parse(String token) {
        return jwtTokenService.parse(token);
    }
}
