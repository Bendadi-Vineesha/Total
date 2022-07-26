package com.cts.usecaseproject.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import com.cts.usecaseproject.Client.BookReaderClient;
import com.cts.usecaseproject.Model.Book;
import com.cts.usecaseproject.Model.Books;
import com.cts.usecaseproject.Model.SubscribedBooks;
import com.cts.usecaseproject.Service.ReaderService;

@RestController
@RequestMapping("/reader")
public class ReaderController {

	@Autowired
	ReaderService service;

	@Autowired
	BookReaderClient client;

	@PostMapping("/save/subscribebooks")
	public SubscribedBooks subscribeToABook(@RequestBody SubscribedBooks subbook) {
		Book auth = client.getBookByTitle(subbook.getTitle());
		if (auth.getTitle() == subbook.getTitle())
			subbook.setContent(auth.getContent());
		subbook.setEmail(auth.getEmailAddress());
		subbook.setAuthor(auth.getAuthor());
		subbook.setCategory(auth.getCategory());
		subbook.setPublisher(auth.getPublisher());
		subbook.setPublishedDate(auth.getPublishedDate());
		subbook.setPrice(auth.getPrice());
		subbook.setTitle(auth.getTitle());
		subbook.setActive(auth.isActive());
		return service.saveOrUpdateSub(subbook);

	}

	
	
	@GetMapping("/subscribedbooks")
	public SubscribedBooks getSubscribedBooksByEmail(@RequestParam(name = "email") String email) {
		return service.getBookByEmail(email);
	}
	
	@GetMapping("/subscribedbooks/byid")
	public SubscribedBooks getSubscribedBooksById(@RequestParam(name="id") int id) {
		return service.getBookById(id);
	}
	
	@GetMapping("/by-publisher")
	public List<Books> getBookByPublisher(@RequestParam(name = "publisher") String publisher) {
		return client.getBookByPublisher(publisher);

	}

	@GetMapping("/by-author")
	public List<Books> getBookByAuthor(@RequestParam(name = "author") String author) {
		return client.getBookByAuthor(author);

	}

	@GetMapping("/by-category")
	public List<Books> getBookByCategory(@RequestParam(name = "category") String category) {
		return client.getBookByCategory(category);

	}

	@GetMapping("/by-price")
	public List<Books> getBookByPrice(@RequestParam(name = "price") int price) {
		return client.getBookByPrice(price);

	}

}