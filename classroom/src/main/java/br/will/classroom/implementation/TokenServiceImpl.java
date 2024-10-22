package br.will.classroom.implementation;

import org.springframework.stereotype.Service;
import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;
import java.time.LocalDateTime;
import java.time.ZoneOffset;

import br.will.classroom.model.utils.Token;
import br.will.classroom.service.TokenService;

@Service
public class TokenServiceImpl implements TokenService{
    @Override
    public String criarToken(Token user) {
        return JWT.create()
        .withClaim("nome", user.nome())
        .withExpiresAt(LocalDateTime.now().plusHours(1)
        .toInstant(ZoneOffset.of("-03:00"))).sign(Algorithm.HMAC256("chavbe"));
    }

    @Override
    public String getSubject(String token) {
        return JWT.decode(token).getSubject();
    }

    @Override
    public String getIssuer(String token) {
        return JWT.require(Algorithm.HMAC256("chave"))
        .build().verify(token).getIssuer();
    }
    
}
