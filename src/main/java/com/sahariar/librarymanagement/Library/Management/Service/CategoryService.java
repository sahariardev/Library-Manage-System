package com.sahariar.librarymanagement.Library.Management.Service;

import java.util.ArrayList;
import java.util.List;

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
	public List<Category> getAll()
	{
		return categoryRepository.findAll();
	}
	public List<Category> getSpecefic(int arr[])
	{
		List<Category> categories=new ArrayList<>();
		for(int c=0;c<arr.length;c++)
		{
			categories.add(categoryRepository.findOne(arr[c]));
		}
		return categories;
	}
	
	
}
