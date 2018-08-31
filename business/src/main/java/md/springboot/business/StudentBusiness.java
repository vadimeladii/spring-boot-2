package md.springboot.business;

import md.springboot.business.dto.Student;
import org.springframework.validation.annotation.Validated;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import java.util.List;
import java.util.Optional;

/**
 * Created by veladii on 30.08.2018
 */
@Validated
public interface StudentBusiness {
    List<Student> retrieve();

    Optional<Student> retrieveById(@NotNull Long id);

    Student create(@Valid Student dto);

    Student edit(@NotNull Long id, @Valid Student dto);
}
