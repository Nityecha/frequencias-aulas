package com.digilivros.models;

import java.io.Serializable;
import java.time.LocalDate;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
public class Frequencia implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id;

	private LocalDate frequencialoc;
	@OneToOne
	@JoinColumn

	private Aluno aluno;
	@OneToOne
	@JoinColumn

	private Aula book;

	public Aula getBook() {
		return book;
	}

	public void setBook(Aula book) {
		this.book = book;
	}

	public void setAluno(Aluno aluno) {
		this.aluno = aluno;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public LocalDate getFrequencialoc() {
		return frequencialoc;
	}

	public void setFrequencialoc(LocalDate frequencialoc) {
		this.frequencialoc = frequencialoc;
	}

	public Aluno getClient() {
		return aluno;
	}

}
