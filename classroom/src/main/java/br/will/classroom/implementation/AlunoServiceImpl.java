package br.will.classroom.implementation;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import br.will.classroom.controller.dto.AlunoDto;
import br.will.classroom.model.alunos.Aluno;
import br.will.classroom.repository.AlunoRepository;
import br.will.classroom.service.AlunoService;

@Service
public class AlunoServiceImpl implements AlunoService{
    private final AlunoRepository alunoRepository;

    public AlunoServiceImpl(AlunoRepository alunoRepository) {
        this.alunoRepository = alunoRepository;
    }

    @Override
    public Aluno createAluno(AlunoDto alunoDto) {
        Aluno aluno = new Aluno();
        return this.alunoRepository.save(aluno);
    }

    @Override
    public List<Aluno> pegarAlunos() {
        return this.alunoRepository.findAll();
    }

    @Override
    public Aluno pegarAlunosNome(String nome) {
        return this.alunoRepository.findByNome(nome);
    }

    @Override
    public Aluno pegarAlunosId(Long id) {
        Optional<Aluno> aluno = this.alunoRepository.findById(id);
        return aluno.orElse(null);
    }

    @Override
    @Transactional
    public Aluno atualizarAluno(AlunoDto alunoDto) {
        Aluno aluno = this.pegarAlunosId(null);
        aluno.setNome(alunoDto.getNome() != null ? alunoDto.getNome() : aluno.getNome());
        this.alunoRepository.save(aluno);
        return aluno;
    }

    
    @Override
    public void deleteById(Long id) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'deleteById'");
    }
    
}
