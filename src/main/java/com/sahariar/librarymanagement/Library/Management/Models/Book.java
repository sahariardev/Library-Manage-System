package com.sahariar.librarymanagement.Library.Management.Models;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.OneToOne;

@Entity
public class Book {
	
	
	
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Id
	private int id;
	
    private String name;
	private String description;
	
	
	//relationships
	@OneToOne(mappedBy="book")
	private Borrow borrow;
	
	@ManyToMany(mappedBy="books")
	private List<Author> authors;
	
	@ManyToMany(mappedBy="books")
	private List<Author> categories;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Borrow getBorrow() {
		return borrow;
	}

	public void setBorrow(Borrow borrow) {
		this.borrow = borrow;
	}

	public List<Author> getAuthors() {
		return authors;
	}

	public void setAuthors(List<Author> authors) {
		this.authors = authors;
	}

	public List<Author> getCategories() {
		return categories;
	}

	public void setCategories(List<Author> categories) {
		this.categories = categories;
	}
	
	
	
	
	
	
		
	

}
