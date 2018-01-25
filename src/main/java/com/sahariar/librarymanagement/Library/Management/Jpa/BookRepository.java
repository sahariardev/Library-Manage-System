package com.sahariar.librarymanagement.Library.Management.Jpa;

import org.springframework.data.repository.CrudRepository;

import com.sahariar.librarymanagement.Library.Management.Models.Book;

public interface BookRepository extends CrudRepository<Book, Integer> {

}
