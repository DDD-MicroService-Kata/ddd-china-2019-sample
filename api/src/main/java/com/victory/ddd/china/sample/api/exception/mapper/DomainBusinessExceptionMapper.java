package com.victory.ddd.china.sample.api.exception.mapper;

import com.victory.ddd.china.sample.domain.types.DomainBusinessException;
import lombok.Data;
import lombok.val;

import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.ext.ExceptionMapper;
import javax.ws.rs.ext.Provider;
import java.util.ArrayList;
import java.util.List;

@Provider
public class DomainBusinessExceptionMapper implements ExceptionMapper<DomainBusinessException> {
    @Override
    public Response toResponse(DomainBusinessException exception) {
        val errorResponseEntity = new ErrorResponseEntity();
        errorResponseEntity.withError(exception);
        return Response.status(422).
                entity(errorResponseEntity).
                type(MediaType.APPLICATION_JSON).
                build();
    }
}


@Data
class ErrorResponseEntity {
    private List<String> errors = new ArrayList<>();

    void withError(DomainBusinessException error) {
        errors.add(error.getMessage());
    }
}
