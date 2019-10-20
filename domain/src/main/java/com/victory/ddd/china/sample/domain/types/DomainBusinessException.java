package com.victory.ddd.china.sample.domain.types;

public class DomainBusinessException extends  RuntimeException {
    public DomainBusinessException(String message) {
        super(message);
    }
}
