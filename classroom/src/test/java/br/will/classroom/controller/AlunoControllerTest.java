<<<<<<< HEAD
package br.will.classroom.controller;

import br.will.classroom.controller.dto.AlunoDto;
import br.will.classroom.implementation.AlunoServiceImpl;
import br.will.classroom.model.alunos.Aluno;
import br.will.classroom.repository.AlunoRepository;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import org.junit.jupiter.api.extension.ExtendWith;

import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.http.ResponseEntity;

import static org.junit.jupiter.api.Assertions.assertEquals;

import static junit.framework.Assert.assertEquals;
import static junit.framework.Assert.assertNotNull;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
public class AlunoControllerTest {
    @InjectMocks
    private AlunoController alunoController;
    @Mock
    private AlunoServiceImpl alunoServiceImpl;
    @Mock
    private AlunoRepository alunoRepository;
    @Mock
    private AlunoDto alunoDto;
    @Mock
    private Aluno aluno;


    @BeforeEach
    void setup(){
        alunoDto = new Aluno(
                1L,
                "William"
        ).convert();
    }

    @Test
    @DisplayName("Deve salvar um aluno ")
    void deveSalvarUmAlunoComAlunoDtoComSucesso() {
        when(alunoServiceImpl.createAluno(Mockito.any(AlunoDto.class))).thenReturn(alunoDto.convert());
        AlunoDto result = alunoController.createAluno(alunoDto).getBody().convert();

        assertNotNull(result);
        assertEquals(alunoDto.getId(), result.getId());
        assertEquals(alunoDto.getNome(), result.getNome());

    }

    @Test
    @DisplayName("Deve Pegar Um Aluno Id ")
    void devePegarUmAlunoPeloIdUsandoAlunoDtoComSucesso() {
        when(alunoServiceImpl.pegarAlunosId(alunoDto.getId())).thenReturn(alunoDto.convert());
        ResponseEntity<Aluno> result = alunoController.pegarAlunoId(alunoDto.getId());

        assertNotNull(result.getBody());

        assertEquals(alunoDto.getId(), result.getBody().getId());
        assertEquals(alunoDto.getId(), result.getBody().getId());




    }

    @Test
    @DisplayName("Deve Alutalizar Um Aluno ")

    void atualizarAluno() {
        when(alunoServiceImpl.atualizarAluno(Mockito.any(AlunoDto.class))).thenReturn(alunoDto.convert());

        ResponseEntity<AlunoDto> result = alunoController.atualizarAluno(alunoDto);
        Assertions.assertNotNull(result.getBody());
        assertEquals(alunoDto.getId(), result.getBody().getId());
        assertEquals(alunoDto.getId(), result.getBody().getId());

    }

    @Test
    @DisplayName("Deve Deletar Um Aluno Id ")
    void deveDeletarUmAlunoPeloIdUsandoAlunoDtoComSucesso() {
        doNothing().when(this.alunoServiceImpl).deleteById(alunoDto.getId());
        ResponseEntity<Void> result = alunoController.deleteById(alunoDto.getId());
        verify(alunoServiceImpl).deleteById(alunoDto.getId());
    }
}
=======
package br.will.classroom.controller;

import org.junit.jupiter.api.Test;

public class AlunoControllerTest {

    @Test
    void createAluno() {
    }

    @Test
    void pegarAlunoId() {
    }

    @Test
    void atualizarAluno() {
    }

    @Test
    void deleteById() {
    }
}
>>>>>>> f7dea330874fc6ae04f349c39c3003d9014d2796
