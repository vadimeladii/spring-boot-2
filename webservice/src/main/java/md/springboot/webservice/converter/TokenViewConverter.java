package md.springboot.webservice.converter;

import com.google.common.base.Converter;
import md.springboot.business.dto.Token;
import md.springboot.webservice.view.TokenView;
import org.springframework.stereotype.Component;

/**
 * Created by veladii on 31.08.2018
 */
@Component
public class TokenViewConverter extends Converter<TokenView, Token> {

    @Override
    protected Token doForward(TokenView view) {
        throw new UnsupportedOperationException("It is one way converter.");
    }

    @Override
    protected TokenView doBackward(Token dto) {
        TokenView view = new TokenView();
        view.setToken(dto.getToken());
        return view;
    }
}
