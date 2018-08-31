package md.springboot.business.dto;

import lombok.Getter;
import lombok.Setter;

import java.util.HashSet;
import java.util.Set;

/**
 * Created by veladii on 31.08.2018
 */
@Getter
@Setter
public class User {

    private Long id;

    private String username;

    private String password;

    private Set<Role> roles = new HashSet<>();
}
