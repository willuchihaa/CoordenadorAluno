package br.will.classroom.service;

import java.util.List;

import br.will.classroom.controller.dto.StudentDto;
import br.will.classroom.model.student.Student;

public interface StudentService {
    Student createAluno(StudentDto studentDto);

    List<Student> getStudent();

    Student getStudentName(String name);

    Student getStudentId(Long id);

    Student updateStudent(Long id, StudentDto studentDto);

    void deleteById(Long id);
}