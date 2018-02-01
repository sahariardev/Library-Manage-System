package com.sahariar.librarymanagement.Library.Management.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sahariar.librarymanagement.Library.Management.Jpa.AuthorRepository;
import com.sahariar.librarymanagement.Library.Management.Models.Author;

@Service
public class AuthorService {

	
	@Autowired
	AuthorRepository ar;
	public Author addAuthor(Author author)
	{
	   	Author a=ar.save(author);
	   	return a;
	}
}
