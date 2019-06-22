package com.example.springservice.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import org.springframework.web.bind.annotation.GetMapping;

@Entity
public class User {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	public long id;
	public String name ;
	public String gender ;
	public int age ;
	
	@GetMapping()

	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	
	public User(long id,String name, String gender ,int age) {
		this.id = id;
		this.name = name;
		this.gender = gender;
		this.age = age;
	}
	public User() {
		super();
	}
	
	public String toString() {
		return this.name + " " + this.gender + " " + this.age;
	}
}
