package br.will.classroom.service;

import java.util.List;

import br.will.classroom.controller.dto.CoordinatorDto;
import br.will.classroom.controller.dto.CoordinatorExampleDto;
import br.will.classroom.model.coordinator.Coordinator;

public interface CoordinatorService {
    Coordinator createCoordinator(CoordinatorDto coordinatorDto);

    List<Coordinator> getAllCoordinators();

    Coordinator getCoordinatorName(String name);

    Coordinator getCoordinatorId(Long id);

    Coordinator updateCoordinator(CoordinatorDto coordinatorDto);

    void deleteById(Long id);

}