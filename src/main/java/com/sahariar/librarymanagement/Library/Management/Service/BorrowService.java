package com.sahariar.librarymanagement.Library.Management.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sahariar.librarymanagement.Library.Management.Jpa.BorrowRepository;
import com.sahariar.librarymanagement.Library.Management.Models.Borrow;

@Service
public class BorrowService {

	@Autowired
	BorrowRepository br;
	public Borrow add(Borrow b)
	{
	  return br.save(b);	
	}
}
