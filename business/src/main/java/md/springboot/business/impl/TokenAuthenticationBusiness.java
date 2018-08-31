package md.springboot.business.impl;

import md.springboot.business.dto.UserAuthentication;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpServletRequest;
import java.util.Optional;

/**
 * Created by veladii on 31.08.2018
 */
@Component
public class TokenAuthenticationBusiness {

    public static String AUTH_TOKEN_HEADER = "X-Auth-Token";

    @Autowired
    private UserSecurityBusiness userSecurityBusiness;

    @Autowired
    private TokenHandler tokenHandler;

    public Optional<Authentication> getAuthentication(HttpServletRequest request) {
        return Optional.ofNullable(
                request.getHeader(AUTH_TOKEN_HEADER))
                .flatMap(tokenHandler::extractUserName)
                .map(userSecurityBusiness::loadUserByUsername)
                .map(UserAuthentication::new);

    }
}
