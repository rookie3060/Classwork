package com.example.demo;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity
public class MODEL {
	@Id
	private int no;

	private String name;
	
	public MODEL(int no, String name) {
		super();
		this.no = no;
		this.name = name;
	}

	public MODEL() {
		super();
		// TODO Auto-generated constructor stub
	}

	public int getNo() {
		return no;
	}

	public void setNo(int no) {
		this.no = no;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
	

}
