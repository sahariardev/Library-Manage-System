package com.sahariar.librarymanagement.Library.Management.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.context.request.WebRequest;

import com.sahariar.librarymanagement.Library.Management.Models.Author;
import com.sahariar.librarymanagement.Library.Management.Models.Book;
import com.sahariar.librarymanagement.Library.Management.Models.Category;
import com.sahariar.librarymanagement.Library.Management.Service.AuthorService;
import com.sahariar.librarymanagement.Library.Management.Service.BookService;
import com.sahariar.librarymanagement.Library.Management.Service.CategoryService;

@Controller
@RequestMapping("/admin")
public class AdminController {

	@Autowired
	AuthorService as;
	@Autowired
	CategoryService cs;
	@Autowired 
	BookService bs;
	
	
	@RequestMapping("/dashboard")
	public String dashboard()
	{
		
		
		return "admin/dashboard";
	}
	
	@RequestMapping(value="/addbook")
	public String addBook(Model model)
	{
		List<Author> authors=as.getAll();
		
		model.addAttribute("isMessage", false);
		model.addAttribute("authors", authors);
		model.addAttribute("categories", cs.getAll());
		return "admin/addBook";
	}
	@RequestMapping(value="/addbook", method=RequestMethod.POST)
	public String addBooktodatabase(Model model,WebRequest request)
	{
		String author_id[]=request.getParameterValues("author");
		String category_id[]=request.getParameterValues("category");
		
		
		Book book=new Book();
		book.setName(request.getParameter("name"));
		book.setDescription(request.getParameter("description"));
		book.setAuthors(as.getSpecefic(strArrayToInt(author_id)));
		book.setCategories(cs.getSpecefic(strArrayToInt(category_id)));
		Book b=bs.addBook(book);
 
		model.addAttribute("isMessage", true);
		model.addAttribute("message", b.getName()+" added.");
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
	public String  addCategory(Model model)
	{
		model.addAttribute("isMessage", false);
		return "admin/addcategory";
	}
	@RequestMapping(value="/addCategory",method=RequestMethod.POST)
	public String addCategoryTodatabase(WebRequest request,Model model)
	{
		Category category=new Category();
		category.setName(request.getParameter("name"));
		category.setDescription(request.getParameter("description"));
	    cs.addCategory(category);
		model.addAttribute("message", category.getName()+" added ");
		model.addAttribute("isMessage", true);
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
	public int[] strArrayToInt(String arr[])
	{
		int intArr[]=new int[arr.length];
		for(int c=0;c<arr.length;c++)
		{
			intArr[c]=Integer.parseInt(arr[c]);
		}
		return intArr;
	}
}
