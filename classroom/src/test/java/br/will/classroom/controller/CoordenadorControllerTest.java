package br.will.classroom.controller;

import br.will.classroom.controller.dto.CoordenadorDto;
import br.will.classroom.implementation.CoordenadorServiceImpl;
import br.will.classroom.model.coordenador.Coordenador;
import br.will.classroom.service.CoordenadorService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.http.ResponseEntity;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
public class CoordenadorControllerTest {
    @Mock
    private CoordenadorService coordenadorService;

    @InjectMocks
    private CoordenadorController coordenadorController;

    private CoordenadorDto coordenadorDto;
    private Coordenador coordenador;

    @BeforeEach
    void setup(){
        CoordenadorDto coodenador = new Coordenador(
                1L,
                "Mano",
                "mano123",
                "mano@gmail.com"
        ).convert(); MockitoAnnotations.initMocks(this);
    }
    @Test
    @DisplayName("Deve salvar um coordenador pelo controlador com sucesso e resotrnar um response entity")
    void criarCoordenador() {
        //parece que nao pode retornar pq é null, mas pra criar, tem que ser nulo, afinal ainda nao existe
        //mas em outros metodos tambem fala que o this.coordenadorDto é null entao nao sei
        when(coordenadorService.criarCoordenador(Mockito.any(Coordenador.class).convert())).thenReturn(new Coordenador(1L,"Mano","mano123","mano@gmail.com"));
        ResponseEntity<CoordenadorDto> result = coordenadorController.criarCoordenador(coordenadorDto);
        assertNotNull(result.getBody());
        assertEquals(coordenadorDto.getId(), result.getBody().getId());
        assertEquals(coordenadorDto.getNome(), result.getBody().getNome());
        assertEquals(coordenadorDto.getSenha(), result.getBody().getSenha());
        assertEquals(coordenadorDto.getEmail(), result.getBody().getEmail());


    }

    @Test
    @DisplayName("Deve criar um coordenador no controlador com sucesso e resornar um response entity")
    void pegarCoordenadorId() {



    }

    @Test
    @DisplayName("Deve criar um coordenador no controlador com sucesso e resornar um response entity")
    void atualizarCoordenador() {


    }

    @Test
    @DisplayName("Deve apagar um coordenador pelo id no controlador com sucesso e resornar um response entity")
    void deleteById() {
    doNothing().when(this.coordenadorService).deleteById(coordenadorDto.getId());
    ResponseEntity<Void> result = coordenadorController.deleteById(coordenadorDto.getId());
    verify(coordenadorService).deleteById(coordenadorDto.getId());

    }
}
