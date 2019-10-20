package com.victory.ddd.china.sample.domain.context.relationship.profile;

import java.util.Optional;

public interface ProfileRepo {
    void save(Profile theOtherOneProfile);

    Optional<Profile> get(String userName);
}
