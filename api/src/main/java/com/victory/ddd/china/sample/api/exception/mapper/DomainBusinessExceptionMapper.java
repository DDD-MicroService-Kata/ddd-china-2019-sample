package com.victory.ddd.china.sample.api.exception.mapper;

import com.victory.ddd.china.sample.domain.build.block.DomainBusinessException;
import lombok.val;

import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.ext.ExceptionMapper;
import javax.ws.rs.ext.Provider;

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


