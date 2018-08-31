package md.springboot.business.converter;

import com.google.common.base.Converter;
import lombok.RequiredArgsConstructor;
import md.springboot.business.dto.User;
import md.springboot.repository.entity.UserEntity;
import org.springframework.stereotype.Component;

import java.util.stream.Collectors;

/**
 * Created by veladii on 31.08.2018
 */
@Component
@RequiredArgsConstructor
public class UserConverter extends Converter<User, UserEntity> {

    private final RoleConverter roleConverter;

    @Override
    protected UserEntity doForward(User dto) {
        UserEntity entity = new UserEntity();
        entity.setId(dto.getId());
        entity.setPassword(dto.getPassword());
        entity.setUsername(dto.getUsername());
        entity.setRoles(
                dto.getRoles()
                        .stream()
                        .map(roleConverter::convert)
                        .collect(Collectors.toSet())
        );
        return entity;
    }

    @Override
    protected User doBackward(UserEntity entity) {
        User dto = new User();
        dto.setUsername(entity.getUsername());
        dto.setPassword(entity.getPassword());
        dto.setRoles(
                entity.getRoles()
                        .stream()
                        .map(roleConverter.reverse()::convert)
                        .collect(Collectors.toSet())
        );
        return dto;
    }
}
