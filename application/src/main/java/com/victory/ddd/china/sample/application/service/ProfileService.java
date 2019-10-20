package com.victory.ddd.china.sample.application.service;

import com.victory.ddd.china.sample.application.dto.ProfileRepresentationDto;
import com.victory.ddd.china.sample.domain.context.relationship.ProfileRepo;

import javax.inject.Inject;
import javax.inject.Named;
import java.util.Optional;

@Named
public class ProfileService {

    private final ProfileRepo profileRepo;

    @Inject
    public ProfileService(ProfileRepo profileRepo) {
        this.profileRepo = profileRepo;
    }

    public Optional<ProfileRepresentationDto> get(String userName) {
        return profileRepo.
                get(userName).
                map(ProfileRepresentationDto::from);

    }
}
