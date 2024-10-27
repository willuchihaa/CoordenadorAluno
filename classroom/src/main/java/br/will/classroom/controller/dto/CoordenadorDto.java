package br.will.classroom.controller.dto;

import br.will.classroom.model.coordenador.Coordenador;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class CoordenadorDto {
    private Long id;
    private String nome;
    private String senha;
    private String email;

    public CoordenadorDto(Coordenador coordenador) {
    }

    public Coordenador convert(){
        return new Coordenador(id,nome,senha,email);
    }



}
