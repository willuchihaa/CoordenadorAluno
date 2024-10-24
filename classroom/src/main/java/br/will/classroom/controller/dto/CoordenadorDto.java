package br.will.classroom.controller.dto;

import br.will.classroom.model.coordenador.Coordenador;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

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

    //tinha Coordenador coordenador como parametro
    public Coordenador convert(Coordenador coordenador){
        CoordenadorDto coordenadorDto1 = new CoordenadorDto(
        this.getId(),
        this.getNome(),
        this.getSenha(),
        this.getEmail());
        //return nao tinha o convertToDto
        return coordenador;
    }


}
