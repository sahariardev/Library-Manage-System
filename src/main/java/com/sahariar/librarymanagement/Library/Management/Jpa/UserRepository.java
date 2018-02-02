package com.sahariar.librarymanagement.Library.Management.Jpa;

import org.springframework.data.jpa.repository.JpaRepository;

import com.sahariar.librarymanagement.Library.Management.Models.User;

public interface UserRepository extends JpaRepository<User, Integer> {

}
