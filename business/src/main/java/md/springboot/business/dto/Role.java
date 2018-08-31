package md.springboot.business.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.security.core.GrantedAuthority;

/**
 * Created by veladii on 31.08.2018
 */
@Getter
@Setter
@NoArgsConstructor
public class Role implements GrantedAuthority {

    private Long id;

    private String type;

    @Override
    public String getAuthority() {
        return type;
    }
}
