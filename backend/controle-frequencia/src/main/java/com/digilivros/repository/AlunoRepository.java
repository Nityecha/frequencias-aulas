package com.digilivros.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.digilivros.models.Aluno;

public interface AlunoRepository extends JpaRepository<Aluno, Long> {
	
	Aluno findById(long id);

}
