package com.sahariar.librarymanagement.Library.Management.Jpa;

import org.springframework.data.jpa.repository.JpaRepository;

import com.sahariar.librarymanagement.Library.Management.Models.Category;

public interface CategoryRepository extends JpaRepository<Category, Integer> {

}
