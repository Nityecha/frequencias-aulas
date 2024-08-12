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

import com.digilivros.models.Aluno;
import com.digilivros.repository.AlunoRepository;

@RestController
@RequestMapping(value = "/api")
public class AlunoController {

	@Autowired
		AlunoRepository AlunoRepository;
	
	Aluno Aluno = new  Aluno();


	@GetMapping("Aluno")
	public List<Aluno> ListAluno() {
		return AlunoRepository.findAll();
	}

	@GetMapping("/Aluno/{id}")
	public Aluno ListAlunoId(@PathVariable(value = "id") long id) {
		return AlunoRepository.findById(id);
	}
	
	
	@PostMapping("/Aluno")
	public Aluno  saveAluno(@RequestBody Aluno Aluno) {
		
	
		return AlunoRepository.save(Aluno);
	}

	
	@DeleteMapping("/Aluno")
	public void  deletAluno(@RequestBody Aluno Aluno) {
		 AlunoRepository.delete(Aluno);
	}
	
	@PutMapping("/Aluno")
	public Aluno  editAluno(@RequestBody Aluno Aluno) {
		return AlunoRepository.save(Aluno); 
	}
}
