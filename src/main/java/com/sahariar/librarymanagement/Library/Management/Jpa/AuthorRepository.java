package com.sahariar.librarymanagement.Library.Management.Jpa;

import org.springframework.data.repository.CrudRepository;

import com.sahariar.librarymanagement.Library.Management.Models.Author;

public interface AuthorRepository extends CrudRepository<Author, Integer> {

}
