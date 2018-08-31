package md.springboot.webservice.view;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;

/**
 * Created by veladii on 29.08.2018
 */
@Setter
@Getter
@NoArgsConstructor
public class AddressView implements Serializable {

    private static final long serialVersionUID = 7226260506120493512L;

    private Long id;

    private String street;

    private String city;

    private String state;

    private String zipcode;
}
