package br.will.classroom.service;

import java.util.List;

import br.will.classroom.controller.dto.AlunoDto;
import br.will.classroom.model.alunos.Aluno;

public interface AlunoService {
    Aluno createAluno(AlunoDto alunoDto);

    List<Aluno> pegarAlunos();

    Aluno pegarAlunosNome(String name);

    Aluno pegarAlunosId(Long id);

    Aluno atualizarAluno(AlunoDto alunoDto);

    void deleteById(Long id);
}
