package com.sahariar.librarymanagement.Library.Management.Jpa;

import org.springframework.data.repository.CrudRepository;

import com.sahariar.librarymanagement.Library.Management.Models.Borrow;

public interface BorrowRepository extends CrudRepository<Borrow, Integer> {

}
