package com.victory.ddd.china.sample.api.controller;

import com.victory.ddd.china.sample.application.query.ProfilePublicRepresentationQueryModel;
import com.victory.ddd.china.sample.application.usecase.following.FollowUserUseCase;
import org.glassfish.jersey.process.internal.RequestScoped;
import org.springframework.beans.factory.annotation.Autowired;

import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.SecurityContext;

@RequestScoped
@Path("/profiles")
@Produces(MediaType.APPLICATION_JSON)
public class FollowResource {
    private final FollowUserUseCase followUseCase;
    @Context
    SecurityContext securityContext;

    @Autowired
    public FollowResource(final FollowUserUseCase followUseCase) {
        this.followUseCase = followUseCase;
    }

    @POST
    @Path("/{username}/follow")
    @Produces("application/json")
    public ProfilePublicRepresentationQueryModel follow(@PathParam("username") String toFollowUsername) {
        String currentUser = securityContext.getUserPrincipal().getName();
        return this.followUseCase.follow(currentUser, toFollowUsername);

    }
}
