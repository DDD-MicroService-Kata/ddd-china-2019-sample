package com.victory.ddd.china.sample.infrastructure.repo;


import com.victory.ddd.china.sample.domain.context.relationship.profile.Profile;
import com.victory.ddd.china.sample.domain.context.relationship.profile.ProfileRepo;
import com.victory.ddd.china.sample.domain.user.User;
import com.victory.ddd.china.sample.domain.user.UserRepo;
import com.victory.ddd.china.sample.infrastructure.mapping.ProfileMapping;
import com.victory.ddd.china.sample.infrastructure.mapping.ProfilePO;
import com.victory.ddd.china.sample.infrastructure.mapping.UserMapping;
import com.victory.ddd.china.sample.infrastructure.mapping.UserPO;
import lombok.NonNull;
import lombok.val;

import javax.inject.Inject;
import javax.inject.Named;
import java.util.Optional;

@Named
public class UserRepoImpl implements UserRepo {

    @Inject
    private UserMapping userMapping;

    @Override
    public void save(@NonNull User user) {
        val po = UserPO.from(user);
        userMapping.insert(po);
    }

    @Override
    public Optional<User> get(String username) {
        return userMapping.findByUsername(username).map(UserPO::toUser);
    }

    @Override
    public Optional<User> getByEmail(String email) {
        return userMapping.findByEmail(email).map(UserPO::toUser);
    }
}
