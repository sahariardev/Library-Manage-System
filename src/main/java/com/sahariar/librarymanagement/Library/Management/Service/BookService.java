package com.sahariar.librarymanagement.Library.Management.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sahariar.librarymanagement.Library.Management.Jpa.BookRepository;
import com.sahariar.librarymanagement.Library.Management.Jpa.BorrowRepository;
import com.sahariar.librarymanagement.Library.Management.Models.Book;
import com.sahariar.librarymanagement.Library.Management.Models.Borrow;

@Service
public class BookService {

	@Autowired
	BookRepository br;
	@Autowired
	BorrowRepository bor;
	public  Book addBook(Book book)
	{
		Book b=br.save(book);
        return b;

	}
	public Book getOne(int id)
	{
		return br.findOne(id);
	}
	public boolean isAvailable(int id)
	{
		List<Borrow> borrows=bor.findByBookIdAndReturned(id, 0);
		for(Borrow b:borrows)
		{
			System.out.println(b.getBook());
			return false;
		}
		return true;
	}
}
