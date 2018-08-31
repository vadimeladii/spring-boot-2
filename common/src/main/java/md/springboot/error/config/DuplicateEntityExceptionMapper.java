package md.springboot.error.config;

import md.springboot.error.DuplicateEntityException;

import javax.ws.rs.core.Response;
import javax.ws.rs.ext.ExceptionMapper;
import javax.ws.rs.ext.Provider;

@Provider
public class DuplicateEntityExceptionMapper implements ExceptionMapper<DuplicateEntityException> {

    public Response toResponse(DuplicateEntityException e) {
        return Response.status(Response.Status.INTERNAL_SERVER_ERROR)
                .entity(e.getMessageException())
                .build();
    }
}
