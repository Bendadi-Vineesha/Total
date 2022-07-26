package com.cts.usecaseproject.Service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cts.usecaseproject.Model.Book;
import com.cts.usecaseproject.Repository.BookRepository;

@Service
public class BookService {

	@Autowired
	BookRepository repo;

	public Book saveOrUpdate(Book book) {
		return repo.save(book);
	}
	
	public List<Book> getBooks() {
		return repo.findAll();
	}

	public List<Book> getBookByCategory(String category) {
		return repo.findByCategory(category);
	}

	public List<Book> getBookByPublisher(String publisher) {
		return repo.findByPublisher(publisher);
	}

	public List<Book> getBookByAuthor(String author) {
		return repo.findByAuthor(author);
	}

	public List<Book> getBookByPrice(int price) {
		return repo.findByPrice(price);

	}
	public String delete(int id) {
		repo.deleteById(id);
		return "deleted";
	}
	
	public Book getBookById(int id) {
		return repo.findById(id);
	}

	public Book getBookByTitle(String title) {
		return repo.findByTitle(title);
	}
	
}
