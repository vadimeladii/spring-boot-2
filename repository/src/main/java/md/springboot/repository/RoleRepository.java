package md.springboot.repository;

import md.springboot.repository.entity.RoleEntity;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Created by veladii on 31.08.2018
 */
public interface RoleRepository extends JpaRepository<RoleEntity, Long> {
    RoleEntity findByType(String type);
}
