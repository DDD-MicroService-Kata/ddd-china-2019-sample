package com.victory.ddd.china.sample.domain.user;

import java.util.Optional;

public interface UserRepo {
    void save(User user);

    Optional<User> get(String userName);
}
