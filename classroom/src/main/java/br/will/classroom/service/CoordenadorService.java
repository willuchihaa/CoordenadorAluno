package br.will.classroom.service;

import java.util.List;

import br.will.classroom.controller.dto.CoordenadorDto;
import br.will.classroom.model.coordenador.Coordenador;

public interface CoordenadorService {
    Coordenador criarCoordenador(CoordenadorDto coordenadorDto);

    List<Coordenador> pegarCoordenadores();

    Coordenador pegarCoordenadorNome(String name);

    Coordenador pegarCoordenadorId(Long id);

    Coordenador atualizarCoordenador(CoordenadorDto coordenadorDto);

    void deleteById(Long id);

}
