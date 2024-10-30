package br.will.classroom.implementation;

import java.util.List;

import br.will.classroom.controller.dto.CoordinatorExampleDto;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import br.will.classroom.controller.dto.CoordinatorDto;
import br.will.classroom.model.coordinator.Coordinator;
import br.will.classroom.repository.CoordinatorRepository;
import br.will.classroom.service.CoordinatorService;

@Service
public class CoordinatorServiceImpl implements CoordinatorService {
    private final CoordinatorRepository coordinatorRepository;

    public CoordinatorServiceImpl(CoordinatorRepository coordinatorRepository) {
        this.coordinatorRepository = coordinatorRepository;
    }

    @Override
    public Coordinator createCoordinator(CoordinatorDto coordinatorDto) {
        Coordinator coordinator = new Coordinator(coordinatorDto.getId(), coordinatorDto.getNome(), coordinatorDto.getSenha(), coordinatorDto.getEmail());
        if (coordinator.getNome() == null || coordinatorDto.getNome().isEmpty() ){
            throw new IllegalArgumentException("The Coordinator name cannot be null");
        }
        return this.coordinatorRepository.save(coordinator);
    }
    @Override
    public List<Coordinator> getAllCoordinators() {
        return this.coordinatorRepository.findAll();
    }
    @Override
    public Coordinator getCoordinatorName(String nome) {
        return this.coordinatorRepository.findByNome(nome);
    }
    @Override
    public Coordinator getCoordinatorId(Long id) {
        java.util.Optional<Coordinator> coordenador = this.coordinatorRepository.findById(id);
        return coordenador.orElse(null);
    }
    @Override
    @Transactional
    public Coordinator updateCoordinator(CoordinatorDto coordinatorDto) {
        Coordinator coordinator = this.getCoordinatorId(coordinatorDto.getId());
        coordinator.setNome(coordinatorDto.getNome() != null ? coordinatorDto.getNome() : coordinator.getNome());
        coordinator.setEmail(coordinatorDto.getEmail() != null ? coordinatorDto.getEmail() : coordinator.getEmail());
        this.coordinatorRepository.save(coordinator);
        return coordinator;
    }

    @Override
    public void deleteById(Long id) {
        this.coordinatorRepository.deleteById(id);
        }
     
}