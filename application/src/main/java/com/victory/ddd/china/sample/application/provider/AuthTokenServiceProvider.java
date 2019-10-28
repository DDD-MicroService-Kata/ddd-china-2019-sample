package com.victory.ddd.china.sample.application.provider;

public interface AuthTokenServiceProvider {
    String issue(String username);

    String parse(String token);
}
