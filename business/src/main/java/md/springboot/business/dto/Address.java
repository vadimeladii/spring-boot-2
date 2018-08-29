package md.springboot.business.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * Created by veladii on 29.08.2018
 */
@Setter
@Getter
@NoArgsConstructor
public class Address {

    private Long id;

    private String street;

    private String city;

    private String state;

    private String zipcode;
}
