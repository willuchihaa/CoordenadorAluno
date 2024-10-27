package br.will.classroom.controller;

import br.will.classroom.controller.dto.CoordenadorDto;
import br.will.classroom.implementation.CoordenadorServiceImpl;
import br.will.classroom.model.coordenador.Coordenador;
import br.will.classroom.repository.CoordenadorRepository;
import br.will.classroom.service.CoordenadorService;
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
class CoordenadorControllerTest {

    @InjectMocks
    private CoordenadorController coordenadorController;
    @Mock
    private CoordenadorService coordenadorService;
    @Mock
    private CoordenadorRepository coordenadorRepository;
    @Mock
    private Coordenador coordenador;
    @Mock
    private CoordenadorDto coordenadorDto;

    @BeforeEach
    void setup() {
        coordenadorDto = new Coordenador(
                1L,
                "Mano",
                "mano123",
                "mano@gmail.com"
        ).convert();;
    }

    @Test
    @DisplayName("Deve salvar um coordenador ")
    void deveSalvarUmCoordenadorComSucessoUsandoCoordenadorDtoRetornarResponseEntity() {
        when(coordenadorService.criarCoordenador(Mockito.any(CoordenadorDto.class))).thenReturn(coordenadorDto.convert());

        ResponseEntity<CoordenadorDto> result = coordenadorController.criarCoordenador(coordenadorDto);

        assertNotNull(result.getBody());

        assertEquals(coordenadorDto.getId(), result.getBody().getId());
        assertEquals(coordenadorDto.getNome(), result.getBody().getNome());
        assertEquals(coordenadorDto.getSenha(), result.getBody().getSenha());
        assertEquals(coordenadorDto.getEmail(), result.getBody().getEmail());


    }
    @Test
    @DisplayName("Deve pegar um coordenador id")
    void pegarCoordenadorIdRetornarResponseEntityQuandoSucesso() {
        when(coordenadorService.pegarCoordenadorId(coordenadorDto.getId())).thenReturn(coordenadorDto.convert());

        ResponseEntity<CoordenadorDto> result = coordenadorController.pegarCoordenadorId(coordenadorDto.getId());

        assertNotNull(result.getBody());

        assertEquals(coordenadorDto.getId(), result.getBody().getId());
        assertEquals(coordenadorDto.getNome(), result.getBody().getNome());
        assertEquals(coordenadorDto.getSenha(), result.getBody().getSenha());
        assertEquals(coordenadorDto.getEmail(), result.getBody().getEmail());




    }

    @Test
    @DisplayName("Deve atualizar coordenador")
    void atualizarCoordenadorRetornarEntityQuandoSucesso() {

        when(coordenadorService.atualizarCoordenador(Mockito.any(CoordenadorDto.class))).thenReturn(coordenadorDto.convert());

        ResponseEntity<CoordenadorDto> result = coordenadorController.atualizarCoordenador(coordenadorDto);

        assertNotNull(result.getBody());
        assertEquals(coordenadorDto.getId(), result.getBody().getId());
        assertEquals(coordenadorDto.getNome(), result.getBody().getNome());
        assertEquals(coordenadorDto.getSenha(), result.getBody().getSenha());
        assertEquals(coordenadorDto.getEmail(), result.getBody().getEmail());


    }

    @Test
    @DisplayName("Deve apagar um coordenador ")
    void deveDeletarCoordenadorComSucessoUsandoCoordenadorDto() {
        doNothing().when(this.coordenadorService).deleteById(coordenadorDto.getId());

        ResponseEntity<Void> result = coordenadorController.deleteById(coordenadorDto.getId());

        verify(coordenadorService).deleteById(coordenadorDto.getId());

    }
}