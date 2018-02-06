package com.sahariar.librarymanagement.Library.Management.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sahariar.librarymanagement.Library.Management.Models.Author;
import com.sahariar.librarymanagement.Library.Management.Models.Book;
import com.sahariar.librarymanagement.Library.Management.Service.AuthorService;
import com.sahariar.librarymanagement.Library.Management.Service.BookService;


@RestController
public class RestApiController {

	@Autowired
	BookService bs;
	@Autowired
	AuthorService as;
	
	@RequestMapping("/allbooks")
	public List<Book> getAllBooks()
	{
	   return bs.getAll();	
	}
	@RequestMapping("/allauthor")
	public List<Author> getAllAuthor()
	{
	 return as.getAll();	
	}
}
