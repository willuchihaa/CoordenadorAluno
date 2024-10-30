package br.will.classroom.implementation;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.stereotype.Service;

import br.will.classroom.model.user.User;
import br.will.classroom.model.utils.Login;
import br.will.classroom.model.utils.Token;
import br.will.classroom.service.LoginService;
import br.will.classroom.service.TokenService;

@Service
public class LoginServiceImpl implements LoginService {
    @Autowired
    private final TokenService tokenService;
    private AuthenticationManager authenticationManager;

    public LoginServiceImpl(TokenService tokenService, AuthenticationManager authenticationManager) {
        this.tokenService = tokenService;
        this.authenticationManager = authenticationManager;
    }

    @Override
    public String login(Login login) {
        var userauth = new UsernamePasswordAuthenticationToken(login, login, null);
        var auth = this.authenticationManager.authenticate(userauth);
        var user = (User) auth.getPrincipal();
        return tokenService.criarToken(new Token(user.getUsername()));
    }

    
    
}