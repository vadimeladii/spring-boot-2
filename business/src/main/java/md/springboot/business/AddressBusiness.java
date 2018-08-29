package md.springboot.business;

import md.springboot.business.dto.Address;

import java.util.List;

/**
 * Created by veladii on 29.08.2018
 */
public interface AddressBusiness {
    List<Address> retrieve();
}
