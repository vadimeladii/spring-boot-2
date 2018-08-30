package md.springboot.webservice.config.jersey;

import md.springboot.error.config.*;
import md.springboot.webservice.AddressController;
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
    }

    private void registerEndpoints() {
        register(AddressController.class);
        register(EntityNotFoundExceptionMapper.class);
        register(WrongUrlIdExceptionMapper.class);
        register(DuplicateEntityExceptionMapper.class);
        register(IllegalArgumentExceptionMapper.class);
        register(ValueExistsExceptionMapper.class);
    }
}
