package com.sahariar.librarymanagement.Library.Management.Jpa;

import org.springframework.data.repository.CrudRepository;

import com.sahariar.librarymanagement.Library.Management.Models.Category;

public interface CategoryRepository extends CrudRepository<Category, Integer> {

}
