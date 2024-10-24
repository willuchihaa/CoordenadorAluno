package br.will.classroom.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.will.classroom.controller.dto.CoordenadorDto;
import br.will.classroom.service.CoordenadorService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PutMapping;

@RestController
@RequestMapping("coordenador")
public class CoordenadorController {
    @Autowired
    private CoordenadorService coordenadorService;

    public CoordenadorController(CoordenadorService coordenadorService) {
        this.coordenadorService = coordenadorService;
    }
    @PostMapping("/criarCoordenador")
    public ResponseEntity<CoordenadorDto> criarCoordenador(@RequestBody CoordenadorDto coordenadorDto) {
        return ResponseEntity.status(200).body(this.coordenadorService.criarCoordenador(coordenadorDto).convert());
    }
    @GetMapping("/pegarCoordenadorId {id}")
    public ResponseEntity<CoordenadorDto> pegarCoordenadorId(@PathVariable Long id) {
        return ResponseEntity.status(200).body(this.coordenadorService.pegarCoordenadorId(id).convert());
    }
    @PutMapping("/atualizarCoordenador")
    public ResponseEntity <CoordenadorDto> atualizarCoordenador(@RequestBody CoordenadorDto coordenadorDto) {
        return ResponseEntity.ok().body(this.coordenadorService.atualizarCoordenador(coordenadorDto).convert());
    }
    @DeleteMapping("/deletarCoordeandorId {id}")
    public ResponseEntity<Void> deleteById(@PathVariable Long id){
        this.coordenadorService.deleteById(id);
        return ResponseEntity.ok().build();
    }
    
    
}
