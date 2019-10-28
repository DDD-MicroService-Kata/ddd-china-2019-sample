package com.victory.ddd.china.sample.application.exception;

import com.victory.ddd.china.sample.application.build.block.ApplicationException;

public class NoSuchUserExistsException extends ApplicationException {
    public NoSuchUserExistsException(String username) {
        super(String.format("no such user exists %s", username));
    }
}
