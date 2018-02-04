package com.sahariar.librarymanagement.Library.Management.Jpa;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.sahariar.librarymanagement.Library.Management.Models.Book;

public interface BookRepository extends JpaRepository<Book, Integer> {
	
	public List<Book> findByNameIgnoreCaseContaining(String name);

}
