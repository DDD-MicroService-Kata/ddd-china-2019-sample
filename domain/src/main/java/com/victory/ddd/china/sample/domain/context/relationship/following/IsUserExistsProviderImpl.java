package com.victory.ddd.china.sample.domain.context.relationship.following;

import com.victory.ddd.china.sample.domain.context.relationship.following.IsUserExistsProvider;
import com.victory.ddd.china.sample.domain.user.UserRepo;

import javax.inject.Inject;
import javax.inject.Named;

@Named
public class IsUserExistsProviderImpl implements IsUserExistsProvider {
    private final UserRepo userRepo;

    @Inject
    public IsUserExistsProviderImpl(UserRepo userRepo) {
        this.userRepo = userRepo;
    }

    @Override
    public boolean isUserExists(String userName) {
        return userRepo.get(userName).isPresent();
    }
}
