package com.digilivros.models;

import java.io.Serializable;
import java.time.LocalDate;

import javax.persistence.*;

@Entity
public class Frequencia implements Serializable {

	private static final long serialVersionUID = 1L;

	public LocalDate getDataAula() {
		return dataAula;
	}

	public void setDataAula(LocalDate dataAula) {
		this.dataAula = dataAula;
	}

	public int getAluno() {
		return aluno;
	}

	public void setAluno(int aluno) {
		this.aluno = aluno;
	}

	public int getAula() {
		return aula;
	}

	public void setAula(int aula) {
		this.aula = aula;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id;

	@Column(name = "frequencialoc")
	LocalDate dataAula;

	@Column(name = "aluno_id")
	int aluno;

	@Column(name = "aula_id")
	int aula;
}
