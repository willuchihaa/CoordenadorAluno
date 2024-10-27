<<<<<<< HEAD
package br.will.classroom.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.will.classroom.model.alunos.Aluno;
@Repository
public interface AlunoRepository extends JpaRepository <Aluno, Long>{

    Aluno findByNome(String nome);
    
    
}
=======
package br.will.classroom.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.will.classroom.model.alunos.Aluno;
@Repository
public interface AlunoRepository extends JpaRepository <Aluno, Long>{

    Aluno findByNome(String nome);
    
    
}
>>>>>>> f7dea330874fc6ae04f349c39c3003d9014d2796
