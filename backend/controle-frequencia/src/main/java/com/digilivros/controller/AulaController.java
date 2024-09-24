package com.digilivros.controller;

import java.util.List;
import java.util.Optional;

import com.digilivros.models.Aluno;
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

import com.digilivros.models.Aula;
import com.digilivros.repository.AulaRepository;

@RestController
@RequestMapping(value = "/api")

public class AulaController {
	@Autowired
    AulaRepository aulaRepository;

	@GetMapping("/aula")
	public List<Aula> ListAula() {
		return aulaRepository.findAll();
	}
	@PostMapping("/aula")
	public Aula saveAula(@RequestBody Aula aula) {
		return aulaRepository.save(aula);
	}
	@DeleteMapping("/aula/{id}")
	public ResponseEntity<Void> deletarAula(@PathVariable Long id) {
		Optional<Aula> aula = aulaRepository.findById(id);

		if (aula.isPresent()) {
			aulaRepository.deleteById(id);
			return ResponseEntity.noContent().build();
		} else {
			return ResponseEntity.notFound().build();
		}
	}
	@PutMapping("/aula")
	public Aula editAula(@RequestBody Aula aula) {
		return aulaRepository.save(aula);
	}

}
