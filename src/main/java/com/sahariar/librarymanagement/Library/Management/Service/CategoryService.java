package com.sahariar.librarymanagement.Library.Management.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sahariar.librarymanagement.Library.Management.Jpa.CategoryRepository;
import com.sahariar.librarymanagement.Library.Management.Models.Category;


@Service
public class CategoryService {

	
	@Autowired
	CategoryRepository categoryRepository;
	public Category addCategory(Category category)
	{
		     
		   Category c=categoryRepository.save(category);
		     
		     return c;
                    
	}
	
	
	
}
