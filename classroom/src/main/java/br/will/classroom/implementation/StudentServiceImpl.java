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
    public Student createAluno(StudentDto studentDto) {
        Student student = new Student(studentDto.getId(), studentDto.getNome());
        return this.studentRepository.save(student);
    }
    @Override
    public List<Student> getStudent() {
        return this.studentRepository.findAll();
    }

    @Override
    public Student getStudentName(String nome) {
        return this.studentRepository.findByNome(nome);
    }

    @Override
    public Student getStudentId(Long id) {
        Optional<Student> aluno = this.studentRepository.findById(id);
        return aluno.orElse(null);
    }

    @Override
    @Transactional
    public Student updateStudent(Long id, StudentDto studentDto) {
        Student student = this.getStudentId(null);
        student.setNome(studentDto.getNome() != null ? studentDto.getNome() : student.getNome());
        this.studentRepository.save(student);
        return student;
    }

    
    @Override
    public void deleteById(Long id) {
        this.studentRepository.deleteById(id);
    }

}
