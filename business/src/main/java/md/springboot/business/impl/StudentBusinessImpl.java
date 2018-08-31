package md.springboot.business.impl;

import lombok.RequiredArgsConstructor;
import md.springboot.business.StudentBusiness;
import md.springboot.business.converter.StudentConverter;
import md.springboot.business.dto.Student;
import md.springboot.error.EntityNotFoundException;
import md.springboot.error.ValueExistsException;
import md.springboot.error.WrongUrlIdException;
import md.springboot.repository.StudentRepository;
import md.springboot.util.FieldName;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import static md.springboot.expression.ExpressionAsserts.verify;

/**
 * Created by veladii on 30.08.2018
 */
@Service
@RequiredArgsConstructor
public class StudentBusinessImpl implements StudentBusiness {

    private final StudentRepository repository;
    private final StudentConverter converter;

    @Override
    public List<Student> retrieve() {
        return repository.findAll().stream().map(converter::convert).collect(Collectors.toList());
    }

    @Override
    public Optional<Student> retrieveById(Long id) {
        return repository.findById(id).map(converter::convert);
    }

    @Override
    public Student create(Student dto) {
        verify(dto.getId() != null, () -> new ValueExistsException(Student.class, FieldName.ID));
        return converter.convert(repository.save(converter.reverse().convert(dto)));
    }

    @Override
    public Student edit(Long id, Student dto) {
        verify(!dto.getId().equals(id), () -> new WrongUrlIdException(Student.class, dto.getId(), id));
        verify(!repository.existsById(id), () -> new EntityNotFoundException(Student.class, id));
        return converter.convert(repository.save(converter.reverse().convert(dto)));
    }
}
