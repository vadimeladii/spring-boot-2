package md.springboot.webservice;

import io.swagger.annotations.Api;
import md.springboot.util.OffsetLimitHelper;
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
    @Path("/pagination")
    @Produces(MediaType.APPLICATION_JSON)
    Response retrievePagination(@QueryParam("page") @DefaultValue(OffsetLimitHelper.PAGE) Integer page,
                                @QueryParam("size") @DefaultValue(OffsetLimitHelper.SIZE) Integer size);

    @GET
    @Path("/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    Response retrieveById(@PathParam("id") Long id);

    @POST
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    Response create(AddressView view);

    @PUT
    @Path("/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    Response edit(@PathParam("id") Long id, AddressView view);
}
