package com.victory.ddd.china.sample.api.controller;

import com.victory.ddd.china.sample.application.dto.ProfileRepresentationDto;
import com.victory.ddd.china.sample.application.service.ProfileService;
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

    private final ProfileService profileService;

    @Autowired
    public ProfileResource(final ProfileService profileService ) {
        this.profileService = profileService;
    }

    @GET
    @Path("/{username}")
    @Produces("application/json")
    public Optional<ProfileRepresentationDto> get(@PathParam("username") String userName){
        return this.profileService.get(userName);
    }
}
