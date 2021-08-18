package com.spring.boot.service.implementation;

import java.util.List;

//import java.util.List;

import org.springframework.stereotype.Service;

import com.spring.boot.exception.ResourceNotFoundException;
import com.spring.boot.model.User;
import com.spring.boot.repository.UserRepository;
import com.spring.boot.service.UserService;

@Service
public class UserServiceImpl implements UserService{

	private UserRepository userRepository;
	
	
	public UserServiceImpl(UserRepository userRepository) {
		super();
		this.userRepository = userRepository;
	}


	@Override
	public User saveUser(User user){
		
		return userRepository.save(user);
	}


	@Override
	public User updateUser(User user, long id) {
		//check whether the given id is exist in a DB or not...
				// If the User is not present in the DB it will throw ResourceNotFoundException
					//@SuppressWarnings("unused")
					User existingUser=userRepository.findById(id).orElseThrow(
						() -> new ResourceNotFoundException("User","Id",id));
					
					existingUser.setFname(user.getFname());// fname will be provided by client
					existingUser.setLname(user.getLname());
					existingUser.setDesignation(user.getDesignation());
					existingUser.setEmail(user.getEmail());
					existingUser.setPhno(user.getPhno());
					existingUser.setActive(user.isActive());
					user.getUserAddress().setId(existingUser.getUserAddress().getId());
					existingUser.setUserAddress(user.getUserAddress());
					
					//save existing user to DB
					userRepository.save(existingUser);
					
					
				return existingUser;
	}


	


	@Override
	public User getUserByEmail(String email) {
		
		return userRepository.findByEmail(email);
	}


	@Override
	public List<User> getAllUsersByDesignation(String designation) {
		
		return userRepository.findByDesignation(designation);
		
	}


	@Override
	public List<User> getAllUsersByActive(boolean active) {
		
		return userRepository.findByActive(active);
	}


	
	
	
	
	
	
	

}
