package br.will.classroom.model.alunos;

import br.will.classroom.controller.dto.AlunoDto;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@Table(name = "aluno")
@NoArgsConstructor
@AllArgsConstructor
public class Aluno { 
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public Long id;
    public String nome;

    public AlunoDto convert() {
        return new AlunoDto(this.getId(), this.getNome());
    }


}
