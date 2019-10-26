package com.victory.ddd.china.sample.application.usecase.user;

import com.victory.ddd.china.sample.application.exception.InvalidEmailException;
import com.victory.ddd.china.sample.application.utils.DigestUtil;
import com.victory.ddd.china.sample.domain.context.relationship.profile.Profile;
import com.victory.ddd.china.sample.domain.context.relationship.profile.ProfileRepo;
import com.victory.ddd.china.sample.domain.user.User;
import com.victory.ddd.china.sample.domain.user.UserRepo;
import com.victory.ddd.china.sample.infrastructure.token.JwtTokenService;
import org.apache.commons.lang3.tuple.Triple;

import javax.inject.Inject;
import javax.inject.Named;

@Named
public class UserLoginUseCase {

    @Inject
    private UserRepo userRepo;

    @Inject
    private JwtTokenService jwtTokenService;

    @Inject
    private ProfileRepo profileRepo;

    public Triple<User, Profile, String> login(String email, String password) {
        User user = userRepo.getByEmail(email).get();
        if (user.validatePassword(DigestUtil.digest(password))) {
            throw new InvalidEmailException(email);
        }
        String token = jwtTokenService.issue(user.getUsername());
        Profile profile = profileRepo.get(user.getUsername()).get();
        return Triple.of(user, profile, token);
    }
}
