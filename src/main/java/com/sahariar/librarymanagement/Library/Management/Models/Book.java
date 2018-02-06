package com.sahariar.librarymanagement.Library.Management.Models;

import java.util.List;
import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToOne;

@Entity
public class Book {
	
	
	
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Id
	private int id;
	
    private String name;
	private String description;
	public String callnumber;
	
	//relationships
	@OneToOne(mappedBy="book")
	private Borrow borrow;
	
	@ManyToMany
	@JoinTable(name="book_category",joinColumns=@JoinColumn(name="book_id")
	,inverseJoinColumns=@JoinColumn(name="category_id"))
	private Set<Category> categories;
	
	@ManyToMany
	@JoinTable(name="book_author",joinColumns=@JoinColumn(name="book_id")
	,inverseJoinColumns=@JoinColumn(name="author_id"))
	private Set<Author> authors;

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

	public Set<Category> getCategories() {
		return categories;
	}

	public void setCategories(Set<Category> categories) {
		this.categories = categories;
	}

	public Set<Author> getAuthors() {
		return authors;
	}

	public void setAuthors(Set<Author> authors) {
		this.authors = authors;
	}
       
	public String getCallnumber() {
		return callnumber;
	}

	public void setCallnumber(String callnumber) {
		this.callnumber = callnumber;
	}

	@Override
	public String toString() {
		return "Book [id=" + id + ", name=" + name + ", description=" + description + ", borrow=" + borrow
				+ ", categories=" + categories + ", authors=" + authors + "]";
	} 
	public boolean isAvailable()
	{
		if(getBorrow()==null)
		{
			return true;
		}
		if(getBorrow().getReturned()==0)
		{
			return false;
		}
		return true;
	}
	
	
	
	
	
	
	
		
	

}
