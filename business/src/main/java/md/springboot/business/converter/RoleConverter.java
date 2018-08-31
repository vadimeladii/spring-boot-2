package md.springboot.business.converter;

import com.google.common.base.Converter;
import md.springboot.business.dto.Role;
import md.springboot.repository.entity.RoleEntity;
import org.springframework.stereotype.Component;

/**
 * Created by veladii on 31.08.2018
 */
@Component
public class RoleConverter extends Converter<Role, RoleEntity> {

    @Override
    protected RoleEntity doForward(Role dto) {
        RoleEntity entity = new RoleEntity();
        entity.setId(dto.getId());
        entity.setType(dto.getType());
        return entity;
    }

    @Override
    protected Role doBackward(RoleEntity entity) {
        Role dto = new Role();
        dto.setId(entity.getId());
        dto.setType(entity.getType());
        return dto;
    }
}
