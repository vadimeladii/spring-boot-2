package md.springboot.business.impl;

import lombok.RequiredArgsConstructor;
import md.springboot.business.AddressBusiness;
import md.springboot.business.converter.AddressConverter;
import md.springboot.business.dto.Address;
import md.springboot.util.FieldName;
import md.springboot.error.EntityNotFoundException;
import md.springboot.error.ValueExistsException;
import md.springboot.error.WrongUrlIdException;
import md.springboot.repository.AddressRepository;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import static md.springboot.expression.ExpressionAsserts.verify;

/**
 * Created by veladii on 29.08.2018
 */
@Service
@RequiredArgsConstructor
public class AddressBusinessImpl implements AddressBusiness {

    private final AddressRepository repository;
    private final AddressConverter converter;

    @Value("${name}")
    private String name;

    @Override
    public List<Address> retrieve() {
        return repository.findAll().stream().map(converter::convert).collect(Collectors.toList());
    }

    @Override
    public Page<Address> retrievePagination(Integer page, Integer size) {
        return repository.findAll(PageRequest.of(page, size)).map(converter::convert);
    }

    @Override
    public Optional<Address> retrieveById(Long id) {
        return repository.findById(id).map(converter::convert);
    }

    @Override
    public Address create(Address dto) {
        verify(dto.getId() != null, () -> new ValueExistsException(Address.class, FieldName.ID));
        return converter.convert(repository.save(converter.reverse().convert(dto)));
    }

    @Override
    public Address edit(Long id, Address dto) {
        verify(!dto.getId().equals(id), () -> new WrongUrlIdException(Address.class, dto.getId(), id));
        verify(!repository.existsById(id), () -> new EntityNotFoundException(Address.class, id));
        return converter.convert(repository.save(converter.reverse().convert(dto)));
    }
}
