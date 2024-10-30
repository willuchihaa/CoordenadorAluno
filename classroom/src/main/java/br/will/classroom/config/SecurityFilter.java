package br.will.classroom.config;

import java.io.IOException;

import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import br.will.classroom.model.student.Student;
import br.will.classroom.model.coordinator.Coordinator;
import br.will.classroom.repository.StudentRepository;
import br.will.classroom.repository.CoordinatorRepository;
import br.will.classroom.service.TokenService;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@Component
public class SecurityFilter extends OncePerRequestFilter {
    private TokenService tokenService;
    private StudentRepository studentRepository;
    private CoordinatorRepository coordinatorRepository;

    public SecurityFilter(TokenService tokenService, StudentRepository studentRepository, CoordinatorRepository coordinatorRepository) {
        this.tokenService = tokenService;
        this.studentRepository = studentRepository;
        this.coordinatorRepository = coordinatorRepository;
    }

    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain)
            throws ServletException, IOException {
        String authorization = request.getHeader("authorized");
        if (authorization != null) {
            String token = authorization.replace("Bearer", "");
            String nome = tokenService.getIssuer(token);

            switch (nome) {
                case "STUDENT": {
                    Student student = this.studentRepository.findByNome(nome);
                    var main = new UsernamePasswordAuthenticationToken(student, null);
                    SecurityContextHolder.getContext().setAuthentication(main);
                    break;
                }
                case "COORDINATOR": {
                    Coordinator coordinator = this.coordinatorRepository.findByNome(authorization);
                    var main = new UsernamePasswordAuthenticationToken(coordinator, null);
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