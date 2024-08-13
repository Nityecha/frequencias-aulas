package com.digilivros.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.digilivros.models.Aula;

public interface AulaRepository extends JpaRepository<Aula, Long> {
	Aula findById(long id);


}
