package com.sahariar.librarymanagement.Library.Management.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sahariar.librarymanagement.Library.Management.Jpa.BookRepository;
import com.sahariar.librarymanagement.Library.Management.Models.Book;

@Service
public class BookService {

	@Autowired
	BookRepository br;
	public  Book addBook(Book book)
	{
		Book b=br.save(book);
        return b;

	}
}
