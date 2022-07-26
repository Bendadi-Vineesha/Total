package com.cts.usecaseproject.Repository;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.cts.usecaseproject.Model.Book;

@Repository
public interface BookRepository extends JpaRepository<Book, Integer> {

	Book findById(int id);
	
	List<Book> findByAuthor(String author);

	List<Book> findByPrice(int price);

	List<Book> findByCategory(String Category);

	List<Book> findByPublisher(String publisher);
	
	Book findByTitle(String title);

}