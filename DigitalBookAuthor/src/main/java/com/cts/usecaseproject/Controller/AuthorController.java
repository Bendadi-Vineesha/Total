package com.cts.usecaseproject.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cts.usecaseproject.Client.BookAuthorClient;
import com.cts.usecaseproject.Model.Author;
import com.cts.usecaseproject.Model.AuthorModel;
import com.cts.usecaseproject.Model.Book;
import com.cts.usecaseproject.Service.AuthorService;

@RestController
@RequestMapping("/author")
public class AuthorController {

	@Autowired
	BookAuthorClient client;

	@Autowired
	AuthorService service;
	
//	@Autowired
//	private PasswordEncoder bcryptEncoder;


	@PostMapping("/createauthor")
	public Author createAuthor(@RequestBody AuthorModel author) {
		return service.saveAuthorDetails(author);
	}

	@PostMapping("/createbook")
	public Book createBook(@RequestBody Book book) {
		return client.createBook(book);
	}
	
	@GetMapping("/msg")
	public String getmessage() {
		return client.gerMessage();
	}

}
