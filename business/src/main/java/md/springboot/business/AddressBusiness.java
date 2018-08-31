package md.springboot.business;

import md.springboot.business.dto.Address;
import org.springframework.data.domain.Page;
import org.springframework.validation.annotation.Validated;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import java.util.List;
import java.util.Optional;

/**
 * Created by veladii on 29.08.2018
 */
@Validated
public interface AddressBusiness {
    List<Address> retrieve();

    Page<Address> retrievePagination(@NotNull Integer page, @NotNull Integer size);

    Optional<Address> retrieveById(@NotNull Long id);

    Address create(@Valid Address dto);

    Address edit(@NotNull Long id, @Valid Address dto);
}
