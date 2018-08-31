package md.springboot.error.config;

import md.springboot.error.ValueExistsException;

import javax.ws.rs.core.Response;
import javax.ws.rs.ext.ExceptionMapper;

/**
 * Created by veladii on 30.08.2018
 */
public class ValueExistsExceptionMapper implements ExceptionMapper<ValueExistsException> {
    @Override
    public Response toResponse(ValueExistsException e) {
        return Response.status(Response.Status.BAD_REQUEST)
                .entity(e.getMessageException())
                .build();

    }
}
