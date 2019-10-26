package com.victory.ddd.china.sample.application.utils;

import com.victory.ddd.china.sample.domain.types.DomainBusinessException;

import java.io.UnsupportedEncodingException;
import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class DigestUtil {
    public static String digest(String password) {
        MessageDigest digest;

        try {
            digest = MessageDigest.getInstance("SHA-1");
            digest.reset();
            digest.update(password.getBytes("utf8"));
        } catch (NoSuchAlgorithmException | UnsupportedEncodingException e) {
            e.printStackTrace();
            throw new DomainBusinessException("hash failed");
        }

        return String.format("%040x", new BigInteger(1, digest.digest()));
    }
}
