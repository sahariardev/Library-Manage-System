package com.sahariar.librarymanagement.Library.Management.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.context.request.WebRequest;

import com.sahariar.librarymanagement.Library.Management.Models.Author;
import com.sahariar.librarymanagement.Library.Management.Service.AuthorService;

@Controller
@RequestMapping("/admin")
public class AdminController {

	@Autowired
	AuthorService as;
	
	
	@RequestMapping("/dashboard")
	public String dashboard()
	{
		
		
		return "admin/dashboard";
	}
	
	public String addBook()
	{
		return "admin/addBook";
	}
	public String editBook()
	{
		return "admin/editbook";
	}
	public String deleteBook()
	{
		return "admin/showDeletedmessage";
	}
	
	@RequestMapping("/addCategory")
	public String  addCategory()
	{
		return "admin/addcategory";
	}
	public String  deleteCategory()
	{
		return "admin/addcategory";
	}
	
	@RequestMapping("/addAuthor")
	public String addAuthor(Model model)
	{
		model.addAttribute("isMessage", false);
		return "admin/addauthor";
	}
	
	@RequestMapping(value="/addAuthor",method=RequestMethod.POST)
	public String addAuthorTodatabase(WebRequest request,Model model)
	{
		Author author=new Author();
		author.setName(request.getParameter("name"));
		author.setDescription(request.getParameter("description"));
		as.addAuthor(author);
		model.addAttribute("message", author.getName()+" added ");
		model.addAttribute("isMessage", true);
		return "admin/addauthor";
	}
	
}
