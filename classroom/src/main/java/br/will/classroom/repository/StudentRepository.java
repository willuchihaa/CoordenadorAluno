package br.will.classroom.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.will.classroom.model.student.Student;
@Repository
public interface StudentRepository extends JpaRepository <Student, Long>{

    Student findByNome(String nome);
    
    
}