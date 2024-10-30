package br.will.classroom.implementation;

import br.will.classroom.controller.dto.CoordinatorDto;
import br.will.classroom.controller.dto.StudentDto;
import br.will.classroom.model.coordinator.Coordinator;
import br.will.classroom.model.student.Student;
import br.will.classroom.repository.StudentRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;

import static org.mockito.ArgumentMatchers.anyString;

import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

class StudentServiceImplTest {
    @Mock
    private StudentRepository studentRepository;

    @InjectMocks
    private StudentServiceImpl studentServiceImpl;
    private Student student;

    @BeforeEach
    void setup(){
        student = new Student(
                1L,
                "William"
        );
        MockitoAnnotations.initMocks(this);
    }

    @Test
    @DisplayName("Must Create Students ")
    void shouldCreateStudentWhenSavedWithStudentDto() {
        when(studentRepository.save(Mockito.any(Student.class))).thenReturn(student);
        Student result = studentServiceImpl.createStudent(student.convert());
        assertEquals(student.getId(), result.getId());
        assertEquals(student.getNome(), result.getNome());
    }
    @Test
    @DisplayName("Must ThrowAIllegalStateException ")
    void shouldThrowAIllegalStateExceptionWhenCreateStudentWithNameIsNull(){
        StudentDto studentDto = new StudentDto();
        studentDto.setNome(null);
        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
            studentServiceImpl.createStudent(studentDto);
        });
        assertEquals("The Student name cannot be null", exception.getMessage());
    }


    @Test
    void shouldThrowAIllegalStateExceptionWhenCreateStudentWithNameEmpty(){

    }

    @Test
    @DisplayName("Must Get Students With Name ")
    void shouldGetStudenNameAndReturnStudent() {
        when(studentServiceImpl.getStudentName(anyString())).thenReturn(student);
        Student result = this.studentServiceImpl.getStudentName(student.getNome());
        assertEquals(student.getId(), result.getId());
        assertEquals(student.getNome(), result.getNome());
    }

    @Test
    @DisplayName("Must Get Student With Id ")
    void shouldGetStudentIdAndReturnStudent() {
        Optional<Student> cl = Optional.of(student);
        when(studentRepository.findById(student.getId())).thenReturn(cl);
        Student result = this.studentServiceImpl.getStudentId(student.getId());
        assertEquals(student.getId(), result.getId());
        assertEquals(student.getNome(), result.getNome());

    }

    @Test
    @DisplayName("Must Delete Student With Id")
    void shouldDeleteAStuentWithId() {
        this.studentServiceImpl.deleteById(student.getId());
        verify(studentRepository).deleteById(student.getId());
    }


}