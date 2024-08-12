package com.digilivros.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.digilivros.models.Book;

public interface BookRepository extends JpaRepository<Book, Long> {
	Book findById(long id);


}
