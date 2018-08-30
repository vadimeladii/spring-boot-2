package md.springboot.business;

import md.springboot.business.dto.Address;
import org.springframework.data.domain.Page;

import java.util.List;
import java.util.Optional;

/**
 * Created by veladii on 29.08.2018
 */
public interface AddressBusiness {
    List<Address> retrieve();

    Page<Address> retrievePagination(Integer page, Integer size);

    Optional<Address> retrieveById(Long id);

    Address create(Address dto);

    Address edit(Long id, Address dto);
}
