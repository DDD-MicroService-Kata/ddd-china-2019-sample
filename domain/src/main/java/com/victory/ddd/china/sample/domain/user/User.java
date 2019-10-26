package com.victory.ddd.china.sample.domain.user;

import com.victory.ddd.china.sample.domain.types.AggregateRoot;
import com.victory.ddd.china.sample.domain.types.Entity;
import lombok.AllArgsConstructor;
import lombok.Getter;

@AggregateRoot
@Getter
@Entity
@AllArgsConstructor
public class User {
    private String username;
    private String email;
    private String password;

    public static User of(String username, String email, String password) {
        return new User(username, email, password);
    }

    public boolean validatePassword(String password) {
        return this.password.equals(password);
    }
}
