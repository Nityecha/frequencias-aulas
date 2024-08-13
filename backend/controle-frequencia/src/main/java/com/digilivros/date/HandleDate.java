package com.digilivros.date;

import java.time.LocalDate;

import org.springframework.beans.factory.annotation.Autowired;


import com.digilivros.models.Frequencia;

public class HandleDate {
	
	@Autowired
	Frequencia frequencia;

	public void insertCurrentDate ( ) {
		LocalDate lt   = LocalDate.now();
		frequencia.setFrequencialoc(lt);
	}

}
