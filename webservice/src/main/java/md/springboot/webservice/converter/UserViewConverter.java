package md.springboot.webservice.converter;

import com.google.common.base.Converter;
import md.springboot.business.dto.User;
import md.springboot.webservice.view.UserView;
import org.springframework.stereotype.Component;

/**
 * Created by veladii on 31.08.2018
 */
@Component
public class UserViewConverter extends Converter<UserView, User> {

    @Override
    protected User doForward(UserView view) {
        User dto = new User();
        dto.setUsername(view.getUsername());
        dto.setPassword(view.getPassword());
        return dto;
    }

    @Override
    protected UserView doBackward(User dto) {
        UserView view = new UserView();
        view.setUsername(dto.getUsername());
        view.setPassword(dto.getPassword());
        return view;
    }
}
