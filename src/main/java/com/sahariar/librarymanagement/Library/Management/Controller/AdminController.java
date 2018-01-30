package com.sahariar.librarymanagement.Library.Management.Controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/admin")
public class AdminController {

	
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
	
	public String  addCategory()
	{
		return "admin/addcategory";
	}
	public String  deleteCategory()
	{
		return "admin/addcategory";
	}
	public String addAuthor()
	{
		return "admin/addauthor";
	}
	
}
