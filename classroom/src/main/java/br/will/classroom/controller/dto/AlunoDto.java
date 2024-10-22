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
    //converte entidade para dto
    public AlunoDto convertToDto(Aluno aluno){
        AlunoDto alunoDto = new AlunoDto();
        alunoDto.setId(aluno.getId());
        alunoDto.setNome(aluno.getNome());
        return alunoDto;

    }
    
    
}
