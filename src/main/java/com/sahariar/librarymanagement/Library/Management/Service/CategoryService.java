package com.sahariar.librarymanagement.Library.Management.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sahariar.librarymanagement.Library.Management.Jpa.CategoryRepository;
import com.sahariar.librarymanagement.Library.Management.Models.Category;


@Service
public class CategoryService {

	
	@Autowired
	CategoryRepository categoryRepository;
	public void addCategory()
	{
		     
		    Category n1=new Category();
		    n1.setName("Fiction");
		    n1.setDescription("Description of fiction");
            Category c=categoryRepository.save(n1);
            
            System.out.println(c);
            
            
	 	
	}
	
	
	
}
