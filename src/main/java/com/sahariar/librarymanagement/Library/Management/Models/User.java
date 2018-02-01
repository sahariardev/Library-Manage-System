package com.sahariar.librarymanagement.Library.Management.Models;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

@Entity
public class User {
	
	
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Id
	private int id;
	private String email;
	private String name;
	private String address;
	private String role;
	private String password;
	@OneToOne(mappedBy="user")
	private Borrow borrow;
	
	@OneToMany(mappedBy="user")
	private List<Penalty> penalty;
	
	
	
	
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public List<Penalty> getPenalty() {
		return penalty;
	}
	public void setPenalty(List<Penalty> penalty) {
		this.penalty = penalty;
	}
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
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getRole() {
		return role;
	}
	public void setRole(String role) {
		this.role = role;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public Borrow getBorrow() {
		return borrow;
	}
	public void setBorrow(Borrow borrow) {
		this.borrow = borrow;
	}
	
	
	
	

}
