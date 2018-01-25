package com.sahariar.librarymanagement.Library.Management.Jpa;

import org.springframework.data.repository.CrudRepository;


import com.sahariar.librarymanagement.Library.Management.Models.User;

public interface UserRepository extends CrudRepository<User, Integer> {

}
