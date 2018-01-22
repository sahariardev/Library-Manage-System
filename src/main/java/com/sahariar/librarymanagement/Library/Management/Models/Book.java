package com.sahariar.librarymanagement.Library.Management.Models;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class Book {
	
	
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Id
	private int id;
	
	@OneToMany
	private List<Author> author;
	@OneToMany
	private List<Category> category;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public List<Author> getAuthor() {
		return author;
	}
	public void setAuthor(List<Author> author) {
		this.author = author;
	}
	public List<Category> getCategory() {
		return category;
	}
	public void setCategory(List<Category> category) {
		this.category = category;
	}
		
	

}
