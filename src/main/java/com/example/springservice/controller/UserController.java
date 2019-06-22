package com.example.springservice.controller;

import java.util.ArrayList;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.springservice.entity.User;
import com.example.springservice.service.UserService;
import com.example.springservice.service.UserService2;

@RestController
public class UserController {

	@Autowired
	@Qualifier("UserService")
	UserService userService;
	
	@Autowired
	@Qualifier("UserService2")
	UserService2 userService2;
	
	@RequestMapping("/")
	public String check() {
		return "Hello World";
	}
			
	@PostMapping("/user")
	public ArrayList<User> createUser1(@RequestBody User user) {
		return userService.createUser(user);
	}
	
	@GetMapping("/user")
	public User retrieveByName(@RequestBody String name) {
		return userService.retrieve(name);
	}
	
	@GetMapping("/user/all")
	public ArrayList<User> retrieveAll() {
		return userService.retrieveAll();
	}
	
	@PutMapping("/user")
	public ArrayList<User> putByName(@RequestBody User user) {
		return userService.putUser(user);
	}
	
	@DeleteMapping("/user")
	public ArrayList<User> deleteByName(@RequestBody String name){
		return userService.deleteUser(name);
	}
	
	@PostMapping("/user/2")
	public ArrayList<User> createUser2(@RequestBody User user) {
		return userService2.createUser(user);
	}	
	
	//userService2 methods

	@GetMapping("/db/{id}")
	public Optional<User> findById(@PathVariable long id) {
		return userService2.findById(id);
	}
	
	@PostMapping("/db")
	public User createUser(@RequestBody User user) {
		return userService2.create(user);
	}
	
	@PutMapping("/db")
	public User updateUser(@RequestBody User user) {
		return userService2.updateUser(user);
	}

	@DeleteMapping("/db")
	public String deleteById(@RequestBody long id) {
		userService2.deleteByName(id);
		return "Deleted Succesfully";
	}
}
