package com.sahariar.librarymanagement.Library.Management.Service;

import java.util.ArrayList;
import java.util.List;

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
	public List<Author> getAll()
	{
	 return (List<Author>)ar.findAll();
	}
	
	public List<Author> getSpecefic(int arr[])
	{
		List<Author> authors=new ArrayList<Author>();
		for(int c=0;c<arr.length;c++)
		{
			authors.add(ar.findOne(arr[c]));
		}
		return authors;
	}
}
