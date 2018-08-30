package md.springboot.business.impl;

import lombok.RequiredArgsConstructor;
import md.springboot.business.StudentBusiness;
import md.springboot.business.converter.StudentConverter;
import md.springboot.business.dto.Student;
import md.springboot.repository.StudentRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

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
}
