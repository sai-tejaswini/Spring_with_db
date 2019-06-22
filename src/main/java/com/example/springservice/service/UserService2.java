package com.example.springservice.service;


import java.util.ArrayList;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.example.springservice.entity.User;
import com.example.springservice.repo.UserRepo;

@Service("UserService2")
public class UserService2 {
	@Autowired
	UserRepo userRepo;
	
	ArrayList<User> al = new ArrayList<>();

	public ArrayList<User> createUser(User user) {
		al.add(user);
		System.out.println(al);
		return al;
	}
	
	public Optional<User> findById(long id) {
		return userRepo.findById(id);
	}
	
	public User create(User user) {
		return userRepo.save(user);
	}

	public void deleteByName(long id) {
		userRepo.deleteById(id);
	}
	
	public User updateUser(User user) {	
		userRepo.updateById(user.gender , user.id);
		return user;
	}
}