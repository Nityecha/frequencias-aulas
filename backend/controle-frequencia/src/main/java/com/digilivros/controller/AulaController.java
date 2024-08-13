package com.digilivros.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
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
	

	@GetMapping("book")
	public List<Aula> ListBook() {
		return aulaRepository.findAll();
	}

	@GetMapping("/book/{id}")
	public Aula ListBookId(@PathVariable(value = "id") long id) {
		return aulaRepository.findById(id);
	}
	
	
	@PostMapping("/aula")
	public Aula saveBook(@RequestBody Aula aula) {
		return aulaRepository.save(aula);
	}

	@DeleteMapping("/aula")
	public void  deletBook(@RequestBody Aula aula) {
		aulaRepository.delete(aula);
	}
	
	@PutMapping("/aula")
	public Aula editBook(@RequestBody Aula aula) {
		return aulaRepository.save(aula);
	}

}
