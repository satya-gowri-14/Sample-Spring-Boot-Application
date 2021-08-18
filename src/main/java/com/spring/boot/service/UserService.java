package com.spring.boot.service;

import java.util.List;

import com.spring.boot.model.User;

public interface UserService {

	User saveUser(User user);

	User updateUser(User user, long id);
	
	User getUserByEmail(String email);

	List<User> getAllUsersByDesignation(String designation);

	List<User> getAllUsersByActive(boolean active);

	

	

	

	
	//List<User> getAllActiveUsers(boolean active);
}
