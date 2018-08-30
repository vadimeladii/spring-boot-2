package md.springboot.business.converter;

import com.google.common.base.Converter;
import lombok.RequiredArgsConstructor;
import md.springboot.business.dto.Student;
import md.springboot.repository.entity.StudentEntity;
import org.springframework.stereotype.Component;

/**
 * Created by veladii on 30.08.2018
 */
@Component
@RequiredArgsConstructor
public class StudentConverter extends Converter<StudentEntity, Student> {

    private final AddressConverter addressConverter;

    @Override
    protected Student doForward(StudentEntity entity) {
        Student dto = new Student();
        dto.setId(entity.getId());
        dto.setName(entity.getName());
        dto.setAddress(addressConverter.convert(entity.getAddress()));
        return dto;
    }

    @Override
    protected StudentEntity doBackward(Student dto) {
        StudentEntity entity = new StudentEntity();
        entity.setId(dto.getId());
        entity.setName(dto.getName());
        entity.setAddress(addressConverter.reverse().convert(dto.getAddress()));
        return entity;
    }
}
