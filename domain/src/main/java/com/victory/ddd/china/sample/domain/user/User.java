package com.victory.ddd.china.sample.domain.user;

import com.victory.ddd.china.sample.domain.types.AggregateRoot;
import com.victory.ddd.china.sample.domain.types.DomainBusinessException;
import com.victory.ddd.china.sample.domain.types.Entity;
import lombok.AllArgsConstructor;
import lombok.Getter;

import java.io.UnsupportedEncodingException;
import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

@AggregateRoot
@Getter
@Entity
@AllArgsConstructor
public class User {
    private String username;
    private String email;
    private String password;

    public static User of(String username, String email, String password) {
        MessageDigest digest = null;

        try {
            digest = MessageDigest.getInstance("SHA-1");
            digest.reset();
            digest.update(password.getBytes("utf8"));
        } catch (NoSuchAlgorithmException | UnsupportedEncodingException e) {
            e.printStackTrace();
            throw new DomainBusinessException("hash failed");
        }

        String hashedPassword = String.format("%040x", new BigInteger(1, digest.digest()));
        return new User(username, email, hashedPassword);
    }
}
