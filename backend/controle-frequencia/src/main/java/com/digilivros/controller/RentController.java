package com.digilivros.controller;

import java.time.LocalDate;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.digilivros.date.HandleDate;
import com.digilivros.models.Rent;
import com.digilivros.repository.RentRepository;
@RestController
@RequestMapping(value = "/api")
public class RentController {
	
	@Autowired
	RentRepository rentRepository;
	
	HandleDate handleDate;
	Rent rent;

	@GetMapping("/rent")
	public List<Rent> ListRent() {
		return rentRepository.findAll();
	}

	
	
	@PostMapping("/rent")
	public Rent  saveRent(@RequestBody Rent rent) {
		rent.setRentloc(LocalDate.now());
		return rentRepository.save(rent);
	
       
    
 

}
}
