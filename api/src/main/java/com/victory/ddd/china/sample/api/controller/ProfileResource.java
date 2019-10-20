package com.victory.ddd.china.sample.api.controller;

import com.victory.ddd.china.sample.application.usecase.profile.PublicRepresentationDto;
import com.victory.ddd.china.sample.application.usecase.profile.PublicRepresentationUseCase;
import org.springframework.beans.factory.annotation.Autowired;

import javax.inject.Singleton;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import java.util.Optional;

@Singleton
@Path("/profiles")
@Produces(MediaType.APPLICATION_JSON)
public class ProfileResource {

    private final PublicRepresentationUseCase publicRepresentationUseCase;

    @Autowired
    public ProfileResource(final PublicRepresentationUseCase publicRepresentationUseCase) {
        this.publicRepresentationUseCase = publicRepresentationUseCase;
    }

    @GET
    @Path("/{username}")
    @Produces("application/json")
    public Optional<PublicRepresentationDto> get(@PathParam("username") String userName){
        return this.publicRepresentationUseCase.get(userName);
    }
}