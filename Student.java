package com.example.demo;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity	//Table Create
@Table(name="student")	//Table Name
public class Student {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)	//Autoincrement
	private Long id;
	
	@Column	//Create Column
	private String fullname;
	
	@Column(unique=true)
	private String email;
	
	@Column
	private String password;
	
	@Column
	private String address;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getFullname() {
		return fullname;
	}

	public void setFullname(String fullname) {
		this.fullname = fullname;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	@Override
	public String toString() {
		return "Student [id=" + id + ", fullname=" + fullname + ", email=" + email + ", password=" + password
				+ ", address=" + address + "]";
	}
}

