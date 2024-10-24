package br.will.classroom.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.will.classroom.model.coordenador.Coordenador;
@Repository
public interface CoordenadorRepository extends JpaRepository<Coordenador, Long>{


    Coordenador findByNome(String nome);

    //List<Coordenador> findByNome(String nome);
    
}
