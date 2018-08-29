package md.springboot.business.converter;

import com.google.common.base.Converter;
import md.springboot.business.dto.Address;
import md.springboot.repository.entity.AddressEntity;
import org.springframework.stereotype.Component;

/**
 * Created by veladii on 29.08.2018
 */
@Component
public class AddressConverter extends Converter<AddressEntity, Address> {

    @Override
    protected Address doForward(AddressEntity entity) {
        Address dto = new Address();
        dto.setId(entity.getId());
        dto.setStreet(entity.getStreet());
        dto.setCity(entity.getCity());
        dto.setState(entity.getState());
        dto.setZipcode(entity.getZipcode());
        return dto;
    }

    @Override
    protected AddressEntity doBackward(Address dto) {
        AddressEntity entity = new AddressEntity();
        entity.setId(dto.getId());
        entity.setStreet(dto.getStreet());
        entity.setCity(dto.getCity());
        entity.setState(dto.getState());
        entity.setZipcode(dto.getZipcode());
        return entity;
    }
}
