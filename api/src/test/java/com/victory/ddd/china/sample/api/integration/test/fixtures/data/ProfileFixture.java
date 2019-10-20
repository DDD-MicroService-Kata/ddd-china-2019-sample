package com.victory.ddd.china.sample.api.integration.test.fixtures.data;

import com.victory.ddd.china.sample.domain.context.relationship.profile.Profile;
import com.victory.ddd.china.sample.domain.context.relationship.profile.ProfileRepo;

import javax.inject.Named;

@Named
public class ProfileFixture {

    private final ProfileRepo profileRepo;

    public ProfileFixture(ProfileRepo profileRepo) {
        this.profileRepo = profileRepo;
    }

    public Profile createCurrentUserProfile() {
        Profile profile = new Profile(Usernames.CURRENT_USER,
                "I like default",
                "default image");
        profileRepo.save(profile);
        return profile;
    }

    public Profile createTheOtherUserProfile() {
        Profile profile = new Profile(Usernames.THE_OTHER_ONE,
                "I like the other one",
                "the other one image");
        profileRepo.save(profile);
        return profile;
    }
}
