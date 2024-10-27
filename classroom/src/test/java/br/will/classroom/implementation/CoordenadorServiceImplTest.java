package br.will.classroom.implementation;

import br.will.classroom.model.coordenador.Coordenador;
import br.will.classroom.repository.CoordenadorRepository;
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

public class CoordenadorServiceImplTest {
    @Mock
    private CoordenadorRepository coordenadorRepository;
    @InjectMocks
    private CoordenadorServiceImpl coordenadorServiceImpl;
    private Coordenador coordenador;

    @BeforeEach
    void setup() {
        coordenador = new Coordenador(
                1L,
                "Mano",
                "mano123",
                "mano@gmail.com"
        );
        MockitoAnnotations.initMocks(this);
    }


    @Test
    @DisplayName("Deve criar coordenadores com sucesso ")
    void criarCoordenador() {
        when(coordenadorRepository.save(Mockito.any(Coordenador.class))).thenReturn(coordenador);
        Coordenador result = coordenadorServiceImpl.criarCoordenador(coordenador.convert());

        assertEquals(coordenador.getId(), result.getId());
        assertEquals(coordenador.getNome(), result.getNome());
        assertEquals(coordenador.getSenha(), result.getSenha());
        assertEquals(coordenador.getEmail(), result.getEmail());
    }

    @Test
    @DisplayName("Deve pegar nomes de coordenadores com sucesso ")
    void pegarCoordenadorNome() {
        when(coordenadorServiceImpl.pegarCoordenadorNome(coordenador.getNome())).thenReturn(coordenador);
        Coordenador result = this.coordenadorServiceImpl.pegarCoordenadorNome(coordenador.getNome());
        assertEquals(coordenador.getNome(), result.getNome());
    }
    @Test
    @DisplayName("Deve pegar um coordenador pelo id com sucesso")
    void pegarCoordenadorId() {
    Optional<Coordenador> cl = Optional.of(coordenador);
    when(coordenadorRepository.findById(coordenador.getId())).thenReturn(cl);
    Coordenador result = this.coordenadorServiceImpl.pegarCoordenadorId(coordenador.getId());
    assertEquals(coordenador.getId(), result.getId());


    }
    @Test
    @DisplayName("Deve atualizar um coordenador id com sucesso")
    void atualizarCoordenador() {
        Optional<Coordenador> cl = Optional.of(coordenador);
        when(coordenadorRepository.save(Mockito.any(Coordenador.class))).thenReturn(coordenador);
        when(coordenadorRepository.findById(coordenador.getId())).thenReturn(cl);
        Coordenador result = coordenadorServiceImpl.atualizarCoordenador(coordenador.convert());
        assertNotNull(result);

    }

    @Test
    @DisplayName("Deve deletar um coordenador pelo id com sucesso")
    void deleteById() {
    this.coordenadorServiceImpl.deleteById(coordenador.getId());
    verify(coordenadorRepository).deleteById(coordenador.getId());
    }
}





