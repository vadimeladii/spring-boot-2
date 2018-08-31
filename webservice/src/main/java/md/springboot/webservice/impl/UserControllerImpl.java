package md.springboot.webservice.impl;

import lombok.RequiredArgsConstructor;
import md.springboot.business.UserBusiness;
import md.springboot.webservice.UserController;
import md.springboot.webservice.converter.TokenViewConverter;
import md.springboot.webservice.converter.UserViewConverter;
import md.springboot.webservice.view.UserView;
import org.springframework.stereotype.Controller;

import javax.ws.rs.core.Response;

/**
 * Created by veladii on 31.08.2018
 */
@Controller
@RequiredArgsConstructor
public class UserControllerImpl implements UserController {

    private final UserBusiness business;
    private final UserViewConverter converter;
    private final TokenViewConverter tokenViewConverter;

    @Override
    public Response login(UserView view) {
        return Response.ok()
                .entity(business
                        .login(converter.convert(view))
                        .map(tokenViewConverter.reverse()::convert))
                .build();
    }
}
