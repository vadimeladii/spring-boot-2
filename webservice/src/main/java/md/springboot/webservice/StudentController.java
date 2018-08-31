package md.springboot.webservice;

import io.swagger.annotations.Api;
import md.springboot.webservice.view.StudentView;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

/**
 * Created by veladii on 30.08.2018
 */
@Path("/student")
@Api(value = "Student Controller Resource Endpoint")
public interface StudentController {

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
    Response create(StudentView view);

    @PUT
    @Path("/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    Response edit(@PathParam("id") Long id, StudentView view);
}
