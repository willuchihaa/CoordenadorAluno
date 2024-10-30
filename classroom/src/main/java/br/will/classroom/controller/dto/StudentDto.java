package br.will.classroom.controller.dto;

import br.will.classroom.model.student.Student;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
public class StudentDto {
    public Long id;
    public String nome;

    public StudentDto(Student student) {
    }
    public Student convert(){
        return new Student(this.id,this.nome);
    }
}
    
