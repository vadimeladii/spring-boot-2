package md.springboot.business.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.validation.constraints.NotNull;

/**
 * Created by veladii on 30.08.2018
 */
@Setter
@Getter
@NoArgsConstructor
public class Student {

    private Long id;

    @NotNull
    private String name;

    @NotNull
    private Address address;
}
