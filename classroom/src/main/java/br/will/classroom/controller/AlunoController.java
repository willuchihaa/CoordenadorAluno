package br.will.classroom.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.will.classroom.controller.dto.AlunoDto;
import br.will.classroom.model.alunos.Aluno;
import br.will.classroom.service.AlunoService;
import org.springframework.web.bind.annotation.GetMapping;


@RestController
@RequestMapping("aluno")
public class AlunoController {
    @Autowired
    private AlunoService alunoService;

    public AlunoController(AlunoService alunoService) {
        this.alunoService = alunoService;
    }
    @PostMapping("/criarAluno")
        public ResponseEntity<Aluno> createAluno(@RequestBody AlunoDto alunoDto) {
            return ResponseEntity.status(200).body(this.alunoService.createAluno(alunoDto));
    }

    @GetMapping("/pegarAlunoId {id}")
        public ResponseEntity<Aluno> pegarAlunoId(@PathVariable Long id) {
            return ResponseEntity.status(200).body(this.alunoService.pegarAlunosId(id));
    }
    @GetMapping("/pegarAlunoNome {nome}")
        public ResponseEntity<Object> pegarAlunoNome(@PathVariable String nome) {
            return ResponseEntity.status(200).body(this.alunoService.pegarAlunosNome(nome).convert());
    }
    @PutMapping(value = "/atualizarAluno")
        public ResponseEntity<Object> atualizarAluno(@RequestBody AlunoDto alunoDto) {
            return ResponseEntity.status(200).body(this.alunoService.atualizarAluno(alunoDto).convert());
        }
    @DeleteMapping("/deletarAlunoId")
    public ResponseEntity<Void> deleteById(@PathVariable Long id){
        this.alunoService.deleteById(id);
            return ResponseEntity.ok().build();
    }
}
