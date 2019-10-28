package com.victory.ddd.china.sample.domain.user;

import javax.inject.Inject;
import javax.inject.Named;

@Named
public class IsUserExistsSpecificationImpl implements IsUserExistsSpecification {
    private final UserRepo userRepo;

    @Inject
    public IsUserExistsSpecificationImpl(UserRepo userRepo) {
        this.userRepo = userRepo;
    }

    @Override
    public boolean isUserExists(String userName) {
        return userRepo.get(userName).isPresent();
    }
}
