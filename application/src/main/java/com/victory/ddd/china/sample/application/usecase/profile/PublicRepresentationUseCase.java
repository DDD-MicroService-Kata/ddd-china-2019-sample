package com.victory.ddd.china.sample.application.usecase.profile;

import com.victory.ddd.china.sample.domain.context.relationship.profile.ProfileRepo;

import javax.inject.Inject;
import javax.inject.Named;

@Named
public class PublicRepresentationUseCase {

    private final ProfileRepo profileRepo;

    @Inject
    public PublicRepresentationUseCase(ProfileRepo profileRepo) {
        this.profileRepo = profileRepo;
    }

    public PublicRepresentationDto get(String userName) {
        return profileRepo.
                get(userName).
                map(PublicRepresentationDto::from).orElse(PublicRepresentationDto.defaultInstance());
    }
}
