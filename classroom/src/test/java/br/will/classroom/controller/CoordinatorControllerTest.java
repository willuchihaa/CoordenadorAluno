package br.will.classroom.controller;

import br.will.classroom.controller.dto.CoordinatorDto;
import br.will.classroom.model.coordinator.Coordinator;
import br.will.classroom.repository.CoordinatorRepository;
import br.will.classroom.service.CoordinatorService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.http.ResponseEntity;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class CoordinatorControllerTest {

    @InjectMocks
    private CoordinatorController coordinatorController;
    @Mock
    private CoordinatorService coordinatorService;
    @Mock
    private CoordinatorRepository coordinatorRepository;
    @Mock
    private Coordinator coordinator;
    @Mock
    private CoordinatorDto coordinatorDto;

    @BeforeEach
    void setup() {
        coordinatorDto = new Coordinator(
                1L,
                "Mano",
                "mano123",
                "mano@gmail.com"
        ).convert();;
    }

    @Test
    @DisplayName("Must Save Coordinator ")
    void mustSaveACoordinatorUsingCoordinatorDtoReturnResponseEntity() {
        when(coordinatorService.createCoordinator(Mockito.any(CoordinatorDto.class))).thenReturn(coordinatorDto.convert());

        ResponseEntity<CoordinatorDto> result = coordinatorController.createCoordinator(coordinatorDto);

        assertNotNull(result.getBody());

        assertEquals(coordinatorDto.getId(), result.getBody().getId());
        assertEquals(coordinatorDto.getNome(), result.getBody().getNome());
        assertEquals(coordinatorDto.getSenha(), result.getBody().getSenha());
        assertEquals(coordinatorDto.getEmail(), result.getBody().getEmail());


    }
    @Test
    @DisplayName("Must Get Coordinator By id")
    void getCoordinatorIdReturnResponseEntity() {
        when(coordinatorService.getCoordinatorId(coordinatorDto.getId())).thenReturn(coordinatorDto.convert());

        ResponseEntity<CoordinatorDto> result = coordinatorController.getCoordinatorId(coordinatorDto.getId());

        assertNotNull(result.getBody());

        assertEquals(coordinatorDto.getId(), result.getBody().getId());
        assertEquals(coordinatorDto.getNome(), result.getBody().getNome());
        assertEquals(coordinatorDto.getSenha(), result.getBody().getSenha());
        assertEquals(coordinatorDto.getEmail(), result.getBody().getEmail());




    }

    @Test
    @DisplayName("Must Update Coordinator")
    void updateCoordinatorReturnEntity() {

        when(coordinatorService.updateCoordinator(Mockito.any(CoordinatorDto.class))).thenReturn(coordinatorDto.convert());

        ResponseEntity<CoordinatorDto> result = coordinatorController.updateCoordinator(coordinatorDto);

        assertNotNull(result.getBody());
        assertEquals(coordinatorDto.getId(), result.getBody().getId());
        assertEquals(coordinatorDto.getNome(), result.getBody().getNome());
        assertEquals(coordinatorDto.getSenha(), result.getBody().getSenha());
        assertEquals(coordinatorDto.getEmail(), result.getBody().getEmail());


    }

    @Test
    @DisplayName("Must Delete Coordinator ")
    void mustDeleteCoordinatorUsingCoordinatorDto() {
        doNothing().when(this.coordinatorService).deleteById(coordinatorDto.getId());

        ResponseEntity<Void> result = coordinatorController.deleteById(coordinatorDto.getId());

        verify(coordinatorService).deleteById(coordinatorDto.getId());

    }
}