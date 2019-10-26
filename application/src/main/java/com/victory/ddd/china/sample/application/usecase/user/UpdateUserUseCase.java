package com.victory.ddd.china.sample.application.usecase.user;

import com.victory.ddd.china.sample.domain.context.relationship.profile.Profile;
import com.victory.ddd.china.sample.domain.context.relationship.profile.ProfileRepo;
import com.victory.ddd.china.sample.domain.user.UserRepo;

import javax.inject.Inject;
import javax.inject.Named;

@Named
public class UpdateUserUseCase {

    @Inject
    private UserRepo userRepo;

    @Inject
    private ProfileRepo profileRepo;

    public void updateUserCase(String username, String bio, String image) {
        Profile profile = profileRepo.get(username).get().update(bio, image);
        profileRepo.update(username, profile);
    }
}
