package md.springboot.business;

import md.springboot.business.dto.Token;
import md.springboot.business.dto.User;

import java.util.Optional;

/**
 * Created by veladii on 31.08.2018
 */
public interface UserBusiness {
    Optional<User> findByUsername(String username);

    Optional<Token> login(User dto);
}
