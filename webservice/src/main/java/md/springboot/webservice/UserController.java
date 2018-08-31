package md.springboot.webservice;

import io.swagger.annotations.Api;
import md.springboot.webservice.view.UserView;

import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Response;

/**
 * Created by veladii on 31.08.2018
 */
@Path("/user")
@Api(value = "User Controller Resource Endpoint")
public interface UserController {

    @POST
    @Path("/login")
    @Produces(javax.ws.rs.core.MediaType.APPLICATION_JSON)
    @Consumes(javax.ws.rs.core.MediaType.APPLICATION_JSON)
    Response login(UserView view);
}