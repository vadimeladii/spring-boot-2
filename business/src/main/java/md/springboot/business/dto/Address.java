package md.springboot.business.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.validation.constraints.NotNull;

/**
 * Created by veladii on 29.08.2018
 */
@Setter
@Getter
@NoArgsConstructor
public class Address {

    private Long id;

    @NotNull
    private String street;

    @NotNull
    private String city;

    @NotNull
    private String state;

    @NotNull
    private String zipcode;
}
