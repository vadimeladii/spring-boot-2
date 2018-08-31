package md.springboot.webservice.config.jersey;

import io.swagger.jaxrs.config.BeanConfig;
import io.swagger.jaxrs.listing.ApiListingResource;
import io.swagger.jaxrs.listing.SwaggerSerializers;
import md.springboot.error.config.*;
import md.springboot.webservice.AddressController;
import md.springboot.webservice.StudentController;
import md.springboot.webservice.UserController;
import org.glassfish.jersey.server.ResourceConfig;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import javax.ws.rs.ApplicationPath;

@Component
@ApplicationPath("/api")
public class JerseyConfig extends ResourceConfig {

    public JerseyConfig() {
        registerEndpoints();
    }

    @PostConstruct
    public void init() {
        // Register components where DI is needed
        this.configureSwagger();
    }

    private void registerEndpoints() {
        register(AddressController.class);
        register(StudentController.class);
        register(UserController.class);
        register(EntityNotFoundExceptionMapper.class);
        register(WrongUrlIdExceptionMapper.class);
        register(DuplicateEntityExceptionMapper.class);
        register(IllegalArgumentExceptionMapper.class);
        register(ValueExistsExceptionMapper.class);
    }


    private void configureSwagger() {
        // Available at localhost:port/swagger.json
        this.register(ApiListingResource.class);
        this.register(SwaggerSerializers.class);

        BeanConfig config = new BeanConfig();
        config.setTitle("Spring boot 2");
        config.setVersion("v1");
        config.setSchemes(new String[] { "http", "https" });
        config.setResourcePackage("md.springboot.webservice");
        config.setPrettyPrint(true);
        config.setBasePath("/api");
        config.setScan(true);
    }
}
