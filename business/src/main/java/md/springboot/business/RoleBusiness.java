package md.springboot.business;

import md.springboot.business.dto.Role;
import md.springboot.util.RoleType;

import java.util.Optional;

/**
 * Created by veladii on 31.08.2018
 */
public interface RoleBusiness {

    Optional<Role> retrieveByType(RoleType type);
}
