package com.cts.usecaseproject.Client;

import java.util.List;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.cts.usecaseproject.Model.Book;
import com.cts.usecaseproject.Model.Books;

@FeignClient("DIGITAL-BOOK")
public interface BookReaderClient {

	@GetMapping("/api/v1/digitalbooks/books/publisher")
	public List<Books> getBookByPublisher(@RequestParam(name = "publisher") String publisher);

	@GetMapping("/api/v1/digitalbooks/books/author")
	public List<Books> getBookByAuthor(@RequestParam(name = "author")String author);
	
	@GetMapping("/api/v1/digitalbooks/books/category")
	public List<Books> getBookByCategory(@RequestParam(name = "category")String category);
	
	@GetMapping("/api/v1/digitalbooks/books/price")
	public List<Books> getBookByPrice(@RequestParam(name = "price")int price);
	
	@GetMapping("/api/v1/digitalbooks/books/title")
	public Book getBookByTitle(@RequestParam(name = "title")String title);
	
	
}
