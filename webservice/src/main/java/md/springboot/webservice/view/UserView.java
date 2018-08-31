package md.springboot.webservice.view;

import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;

/**
 * Created by veladii on 31.08.2018
 */
@Getter
@Setter
public class UserView implements Serializable {

    private static final long serialVersionUID = 8128290289723415885L;
    
    private String username;

    private String password;
}
