package com.digilivros.date;

import java.time.LocalDate;

import org.springframework.beans.factory.annotation.Autowired;


import com.digilivros.models.Rent;

public class HandleDate {
	
	@Autowired
	Rent rent;
	
	 LocalDate lt   = LocalDate.now(); 
	
	public void insertCurrentDate ( ) {
		
		rent.setRentloc(lt);
		
		
		
		
	}

}
