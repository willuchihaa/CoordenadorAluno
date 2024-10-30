package br.will.classroom.model.coordinator;

import br.will.classroom.controller.dto.CoordinatorDto;
import br.will.classroom.controller.dto.CoordinatorExampleDto;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table (name = "coordenador")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Coordinator {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public Long id;
    public String nome;
    public String senha;
    public String email;

    public Coordinator(Coordinator coordinator) {
    }

    public CoordinatorDto convert(){
        return new CoordinatorDto(this.getId(),this.getNome(),this.getSenha(),this.getEmail());
    }
    public List<CoordinatorDto> listConvert(List<Coordinator> list) {
        List<CoordinatorDto> coordinatorDto = new ArrayList<>();
        for (Coordinator i : list) {
            coordinatorDto.add(i.convert());
        }
        return coordinatorDto;
    }

}