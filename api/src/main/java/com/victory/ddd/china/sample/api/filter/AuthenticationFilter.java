package com.victory.ddd.china.sample.api.filter;

import com.victory.ddd.china.sample.infrastructure.token.JwtTokenService;

import javax.annotation.Priority;
import javax.inject.Inject;
import javax.security.auth.Subject;
import javax.ws.rs.Priorities;
import javax.ws.rs.container.ContainerRequestContext;
import javax.ws.rs.container.ContainerRequestFilter;
import javax.ws.rs.core.HttpHeaders;
import javax.ws.rs.core.SecurityContext;
import javax.ws.rs.ext.Provider;
import java.io.IOException;
import java.security.Principal;

@Provider
@Priority(Priorities.AUTHENTICATION)
public class AuthenticationFilter implements ContainerRequestFilter {
    private final JwtTokenService jwtTokenService;

    @Inject
    public AuthenticationFilter(JwtTokenService jwtTokenService) {
        this.jwtTokenService = jwtTokenService;
    }

    @Override
    public void filter(ContainerRequestContext requestContext) throws IOException {
        String authorizationHeader = requestContext.getHeaderString(HttpHeaders.AUTHORIZATION);
        if (authorizationHeader != null) {
            handleTokenBasedAuthentication(authorizationHeader, requestContext);
        }
    }

    private void handleTokenBasedAuthentication(String authenticationToken, ContainerRequestContext requestContext) {
        String username = jwtTokenService.parse(authenticationToken);
        boolean isSecure = requestContext.getSecurityContext().isSecure();
        SecurityContext securityContext = new UsernameSecurityContext(username, isSecure);
        requestContext.setSecurityContext(securityContext);
    }
}

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
