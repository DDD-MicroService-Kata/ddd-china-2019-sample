package com.victory.ddd.china.sample.adapters.rest.exception.mapper;

import com.victory.ddd.china.sample.domain.build.block.DomainBusinessException;
import lombok.Data;
import lombok.val;

import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.ArrayList;
import java.util.List;

@Data
class ErrorResponseEntity {
    private List<String> errors = new ArrayList<>();

    static Response buildResponse(RuntimeException exception) {
        val errorResponseEntity = new ErrorResponseEntity();
        errorResponseEntity.withError(exception);
        return Response.status(422).
                entity(errorResponseEntity).
                type(MediaType.APPLICATION_JSON).
                build();
    }

    private void withError(RuntimeException error) {
        errors.add(error.getMessage());
    }
}
