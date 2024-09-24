package com.digilivros.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.digilivros.models.Aluno;
import com.digilivros.repository.AlunoRepository;

@RestController
@RequestMapping(value = "/api")
public class AlunoController {

    @Autowired
    AlunoRepository alunoRepository;

    @GetMapping("/aluno")
    public List<Aluno> ListAluno() {
        return alunoRepository.findAll();
    }
    @GetMapping("/aluno/{name}")
    public ResponseEntity<List<Aluno>> buscarAlunoPorNome(@PathVariable String name) {
        List<Aluno> alunos = alunoRepository.findByNameContainingIgnoreCase(name);
        if (alunos.isEmpty()) {
            return ResponseEntity.notFound().build();
        } else {
            return ResponseEntity.ok(alunos);
        }
    }

    @PostMapping("/aluno")
    public Aluno saveAluno(@RequestBody Aluno Aluno) {
        return alunoRepository.save(Aluno);
    }


    @DeleteMapping("/aluno/{id}")
    public ResponseEntity<Void> deletarAluno(@PathVariable Long id) {
        Optional<Aluno> aluno = alunoRepository.findById(id);

        if (aluno.isPresent()) {
            alunoRepository.deleteById(id);
            return ResponseEntity.noContent().build();
        } else {
            return ResponseEntity.notFound().build();
        }
    }


    @PutMapping("/aluno")
    public Aluno editAluno(@RequestBody Aluno Aluno) {
        return alunoRepository.save(Aluno);
    }
}
