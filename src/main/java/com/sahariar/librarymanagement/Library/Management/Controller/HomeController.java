package com.sahariar.librarymanagement.Library.Management.Controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.context.request.WebRequest;

import com.sahariar.librarymanagement.Library.Management.Jpa.AuthorRepository;
import com.sahariar.librarymanagement.Library.Management.Jpa.BookRepository;
import com.sahariar.librarymanagement.Library.Management.Jpa.CategoryRepository;
import com.sahariar.librarymanagement.Library.Management.Models.Author;
import com.sahariar.librarymanagement.Library.Management.Models.Book;
import com.sahariar.librarymanagement.Library.Management.Models.Category;
import com.sahariar.librarymanagement.Library.Management.Service.CategoryService;

@Controller
public class HomeController {

	
	@RequestMapping("/")
	public String getHome(WebRequest request)
	{
		
		
		
		return "home";
	}
	
	
	@RequestMapping("/404")
	public String error()
	{
		return "error";
	}
	
	
	@RequestMapping("/login")
	public String login()
	{
		return "login";
	}
	
	
	

}
