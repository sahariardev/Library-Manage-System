package com.sahariar.librarymanagement.Library.Management.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sahariar.librarymanagement.Library.Management.Jpa.UserRepository;
import com.sahariar.librarymanagement.Library.Management.Models.User;

@Service
public class UserService {

	
	@Autowired
	UserRepository ur;
	
	public User add(User user)
	{
		return ur.save(user);
	}
	
}
