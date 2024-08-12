package com.digilivros.models;

import java.io.Serializable;
import java.time.LocalDate;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "TB_Rents")

public class Rent implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id;

	private LocalDate rentloc;
	@OneToOne
	@JoinColumn

	private Aluno aluno;
	@OneToOne
	@JoinColumn

	private Book book;

	public Book getBook() {
		return book;
	}

	public void setBook(Book book) {
		this.book = book;
	}

	public void setClient(Aluno aluno) {
		this.aluno = aluno;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public LocalDate getRentloc() {
		return rentloc;
	}

	public void setRentloc(LocalDate rentloc) {
		this.rentloc = rentloc;
	}

	public Aluno getClient() {
		return aluno;
	}

}
