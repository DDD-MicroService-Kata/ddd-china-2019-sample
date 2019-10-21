package com.victory.ddd.china.sample.api.controller;

import com.victory.ddd.china.sample.api.controller.request.CreateUserRequest;
import com.victory.ddd.china.sample.api.controller.response.CreateUserResponse;
import com.victory.ddd.china.sample.application.usecase.profile.QueryPublicRepresentationUseCase;
import com.victory.ddd.china.sample.application.usecase.user.RegisterUserUseCase;
import com.victory.ddd.china.sample.domain.context.relationship.profile.Profile;
import com.victory.ddd.china.sample.domain.user.User;
import org.glassfish.jersey.process.internal.RequestScoped;
import org.springframework.beans.factory.annotation.Autowired;
import org.apache.commons.lang3.tuple.Pair;
import org.springframework.http.ResponseEntity;

import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.SecurityContext;
import java.net.URI;

@RequestScoped
@Path("/users")
@Produces(MediaType.APPLICATION_JSON)
public class UserResource {

    @Context
    SecurityContext securityContext;

    private final QueryPublicRepresentationUseCase queryPublicRepresentationUseCase;

    private final RegisterUserUseCase registerUserUseCase;

    @Autowired
    public UserResource(final QueryPublicRepresentationUseCase queryPublicRepresentationUseCase, final RegisterUserUseCase registerUserUseCase) {
        this.queryPublicRepresentationUseCase = queryPublicRepresentationUseCase;
        this.registerUserUseCase = registerUserUseCase;
    }

    @POST
    @Path("/")
    public ResponseEntity<CreateUserResponse> createUser(CreateUserRequest createUserRequest) {
        Pair<User, Profile> pair = registerUserUseCase.register(
                createUserRequest.getEmail(),
                createUserRequest.getUsername(),
                createUserRequest.getPassword()
        );

        return ResponseEntity.created(URI.create("/users/" + createUserRequest.getUsername())).body(
                CreateUserResponse.from(pair.getLeft(), pair.getRight())
        );
    }
}
