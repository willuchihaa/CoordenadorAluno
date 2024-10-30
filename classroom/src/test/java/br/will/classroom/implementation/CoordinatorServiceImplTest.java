package br.will.classroom.implementation;

import br.will.classroom.controller.dto.CoordinatorDto;
import br.will.classroom.model.coordinator.Coordinator;
import br.will.classroom.repository.CoordinatorRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;

import java.util.Optional;

import static junit.framework.Assert.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

public class CoordinatorServiceImplTest {
    @Mock
    private CoordinatorRepository coordinatorRepository;
    @Mock
    private CoordinatorDto coordinatorDto;
    @InjectMocks
    private CoordinatorServiceImpl coordinatorServiceImpl;

    private Coordinator coordinator;

    @BeforeEach
    void setup() {
        coordinator = new Coordinator(
                1L,
                "Mano",
                "mano123",
                "mano@gmail.com"
        );
        MockitoAnnotations.initMocks(this);
    }

    @Test
    @DisplayName("Must create coordinators ")
    void criarCoordenador() {
        when(coordinatorRepository.save(Mockito.any(Coordinator.class))).thenReturn(coordinator);
        Coordinator result = coordinatorServiceImpl.createCoordinator(coordinator.convert());

        assertEquals(coordinator.getId(), result.getId());
        assertEquals(coordinator.getNome(), result.getNome());
        assertEquals(coordinator.getSenha(), result.getSenha());
        assertEquals(coordinator.getEmail(), result.getEmail());
    }

    @Test
    @DisplayName("Must get names of coordinators ")
    void pegarCoordenadorNome() {
        when(coordinatorServiceImpl.getCoordinatorName(coordinator.getNome())).thenReturn(coordinator);
        Coordinator result = this.coordinatorServiceImpl.getCoordinatorName(coordinator.getNome());
        assertEquals(coordinator.getNome(), result.getNome());
    }
    @Test
    @DisplayName("Must get a coordinator by id")
    void pegarCoordenadorId() {
    Optional<Coordinator> cl = Optional.of(coordinator);
    when(coordinatorRepository.findById(coordinator.getId())).thenReturn(cl);
    Coordinator result = this.coordinatorServiceImpl.getCoordinatorId(coordinator.getId());
    assertEquals(coordinator.getId(), result.getId());

    }

    @Test
    @DisplayName("Must delete a coordinator by id")
    void deleteById() {
    this.coordinatorServiceImpl.deleteById(coordinator.getId());
    verify(coordinatorRepository).deleteById(coordinator.getId());
    }
}





