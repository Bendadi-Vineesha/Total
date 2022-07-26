package com.cts.usecaseproject.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cts.usecaseproject.Model.Reader;
import com.cts.usecaseproject.Model.SubscribedBooks;
import com.cts.usecaseproject.Repository.ReaderRepository;
import com.cts.usecaseproject.Repository.SubscribedbooksRepository;

@Service
public class ReaderService {
	
	@Autowired
	ReaderRepository repo;
	
	@Autowired
	SubscribedbooksRepository subrepo;
	
	public Reader saveOrUpdate(Reader reader) {
		return repo.save(reader);
	}
	
	public SubscribedBooks saveOrUpdateSub(SubscribedBooks books) {
		return subrepo.save(books);
	}

	public SubscribedBooks getBookByEmail(String email) {
				return subrepo.findByEmail(email);
	}

public SubscribedBooks getBookById(int id) {
	return subrepo.findById(id);
	
}
}