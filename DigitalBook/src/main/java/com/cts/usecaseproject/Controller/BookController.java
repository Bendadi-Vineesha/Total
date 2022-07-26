package com.cts.usecaseproject.Controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.cts.usecaseproject.Model.Book;
import com.cts.usecaseproject.Model.Books;
import com.cts.usecaseproject.Service.BookService;

@RestController
@RequestMapping("/api/v1/digitalbooks/books")
public class BookController {
	
	//catergory,author,price,publisher

	@Autowired
	BookService service;
	
	@GetMapping("/msg")
	public String message() {
		return "hello";
		}

	@PostMapping("/create")
	public Book CreateBook(@RequestBody Book authordettails) {
		return service.saveOrUpdate(authordettails);
	}

	@PostMapping("/subscribedbooks")
	public Book SubscribeBook(@RequestBody Book authordettails) {
		return service.saveOrUpdate(authordettails);
	}

	
	@GetMapping("/getbooks")
	public List<Book> getAllBooks(){
		return service.getBooks();
		
	}
	
	@DeleteMapping("/{id}")
	public String DeleteBook(@PathVariable int id) {
		service.delete(id);
		return "deleted succesfully";
	}
	
	@GetMapping("/price")
	public ResponseEntity<List<Book>> getBookByPrice(@RequestParam(name = "price") int price) {
		List<Book> rp = service.getBookByPrice(price);
		return ResponseEntity.ok().body(rp);
	}

	
	@GetMapping("/author")
	public ResponseEntity<List<Book>> getBookByAuthor(@RequestParam(name = "author") String name) {
		List<Book> ra = service.getBookByAuthor(name);
		return ResponseEntity.ok().body(ra);
	}
	
	@GetMapping("/publisher")
	public ResponseEntity<List<Book>> getBookByPublisher(@RequestParam(name = "publisher") String publisher ) {
		List<Book> ra = service.getBookByPublisher(publisher);
		return ResponseEntity.ok().body(ra);
	}
	
	@GetMapping("/category")
	public ResponseEntity<List<Book>> getBookByCategory(@RequestParam(name = "category") String category) {
		List<Book> ra = service.getBookByCategory(category);
		return ResponseEntity.ok().body(ra);
	}
	
	
	@GetMapping("/title")
	public ResponseEntity<Book> getBookByTitle(@RequestParam(name = "title") String title) {
		Book ra = service.getBookByTitle(title);
		return ResponseEntity.ok().body(ra);
	}
	
	@PutMapping("/updateBook/{id}")
	public Book updateBookById(@PathVariable(value = "id") int bookId,@RequestBody Book book){
		Book b = service.getBookById(bookId);
	b.setAuthor(book.getAuthor());
	b.setCategory(book.getCategory());
	b.setContent(book.getContent());
	b.setPrice(book.getPrice());
	b.setPublishedDate(book.getPublishedDate());
	b.setTitle(book.getTitle());
	b.setPublisher(book.getPublisher());
		return service.saveOrUpdate(b);
		
	}
	 
}