package com.victory.ddd.china.sample.adapters.rest.resource;

import com.victory.ddd.china.sample.application.read.model.ProfilePublicRepresentationReadModel;
import com.victory.ddd.china.sample.application.usecase.following.FollowUserUseCase;
import com.victory.ddd.china.sample.application.usecase.following.UnFollowUserUseCase;
import org.glassfish.jersey.process.internal.RequestScoped;
import org.springframework.beans.factory.annotation.Autowired;

import javax.ws.rs.DELETE;
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
    private final UnFollowUserUseCase unFollowUserUseCase;
    private final SecurityContext securityContext;

    @Autowired
    public FollowResource(final FollowUserUseCase followUseCase, final UnFollowUserUseCase unFollowUserUseCase,
                          @Context final SecurityContext securityContext) {
        this.followUseCase = followUseCase;
        this.unFollowUserUseCase = unFollowUserUseCase;
        this.securityContext = securityContext;
    }

    @POST
    @Path("/{username}/follow")
    @Produces("application/json")
    public ProfilePublicRepresentationReadModel follow(@PathParam("username") String toFollowUsername) {
        String currentUser = securityContext.getUserPrincipal().getName();
        return this.followUseCase.follow(currentUser, toFollowUsername);

    }

    @DELETE
    @Path("/{username}/follow")
    @Produces("application/json")
    public ProfilePublicRepresentationReadModel unFollow(@PathParam("username") String toFollowUsername) {
        String currentUser = securityContext.getUserPrincipal().getName();
        return this.unFollowUserUseCase.unFollow(currentUser, toFollowUsername);

    }
}
