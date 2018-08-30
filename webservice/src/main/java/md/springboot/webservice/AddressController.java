package md.springboot.webservice;

import io.swagger.annotations.Api;
import md.springboot.webservice.view.AddressView;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

/**
 * Created by veladii on 29.08.2018
 */
@Path("/address")
@Api(value = "Address Controller Resource Endpoint")
public interface AddressController {

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    Response retrieve();

    @GET
    @Path("/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    Response retrieveById(@PathParam("id") Long id);

    @POST
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    Response create(AddressView view);
}
