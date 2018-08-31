package md.springboot.webservice.view;

import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;

/**
 * Created by veladii on 31.08.2018
 */
@Getter
@Setter
public class TokenView implements Serializable {

    private static final long serialVersionUID = -1689333681498130512L;

    private String token;
}
