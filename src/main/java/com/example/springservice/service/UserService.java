package com.example.springservice.service;

import java.util.ArrayList;
import org.springframework.stereotype.Service;
import com.example.springservice.entity.User;


@Service("UserService")
public class UserService {
	ArrayList<User> al = new ArrayList<>();
	
	public ArrayList<User> createUser(User user) {
		al.add(user);
		System.out.println(al);
		return al;
	}
	
	public User retrieve(String name) {
		for(User i : al) {
			if(i.name.equals(name)) {
				return i;
			}
		}
		return null;
	}

	public ArrayList<User> putUser(User user) {
		for(User i : al) {
			if(i.name.equals(user.name)) {
				i.gender = user.gender;
				i.age = user.age;
				break;
			}
		}
		return al;
	}

	public ArrayList<User> deleteUser(String name) {
		for(User i : al) {
			if(i.name.equals(name)) {
				al.remove(i);
				break;
			}
		}
		return al;
	}

	public ArrayList<User> retrieveAll() {
		return al;
	}
}
