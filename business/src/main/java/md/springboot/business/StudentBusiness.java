package md.springboot.business;

import md.springboot.business.dto.Student;

import java.util.List;
import java.util.Optional;

/**
 * Created by veladii on 30.08.2018
 */
public interface StudentBusiness {
    List<Student> retrieve();

    Optional<Student> retrieveById(Long id);
}
