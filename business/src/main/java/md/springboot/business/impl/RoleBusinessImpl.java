package md.springboot.business.impl;

import lombok.RequiredArgsConstructor;
import md.springboot.business.RoleBusiness;
import md.springboot.business.converter.RoleConverter;
import md.springboot.business.dto.Role;
import md.springboot.repository.RoleRepository;
import md.springboot.util.RoleType;
import org.springframework.stereotype.Service;

import java.util.Optional;

/**
 * Created by veladii on 31.08.2018
 */
@Service
@RequiredArgsConstructor
public class RoleBusinessImpl implements RoleBusiness {

    private final RoleRepository repository;
    private final RoleConverter converter;

    public Optional<Role> retrieveByType(RoleType type) {
        return Optional.ofNullable(converter.reverse().convert(repository.findByType(type.name())));
    }
}
