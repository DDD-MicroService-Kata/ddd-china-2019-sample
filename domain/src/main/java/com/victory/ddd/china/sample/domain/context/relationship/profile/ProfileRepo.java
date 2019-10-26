package com.victory.ddd.china.sample.domain.context.relationship.profile;

import java.util.Optional;

public interface ProfileRepo {
    void save(Profile theOtherOneProfile);

    void update(String username, Profile newProfile);

    Optional<Profile> get(String userName);
}
