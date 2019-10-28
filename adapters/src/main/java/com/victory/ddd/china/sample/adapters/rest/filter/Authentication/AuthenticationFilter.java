package com.victory.ddd.china.sample.adapters.rest.filter.Authentication;

import com.victory.ddd.china.sample.application.provider.AuthTokenServiceProvider;

import javax.annotation.Priority;
import javax.inject.Inject;
import javax.ws.rs.Priorities;
import javax.ws.rs.container.ContainerRequestContext;
import javax.ws.rs.container.ContainerRequestFilter;
import javax.ws.rs.core.HttpHeaders;
import javax.ws.rs.core.SecurityContext;
import javax.ws.rs.ext.Provider;
import java.io.IOException;

@Provider
@Priority(Priorities.AUTHENTICATION)
public class AuthenticationFilter implements ContainerRequestFilter {
    private final AuthTokenServiceProvider authTokenServiceProvider;

    @Inject
    public AuthenticationFilter(AuthTokenServiceProvider authTokenServiceProvider) {
        this.authTokenServiceProvider = authTokenServiceProvider;
    }

    @Override
    public void filter(ContainerRequestContext requestContext) throws IOException {
        String authorizationHeader = requestContext.getHeaderString(HttpHeaders.AUTHORIZATION);
        if (authorizationHeader != null) {
            handleTokenBasedAuthentication(authorizationHeader, requestContext);
        }
    }

    private void handleTokenBasedAuthentication(String authenticationToken, ContainerRequestContext requestContext) {
        String username = authTokenServiceProvider.parse(authenticationToken);
        boolean isSecure = requestContext.getSecurityContext().isSecure();
        SecurityContext securityContext = new UsernameSecurityContext(username, isSecure);
        requestContext.setSecurityContext(securityContext);
    }
}

