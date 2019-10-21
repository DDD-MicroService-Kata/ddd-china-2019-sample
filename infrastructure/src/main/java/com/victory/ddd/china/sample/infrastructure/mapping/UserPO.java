package com.victory.ddd.china.sample.infrastructure.mapping;

import com.victory.ddd.china.sample.domain.user.User;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

@Builder
@AllArgsConstructor
@Getter
public class UserPO {
    private String username;
    private String email;
    private String password;

    public static UserPO from(User user) {
        return new UserPO(user.getUsername(), user.getEmail(), user.getPassword());
    }

    public static User toUser(UserPO userPO) {
        return new User(userPO.getUsername(), userPO.getEmail(), userPO.getPassword());
    }
}
