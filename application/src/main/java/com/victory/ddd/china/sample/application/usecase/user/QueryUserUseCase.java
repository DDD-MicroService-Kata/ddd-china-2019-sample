package com.victory.ddd.china.sample.application.usecase.user;

import com.victory.ddd.china.sample.domain.context.relationship.profile.Profile;
import com.victory.ddd.china.sample.domain.context.relationship.profile.ProfileRepo;
import com.victory.ddd.china.sample.domain.types.DomainBusinessException;
import com.victory.ddd.china.sample.domain.user.User;
import com.victory.ddd.china.sample.domain.user.UserRepo;
import com.victory.ddd.china.sample.infrastructure.token.JwtTokenService;
import org.apache.commons.lang3.tuple.Pair;
import org.apache.commons.lang3.tuple.Triple;
import org.springframework.transaction.annotation.Transactional;

import javax.inject.Inject;
import javax.inject.Named;

@Named
public class QueryUserUseCase {

    @Inject
    private UserRepo userRepo;

    @Inject
    private ProfileRepo profileRepo;

    public Pair<User, Profile> queryUserWithProfile(String username) {
        User user = userRepo.get(username).get();
        Profile profile = profileRepo.get(username).get();
        return Pair.of(user, profile);
    }
}
