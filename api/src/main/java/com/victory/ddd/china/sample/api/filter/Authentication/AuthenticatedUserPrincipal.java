package com.victory.ddd.china.sample.api.filter.Authentication;

import java.security.Principal;

final class AuthenticatedUserPrincipal implements Principal {
    private final String username;

    AuthenticatedUserPrincipal(String username) {
        this.username = username;
    }

    @Override
    public String getName() {
        return username;
    }
}
