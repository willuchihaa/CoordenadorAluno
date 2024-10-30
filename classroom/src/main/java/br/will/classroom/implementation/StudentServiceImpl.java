package br.will.classroom.implementation;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import br.will.classroom.controller.dto.StudentDto;
import br.will.classroom.model.student.Student;
import br.will.classroom.repository.StudentRepository;
import br.will.classroom.service.StudentService;

@Service
public class StudentServiceImpl implements StudentService {
    private final StudentRepository studentRepository;

    public StudentServiceImpl(StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }
    @Override
    public Student createStudent(StudentDto studentDto) {
        Student student = new Student(studentDto.getId(), studentDto.getNome());
        if (student.getNome() == null || student.getNome().isEmpty() ){
            throw new IllegalArgumentException("The Student name cannot be null");
        }
        return this.studentRepository.save(student);
    }
    @Override
    public List<Student> getStudent() {
        return this.studentRepository.findAll();
    }

    @Override
    public Student getStudentName(String nome) {
        return studentRepository.findByNome(nome);
    }

    @Override
    public Student getStudentId(Long id) {
        Optional<Student> student = this.studentRepository.findById(id);
        return student.orElse(null);
    }

    @Override
    @Transactional
    public Student updateStudent(StudentDto studentDto) {
        Student student = this.getStudentId(studentDto.getId());
        student.setNome(studentDto.getNome() != null ? studentDto.getNome() : student.getNome());
        //essa linha nao existia
        student.setId(studentDto.getId() != null ? studentDto.getId() : student.getId());
        this.studentRepository.save(student);
        return student;
    }

    
    @Override
    public void deleteById(Long id) {
        this.studentRepository.deleteById(id);
    }

}
