package com.victory.ddd.china.sample.infrastructure.repo;


import com.victory.ddd.china.sample.domain.context.relationship.profile.Profile;
import com.victory.ddd.china.sample.domain.context.relationship.profile.ProfileRepo;
import com.victory.ddd.china.sample.infrastructure.mapping.ProfileMapping;
import com.victory.ddd.china.sample.infrastructure.mapping.ProfilePO;
import lombok.NonNull;
import lombok.val;

import javax.inject.Inject;
import javax.inject.Named;
import java.util.Optional;

@Named
public class ProfileRepoImpl implements ProfileRepo {

    private final ProfileMapping profileMapping;

    @Inject
    public ProfileRepoImpl(ProfileMapping profileMapping) {
        this.profileMapping = profileMapping;
    }

    @Override
    public void save(@NonNull Profile theOtherOneProfile) {
        val po = ProfilePO.from(theOtherOneProfile);
        this.profileMapping.insert(po);
    }

    @Override
    public Optional<Profile> get(String userName) {
        return this.profileMapping.
                findByUsername(userName).
                map(ProfilePO::toProfile);
    }
}
