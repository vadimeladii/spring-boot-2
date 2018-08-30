package md.springboot.repository;

import md.springboot.repository.entity.StudentEntity;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Created by veladii on 30.08.2018
 */
public interface StudentRepository extends JpaRepository<StudentEntity, Long> {
}
