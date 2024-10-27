<<<<<<< HEAD
package br.will.classroom.model.coordenador;

import br.will.classroom.controller.dto.CoordenadorDto;
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
public class Coordenador {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public Long id;
    public String nome;
    public String senha;
    public String email;

    public Coordenador(Coordenador coordenador) {
    }

    public CoordenadorDto convert(){
        return new CoordenadorDto(new Coordenador(this.getId(),this.getNome(),this.getSenha(),this.getEmail()));
    }
    public List<CoordenadorDto> listConvert(List<Coordenador> list) {
        List<CoordenadorDto> coordinatorDto = new ArrayList<>();
        for (Coordenador i : list) {
            coordinatorDto.add(i.convert());
        }
        return coordinatorDto;
    }

}
=======
package br.will.classroom.model.coordenador;

import java.util.ArrayList;
import java.util.List;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import br.will.classroom.controller.dto.CoordenadorDto;

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
@Table (name = "coordenador")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Coordenador {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public Long id;
    public String nome;
    public String senha;
    public String email;
    
    public CoordenadorDto convert(){
        return new CoordenadorDto(this.getId(), this.getNome(), this.getSenha(), this.getEmail());
    }
    
    public List<CoordenadorDto> listConvert(List<Coordenador>list){
        List<CoordenadorDto> coordenadorDto = new ArrayList<>();
        for (Coordenador i : list) {
            coordenadorDto.add(i.convert());
        }
        return coordenadorDto;
    }
    

}
>>>>>>> f7dea330874fc6ae04f349c39c3003d9014d2796
