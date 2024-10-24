package br.will.classroom.config;

import java.io.IOException;

import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import br.will.classroom.model.alunos.Aluno;
import br.will.classroom.model.coordenador.Coordenador;
import br.will.classroom.repository.AlunoRepository;
import br.will.classroom.repository.CoordenadorRepository;
import br.will.classroom.service.TokenService;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@Component
public class SecurityFilter extends OncePerRequestFilter {
    private TokenService tokenService;
    private AlunoRepository alunoRepository;
    private CoordenadorRepository coordenadorRepository;

    public SecurityFilter(TokenService tokenService, AlunoRepository alunoRepository,CoordenadorRepository coordenadorRepository) {
        this.tokenService = tokenService;
        this.alunoRepository = alunoRepository;
        this.coordenadorRepository = coordenadorRepository;
    }

    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain)
            throws ServletException, IOException {
        String authorization = request.getHeader("authorized");
        if (authorization != null) {
            String token = authorization.replace("Bearer", "");
            String nome = tokenService.getIssuer(token);

            switch (nome) {
                case "ESTUDANTE": {
                    Aluno aluno = this.alunoRepository.findByNome(nome);
                    var main = new UsernamePasswordAuthenticationToken(aluno, null);
                    SecurityContextHolder.getContext().setAuthentication(main);
                    break;
                }
                case "COORDENADOR": {
                    Coordenador coordenador = this.coordenadorRepository.findByNome(authorization);
                    var main = new UsernamePasswordAuthenticationToken(coordenador, null);
                    SecurityContextHolder.getContext().setAuthentication(main);
                    break;
                }
                default:
                  break;
            }
            response.setHeader("Authorization", token);
        }
        filterChain.doFilter(request, response);
    } 
}
