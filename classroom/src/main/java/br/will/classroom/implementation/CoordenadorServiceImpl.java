package br.will.classroom.implementation;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import br.will.classroom.controller.dto.CoordenadorDto;
import br.will.classroom.model.coordenador.Coordenador;
import br.will.classroom.repository.CoordenadorRepository;
import br.will.classroom.service.CoordenadorService;

@Service
public class CoordenadorServiceImpl implements CoordenadorService{
    private final CoordenadorRepository coordenadorRepository;

    public CoordenadorServiceImpl(CoordenadorRepository coordenadorRepository) {
        this.coordenadorRepository = coordenadorRepository;
    }

    @Override
    public Coordenador criarCoordenador(CoordenadorDto coordenadorDto) {
        Coordenador coordenador = new Coordenador(coordenadorDto.getId(), 
        coordenadorDto.getNome(),
        coordenadorDto.getSenha(),
        coordenadorDto.getEmail());
        return this.coordenadorRepository.save(coordenador);

    }
    @Override
    public List<Coordenador> pegarCoordenadores() {
        return this.coordenadorRepository.findAll();
    }
    @Override
    public Coordenador pegarCoordenadorNome(String nome) {
        return this.coordenadorRepository.findByNome(nome);
    }
    @Override
    public Coordenador pegarCoordenadorId(Long id) {
        java.util.Optional<Coordenador> coordenador = this.coordenadorRepository.findById(id);
        return coordenador.orElse(null);
    }
    @Override
    @Transactional
    public Coordenador atualizarCoordenador(CoordenadorDto coordenadorDto) {
        Coordenador coordenador = this.pegarCoordenadorId(coordenadorDto.getId());
        coordenador.setNome(coordenadorDto.getNome() != null ? coordenadorDto.getNome() : coordenador.getNome());
        coordenador.setEmail(coordenadorDto.getEmail() != null ? coordenadorDto.getEmail() : coordenador.getEmail());
        this.coordenadorRepository.save(coordenador);
        return coordenador;
    }

    @Override
    public void deleteById(Long id) {
        this.coordenadorRepository.deleteById(id);
        }
     

    
}