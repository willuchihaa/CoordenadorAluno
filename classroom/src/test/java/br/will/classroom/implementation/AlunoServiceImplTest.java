package br.will.classroom.implementation;

import br.will.classroom.controller.dto.AlunoDto;
import br.will.classroom.model.alunos.Aluno;
import br.will.classroom.repository.AlunoRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;

import static org.mockito.ArgumentMatchers.anyLong;
import static org.mockito.Mockito.verify;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

class AlunoServiceImplTest {
    @Mock
    private AlunoRepository alunoRepository;
    @InjectMocks
    private AlunoServiceImpl alunoServiceImpl;
    private Aluno aluno;

    @BeforeEach
    void setup(){
        //defini o aluno e os atributos que pede na classe
        //pq no create aluno, na parte de .convert falava que tava null
        aluno = new Aluno(
                1L,
                "William"
        );
        MockitoAnnotations.initMocks(this);
    }

    @Test
    @DisplayName("Deve criar alunos  com sucesso ")
    void createAluno() {

        when(this.alunoRepository.save(Mockito.any(Aluno.class))).thenReturn(aluno);

        Aluno result = this.alunoServiceImpl.createAluno(aluno.convert());

        assertEquals(aluno.getNome(), result.getNome());
        assertEquals(aluno.getId(), result.getId());

    }

    @Test
    @DisplayName("Deve pegar um aluno pelo nome com sucesso ")
    void pegarAlunosNome() {
        //quando o pegar o aluno pelo nome retorna o aluno
        when(alunoServiceImpl.pegarAlunosNome(aluno.getNome())).thenReturn(aluno);

        Aluno result = this.alunoServiceImpl.pegarAlunosNome(aluno.getNome());

        assertEquals(aluno.getNome(), result.getNome());
    }

    @Test
    @DisplayName("Deve pegar um aluno pelo id com sucesso ")
    void pegarAlunosId() {
        Optional<Aluno> cl = Optional.of(aluno);
        when(alunoRepository.findById(aluno.getId())).thenReturn(cl);
        Aluno result = this.alunoServiceImpl.pegarAlunosId(aluno.getId());
        assertEquals(aluno.getId(), result.getId());

    }

    @Test
    @DisplayName("Deve deletar um aluno pelo id com sucesso")
    void deleteById() {
        this.alunoServiceImpl.deleteById(aluno.getId());
        verify(alunoRepository).deleteById(aluno.getId());
    }


}