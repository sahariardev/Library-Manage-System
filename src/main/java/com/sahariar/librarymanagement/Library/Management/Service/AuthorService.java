package com.sahariar.librarymanagement.Library.Management.Service;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sahariar.librarymanagement.Library.Management.Jpa.AuthorRepository;
import com.sahariar.librarymanagement.Library.Management.Jpa.BookRepository;
import com.sahariar.librarymanagement.Library.Management.Models.Author;
import com.sahariar.librarymanagement.Library.Management.Models.Book;

@Service
public class AuthorService {

	
	@Autowired
	AuthorRepository ar;
	
	@Autowired
	BookRepository br;
	
	public Author addAuthor(Author author)
	{
		author.setBooks((List<Book>)br.findAll());
	   	Author a=ar.save(author);
	   	return a;
	}
	public List<Author> getAll()
	{
	 return (List<Author>)ar.findAll();
	}
	
	public Set<Author> getSpecefic(int arr[])
	{
		Set<Author> authors=new HashSet<Author>();
		for(int c=0;c<arr.length;c++)
		{
			authors.add(ar.findOne(arr[c]));
		}
		return authors;
	}
}
