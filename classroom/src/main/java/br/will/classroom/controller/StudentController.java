package br.will.classroom.controller;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.will.classroom.controller.dto.StudentDto;
import br.will.classroom.model.student.Student;
import br.will.classroom.service.StudentService;
import org.springframework.web.bind.annotation.GetMapping;


@RestController
@RequestMapping("student")
public class StudentController {
    @Autowired
    private StudentService studentService;

    public StudentController(StudentService studentService) {
        this.studentService = studentService;
    }

    @ApiResponses(value = @ApiResponse(responseCode = "200", description = "save and registry "))
    @Operation(summary = "Create a Student and return status (200)", tags = "Student")
    @PostMapping
        public ResponseEntity<Student> createAluno(@RequestBody StudentDto studentDto) {
            return ResponseEntity.status(200).body(this.studentService.createAluno(studentDto));
    }
    @ApiResponses(value = @ApiResponse(responseCode = "200", description = "Get Students By Id "))
    @Operation(summary = "Get a Student by Id and return status (200)", tags = "Student")
    @GetMapping("/{id}")
        public ResponseEntity<Student> getStudentId(@PathVariable Long id) {
            return ResponseEntity.status(200).body(this.studentService.getStudentId(id));
    }
    @ApiResponses(value = @ApiResponse(responseCode = "200", description = "Find students by name "))
    @Operation(summary = "Get a Student by Name and return status (200)", tags = "Student")
    @GetMapping("/{name}")
        public ResponseEntity<StudentDto> getStudentName(@PathVariable String nome) {
            return ResponseEntity.status(200).body(this.studentService.getStudentName(nome).convert());
    }
    @ApiResponses(value = @ApiResponse(responseCode = "200", description = "Update student information"))
    @Operation(summary = "Update a Student and return the Dto", tags = "Student")
    @PutMapping(value = "/{id}")
        public ResponseEntity<StudentDto> updateStudent(@PathVariable Long id, @Valid @RequestBody StudentDto studentDto) {
            return ResponseEntity.ok().body(this.studentService.updateStudent(id, studentDto).convert());
        }
    @ApiResponses(value = @ApiResponse(responseCode = "200", description = "Delete a student by Id "))
    @Operation(summary = "Delete a student by Id and returns status (200)", tags = "Student")
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteById(@PathVariable Long id){
        this.studentService.deleteById(id);
            return ResponseEntity.noContent().build();
    }
}
