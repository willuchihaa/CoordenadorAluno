package br.will.classroom.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.will.classroom.model.alunos.Aluno;
@Repository
public interface AlunoRepository extends JpaRepository <Aluno, Long>{

    Aluno findByNome(String nome);
    
    
}
