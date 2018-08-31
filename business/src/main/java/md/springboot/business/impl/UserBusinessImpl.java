package md.springboot.business.impl;

import lombok.RequiredArgsConstructor;
import md.springboot.business.UserBusiness;
import md.springboot.business.converter.UserConverter;
import md.springboot.business.dto.Token;
import md.springboot.business.dto.User;
import md.springboot.repository.UserRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.Duration;
import java.time.LocalDateTime;
import java.util.Optional;

/**
 * Created by veladii on 31.08.2018
 */
@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class UserBusinessImpl implements UserBusiness {

    private final UserRepository repository;
    private final UserConverter converter;
    private final TokenHandler tokenHandler;

    @Override
    public Optional<User> findByUsername(String username) {
        return repository.findByUsername(username).map(converter.reverse()::convert);
    }

    public Optional<Token> login(User dto) {
        return repository.findByUsername(dto.getUsername())
                .flatMap(userEntity -> tokenHandler.generateAccessToken(
                        userEntity.getUsername(),
                        LocalDateTime.now().plus(Duration.ofHours(4))
                ))
                .map(Token::new);
    }
}
