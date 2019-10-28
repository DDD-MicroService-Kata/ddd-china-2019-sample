package com.victory.ddd.china.sample.adapters.rest.exception.mapper;

import com.victory.ddd.china.sample.application.build.block.ApplicationException;

import javax.ws.rs.core.Response;
import javax.ws.rs.ext.ExceptionMapper;
import javax.ws.rs.ext.Provider;

@Provider
public class ApplicationBusinessExceptionMapper implements ExceptionMapper<ApplicationException> {
    @Override
    public Response toResponse(ApplicationException exception) {
        return ErrorResponseEntity.buildResponse(exception);
    }
}
