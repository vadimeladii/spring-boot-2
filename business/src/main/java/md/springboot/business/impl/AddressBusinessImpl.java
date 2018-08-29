package md.springboot.business.impl;

import lombok.RequiredArgsConstructor;
import md.springboot.business.AddressBusiness;
import md.springboot.business.converter.AddressConverter;
import md.springboot.business.dto.Address;
import md.springboot.repository.AddressRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

/**
 * Created by veladii on 29.08.2018
 */
@Service
@RequiredArgsConstructor
public class AddressBusinessImpl implements AddressBusiness {

    private final AddressRepository repository;
    private final AddressConverter converter;

    @Override
    public List<Address> retrieve() {
        return repository.findAll().stream().map(converter::convert).collect(Collectors.toList());
    }
}
