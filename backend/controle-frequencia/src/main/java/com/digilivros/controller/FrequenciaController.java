package com.digilivros.controller;

import java.time.LocalDate;
import java.util.List;

import com.digilivros.models.Frequencia;
import com.digilivros.repository.FrequenciaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.digilivros.date.HandleDate;

@RestController
@RequestMapping(value = "/api")
public class FrequenciaController {
	
	@Autowired
	FrequenciaRepository frequenciaRepository;

	
	HandleDate handleDate;
	Frequencia frequencia;

	@GetMapping("/frequencia")
	public List<Frequencia> ListFrequencia() {
		return frequenciaRepository.findAll();
	}

	
	
	@PostMapping("/frequencia")
	public Frequencia  saveFrequencia(@RequestBody Frequencia frequencia) {
		frequencia.setFrequencialoc(LocalDate.now());
		return frequenciaRepository.save(frequencia);
	
       
    
 

}
}
