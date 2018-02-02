package com.sahariar.librarymanagement.Library.Management.Controller;

import java.sql.Date;
import java.util.Calendar;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.context.request.WebRequest;

import com.sahariar.librarymanagement.Library.Management.Models.Author;
import com.sahariar.librarymanagement.Library.Management.Models.Book;
import com.sahariar.librarymanagement.Library.Management.Models.Borrow;
import com.sahariar.librarymanagement.Library.Management.Models.Category;
import com.sahariar.librarymanagement.Library.Management.Models.User;
import com.sahariar.librarymanagement.Library.Management.Service.AuthorService;
import com.sahariar.librarymanagement.Library.Management.Service.BookService;
import com.sahariar.librarymanagement.Library.Management.Service.BorrowService;
import com.sahariar.librarymanagement.Library.Management.Service.CategoryService;
import com.sahariar.librarymanagement.Library.Management.Service.UserService;

@Controller
@RequestMapping("/admin")
public class AdminController {

	@Autowired
	AuthorService as;
	@Autowired
	CategoryService cs;
	@Autowired 
	BookService bs;
	@Autowired
	UserService us;
	
	@Autowired
	BorrowService bos;
	
	
	@RequestMapping("/dashboard")
	public String dashboard(Model model)
	{
		
		model.addAttribute("isMessage", false);
		return "admin/dashboard";
	}
	
	@RequestMapping("/adduser")
	public String addUser(Model model)
	{
		model.addAttribute("isMessage", false);
		return "admin/addUser";
		
		
	}
	@RequestMapping(value="/adduser" ,method=RequestMethod.POST)
	public String addUserToDatabase(Model model, WebRequest request)
	{
		
		String name=request.getParameter("name");
		String student_id=request.getParameter("id");
		String email=request.getParameter("email");
		String address=request.getParameter("address");
		User user =new User();
		user.setAddress(address);
		user.setEmail(email);
		user.setName(name);
		user.setStudent_id(student_id);
		user.setRole("ROLE_USER");
		us.add(user);
		model.addAttribute("message", user.getName()+" added.");
		model.addAttribute("isMessage", true);
		return "admin/addUser";
	}
	@RequestMapping(value="/addbook")
	public String addBook(Model model)
	{
	
		model.addAttribute("isMessage", false);
		model.addAttribute("authors", as.getAll());
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
		System.out.println(b);
        model.addAttribute("isMessage", true);
		model.addAttribute("message", b.getName()+" added.");
		model.addAttribute("authors", as.getAll());
		model.addAttribute("categories", cs.getAll());
		return "admin/addBook";
	}
	
	@RequestMapping("/issuebook")
	public String issuebook(Model model)
	{
		 model.addAttribute("isMessage", false);
		return "admin/issueBook";
	}
	@RequestMapping(value="/issuebook",method=RequestMethod.POST)
	public String issueBooktoUser(Model model,WebRequest request)
	{
		
		int book_id=Integer.parseInt(request.getParameter("book_id"));
		int user_id=Integer.parseInt(request.getParameter("user_id"));
		model.addAttribute("isMessage", true);
		if(!bs.isAvailable(book_id))
		{
			model.addAttribute("message", "Book is already taken.");
			return "admin/issueBook";
		}
		
		Borrow borrow=new Borrow();
		borrow.setBook(bs.getOne(book_id));
		borrow.setUser(us.getOne(user_id));
		borrow.setBorrowedDate(getCurrentdate());
		borrow.setReturnDate(getDateAfterSpecificDays(7));
		bos.add(borrow);
		model.addAttribute("message", "Book is Issued for "+user_id);
		return "admin/issueBook";
	}
	
	public Date getCurrentdate()
	{
		return new Date(new java.util.Date().getTime());
	}
	public Date getDateAfterSpecificDays(int days)
	{
		Date now=getCurrentdate();
		Calendar c=Calendar.getInstance();
		c.setTime(now);
		c.add(Calendar.DATE, days);
		
		return new Date(c.getTimeInMillis());
		
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
