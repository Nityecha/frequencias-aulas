package com.digilivros.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.digilivros.models.Aluno;

import java.util.List;

public interface AlunoRepository extends JpaRepository<Aluno, Long> {
	
	Aluno findById(long id);
	List<Aluno> findByNameContainingIgnoreCase(String name);

}
