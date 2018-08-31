package md.springboot.repository;

import md.springboot.repository.entity.AddressEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * Created by veladii on 29.08.2018
 */
@Repository
public interface AddressRepository extends JpaRepository<AddressEntity, Long> {
}
