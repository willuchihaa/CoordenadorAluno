package br.will.classroom.controller.dto;

import br.will.classroom.model.coordinator.Coordinator;
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
public class CoordinatorDto {
    private Long id;
    private String nome;
    private String senha;
    private String email;

    public CoordinatorDto convertToDto(Coordinator coordinator){
        CoordinatorDto coordinatorDto = new CoordinatorDto(
                this.getId(),
                this.getNome(),
                this.getSenha(),
                this.getEmail());
        return coordinatorDto;
    }
    public Coordinator convert(){
        return new Coordinator(this.id,this.nome,this.senha,this.email);
    }



}
