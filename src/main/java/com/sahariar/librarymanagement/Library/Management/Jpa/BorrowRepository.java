package com.sahariar.librarymanagement.Library.Management.Jpa;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.sahariar.librarymanagement.Library.Management.Models.Borrow;

public interface BorrowRepository extends JpaRepository<Borrow, Integer> {

	public List<Borrow> findByBookIdAndReturned(int id,int r);
	public List<Borrow> findByBookId(int id);
	public List<Borrow> findByUserId(int id);
	
	
}
