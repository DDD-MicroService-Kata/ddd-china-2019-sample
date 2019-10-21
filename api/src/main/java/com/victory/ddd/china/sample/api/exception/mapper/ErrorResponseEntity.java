package com.victory.ddd.china.sample.api.exception.mapper;

import com.victory.ddd.china.sample.domain.types.DomainBusinessException;
import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Data
class ErrorResponseEntity {
    private List<String> errors = new ArrayList<>();

    void withError(DomainBusinessException error) {
        errors.add(error.getMessage());
    }
}
