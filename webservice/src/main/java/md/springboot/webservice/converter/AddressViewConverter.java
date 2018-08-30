package md.springboot.webservice.converter;

import com.google.common.base.Converter;
import md.springboot.business.dto.Address;
import md.springboot.webservice.view.AddressView;
import org.springframework.stereotype.Component;

/**
 * Created by veladii on 29.08.2018
 */

@Component
public class AddressViewConverter extends Converter<Address, AddressView> {

    @Override
    protected AddressView doForward(Address dto) {
        AddressView view = new AddressView();
        view.setId(dto.getId());
        view.setStreet(dto.getStreet());
        view.setCity(dto.getCity());
        view.setState(dto.getState());
        view.setZipcode(dto.getZipcode());
        return view;
    }

    @Override
    protected Address doBackward(AddressView view) {
        Address dto = new Address();
        dto.setId(view.getId());
        dto.setStreet(view.getStreet());
        dto.setCity(view.getCity());
        dto.setState(view.getState());
        dto.setZipcode(view.getZipcode());
        return dto;
    }
}
