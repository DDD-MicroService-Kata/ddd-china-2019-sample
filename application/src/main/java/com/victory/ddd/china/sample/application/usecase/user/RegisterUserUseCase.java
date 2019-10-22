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
     * 1. check username is valid
     * 2. new User
     * 3. new profile
     */
    @Transactional
    public Pair<User, Profile> register(String email, String username, String password) {
        if (userRepo.get(username).isPresent()) {
            throw new DomainBusinessException("user name already been used");
        }
        User user = User.of(username, email, password);
        Profile profile = new Profile(username);

        userRepo.save(user);
        profileRepo.save(profile);
        return Pair.of(user, profile);
    }
}
