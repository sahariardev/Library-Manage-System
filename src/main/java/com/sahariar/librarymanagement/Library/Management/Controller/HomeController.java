package com.sahariar.librarymanagement.Library.Management.Controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.sahariar.librarymanagement.Library.Management.Jpa.AuthorRepository;
import com.sahariar.librarymanagement.Library.Management.Jpa.BookRepository;
import com.sahariar.librarymanagement.Library.Management.Jpa.CategoryRepository;
import com.sahariar.librarymanagement.Library.Management.Models.Author;
import com.sahariar.librarymanagement.Library.Management.Models.Book;
import com.sahariar.librarymanagement.Library.Management.Models.Category;

@Controller
public class HomeController {

	
	@Autowired
	AuthorRepository author;
	
	@Autowired
	BookRepository bookrepository;
	
	@Autowired
	CategoryRepository categoryrepository;
	
	@RequestMapping("/")
	public String getHome()
	{
		
		Iterable<Author> authors=author.findAll();
		
		for(Author a: authors)
		{
			System.err.println(a);
		}
		
		return "home";
	}
	
	
	@RequestMapping("/addBook")
	public String addNewBook()
	{
		Book b=new Book();
        Iterable<Author> authors=author.findAll();
		
        List<Author> l=new ArrayList<Author>();
        
		for(Author a: authors)
		{
			l.add(a);
		}
		b.setAuthor(l);
		
		Iterable<Category> categories=categoryrepository.findAll();
		List<Category> category=new ArrayList<Category>();
		
		for(Category c:categories)
		{
			category.add(c);
		}
		
		b.setCategory(category); 
		
	   bookrepository.save(b);
		
		return "home";
	}
}