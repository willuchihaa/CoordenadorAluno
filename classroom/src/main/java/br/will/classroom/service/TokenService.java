package br.will.classroom.service;

import br.will.classroom.model.utils.Token;

public interface TokenService {
    String criarToken(Token user);

    String getSubject(String token);

    String getIssuer(String token);
}
