package com.thehome.api.exceptionsmappers;
import com.thehome.api.exceptions.UnavailableException;
import com.thehome.api.utils.ResponseMapperUtils;
import jakarta.ws.rs.core.Response;
import jakarta.ws.rs.ext.ExceptionMapper;
import jakarta.ws.rs.ext.Provider;

@Provider
public class NotFoundExeptionMapper implements ExceptionMapper<UnavailableException> {

    @Override
    public Response toResponse(UnavailableException exception) {
        return ResponseMapperUtils.notFound();
    }
}
