package com.digilivros.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.digilivros.models.Book;
import com.digilivros.models.Book;
import com.digilivros.repository.BookRepository;

@RestController
@RequestMapping(value = "/api")

public class BookController {
	
	@Autowired
	BookRepository bookrepository;
	

	@GetMapping("book")
	public List<Book> ListBook() {
		return bookrepository.findAll();
	}

	@GetMapping("/book/{id}")
	public Book ListBookId(@PathVariable(value = "id") long id) {
		return bookrepository.findById(id);
	}
	
	
	@PostMapping("/book")
	public Book  saveBook(@RequestBody Book book) {
		return bookrepository.save(book);
	}

	@DeleteMapping("/book")
	public void  deletBook(@RequestBody Book book) {
		bookrepository.delete(book);
	}
	
	@PutMapping("/book")
	public Book  editBook(@RequestBody Book book) {
		return bookrepository.save(book); 
	}

}
