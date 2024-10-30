package br.will.classroom.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.will.classroom.model.coordinator.Coordinator;
@Repository
public interface CoordinatorRepository extends JpaRepository<Coordinator, Long>{


    Coordinator findByNome(String nome);

}
