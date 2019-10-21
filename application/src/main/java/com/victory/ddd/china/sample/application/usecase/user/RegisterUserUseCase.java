package com.victory.ddd.china.sample.application.usecase.user;

import com.victory.ddd.china.sample.domain.context.relationship.profile.Profile;
import com.victory.ddd.china.sample.domain.context.relationship.profile.ProfileRepo;
import com.victory.ddd.china.sample.domain.types.DomainBusinessException;
import com.victory.ddd.china.sample.domain.user.User;
import com.victory.ddd.china.sample.domain.user.UserRepo;
import org.apache.commons.lang3.tuple.Pair;
import org.springframework.transaction.annotation.Transactional;

import javax.inject.Inject;
import javax.inject.Named;

@Named
public class RegisterUserUseCase {

    @Inject
    private UserRepo userRepo;

    @Inject
    private ProfileRepo profileRepo;

    /**
     * Tasks
     * 1. check userName is valid
     * 2. new User
     * 3. new profile
     */
    @Transactional
    public Pair<User, Profile> register(String email, String userName, String password) {
        if (userRepo.get(userName).isPresent()) {
            throw new DomainBusinessException("user name already been used");
        }
        User user = User.of(email, userName, password);
        Profile profile = new Profile(userName);

        userRepo.save(user);
        profileRepo.save(profile);
        return Pair.of(user, profile);
    }
}
