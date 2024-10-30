package br.will.classroom.controller;

import br.will.classroom.controller.dto.StudentDto;
import br.will.classroom.implementation.StudentServiceImpl;
import br.will.classroom.model.student.Student;
import br.will.classroom.repository.StudentRepository;

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
public class StudentControllerTest {
    @InjectMocks
    private StudentController studentController;
    @Mock
    private StudentServiceImpl alunoServiceImpl;
    @Mock
    private StudentRepository studentRepository;
    @Mock
    private StudentDto studentDto;
    @Mock
    private Student student;

    @BeforeEach
    void setup(){
        studentDto = new Student(
                1L,
                "William"
        ).convert();
    }
    @Test
    @DisplayName("Must Save Student ")
    void mustSaveStudentWithAlunoDto() {
        when(alunoServiceImpl.createAluno(Mockito.any(StudentDto.class))).thenReturn(studentDto.convert());
        StudentDto result = studentController.createAluno(studentDto).getBody().convert();
        assertNotNull(result);
        assertEquals(studentDto.getId(), result.getId());
        assertEquals(studentDto.getNome(), result.getNome());

    }

    @Test
    @DisplayName("Must Get Student by Id ")
    void mustGetAnyStudentIdUsingAlunotDto() {
        when(alunoServiceImpl.getStudentId(anyLong())).thenReturn(studentDto.convert());
        ResponseEntity<Student> result = studentController.getStudentId(anyLong());
        assertNotNull(result.getBody());
        assertEquals(studentDto.getId(), result.getBody().getId());
        assertEquals(studentDto.getId(), result.getBody().getId());


    }

    @Test
    @DisplayName("Must Update Student ")
    void mustUpdateStudentWithAlunoDto() {
        when(alunoServiceImpl.updateStudent(studentDto.id, studentDto)).thenReturn(studentDto.convert());
        ResponseEntity<StudentDto> result = studentController.updateStudent(studentDto.id, studentDto);
        Assertions.assertNotNull(result.getBody());
        assertEquals(studentDto.getId(), result.getBody().getId());
        assertEquals(studentDto.getNome(), result.getBody().getNome());

    }
    @Test
    @DisplayName("Must Delete Student by Id ")
    void mustDeleteOneStudentByIdUsingAlunoDtoWithSucesso() {
        doNothing().when(this.alunoServiceImpl).deleteById(studentDto.getId());
        ResponseEntity<Void> result = studentController.deleteById(studentDto.getId());
        verify(alunoServiceImpl).deleteById(studentDto.getId());
    }
}
