package com.victory.ddd.china.sample.api.filter.Authentication;

import javax.ws.rs.core.SecurityContext;
import java.security.Principal;

final class UsernameSecurityContext implements SecurityContext {

    private final boolean isSecure;
    private AuthenticatedUserPrincipal user;

    public UsernameSecurityContext(String username, boolean isSecure) {
        user = new AuthenticatedUserPrincipal(username);
        this.isSecure = isSecure;
    }

    @Override
    public Principal getUserPrincipal() {
        return this.user;
    }

    @Override
    public boolean isUserInRole(String role) {
        return true;
    }

    @Override
    public boolean isSecure() {
        return isSecure;
    }

    @Override
    public String getAuthenticationScheme() {
        return "Bearer";
    }
}
