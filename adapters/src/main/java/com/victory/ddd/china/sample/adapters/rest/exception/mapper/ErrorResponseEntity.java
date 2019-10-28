package com.victory.ddd.china.sample.adapters.rest.exception.mapper;

import com.victory.ddd.china.sample.domain.build.block.DomainBusinessException;
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
