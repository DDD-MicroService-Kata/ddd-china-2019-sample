package com.victory.ddd.china.sample.api.integration.test.fixtures.data;

import com.victory.ddd.china.sample.domain.user.User;
import com.victory.ddd.china.sample.domain.user.UserRepo;

import javax.inject.Named;

@Named
public class UserFixture {

    private final UserRepo userRepo;

    public UserFixture(UserRepo userRepo) {
        this.userRepo = userRepo;
    }

    public User createCurrentUser() {
        User user = new User(Usernames.CURRENT_USER, "test@email.com", "HASHXODEZ");
        userRepo.save(user);
        return user;
    }
}
