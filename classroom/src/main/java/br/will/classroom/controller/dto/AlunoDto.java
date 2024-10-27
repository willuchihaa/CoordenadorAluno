package br.will.classroom.controller.dto;

import br.will.classroom.model.alunos.Aluno;

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
public class AlunoDto {
    public Long id;
    public String nome;

    public AlunoDto(Aluno aluno) {
    }
    public Aluno convert(){
        return new Aluno(this.id,this.nome);
    }
}
    
