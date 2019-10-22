package com.victory.ddd.china.sample.domain.user;


import com.victory.ddd.china.sample.domain.build.block.DomainBusinessException;
import lombok.AllArgsConstructor;
import lombok.Getter;

import java.io.UnsupportedEncodingException;
import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import com.victory.ddd.china.sample.domain.build.block.AggregateRoot;
import com.victory.ddd.china.sample.domain.build.block.Entity;

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
