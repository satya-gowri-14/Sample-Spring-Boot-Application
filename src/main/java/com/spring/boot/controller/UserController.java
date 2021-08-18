package com.spring.boot.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.spring.boot.model.User;
import com.spring.boot.service.UserService;

@RestController
@RequestMapping("api/users")
public class UserController
{
	//inject the dependency
	private UserService userService;

	
	//constructor based injection
	
	public UserController(UserService userService) {
		super();
		this.userService = userService;
	}
	
	//Build  create User REST API
	//localhost:8080/api/users
	@PostMapping()
	public ResponseEntity<User> saveUser(@RequestBody User user)
	{
		return new ResponseEntity<User>(userService.saveUser(user),HttpStatus.CREATED);
		
	}
	
	//UPDATE User REST API
	//http://localhost:8080/api/users/1   (you need to pass the id of the user)
	//information should be update in a request body
	@PutMapping("{id}") //handle id by using path variable    //RequestBody is used to get JSON object from the request body
 
	public ResponseEntity<User> updateUser(@PathVariable("id") long id,@RequestBody User user)
	{
		return new ResponseEntity<User>(userService.updateUser(user, id), HttpStatus.OK);
	}
	
	// Retrieve user by any email REST API
	//http://localhost:8080/api/users/satya.digudari@netenrich.com   (you need to pass the email of the user)
	 @GetMapping("/email/{email}")
	public ResponseEntity<User> getUserByEmail(@PathVariable("email") String email)
	{
		return new ResponseEntity<User>(userService.getUserByEmail(email),HttpStatus.OK);
	}
	
	//Retrieve list of users whose designation is same.
	@GetMapping("/designation/{designation}")
	List<User> findByDesignation(@PathVariable("designation") String designation)
	{
		return userService.getAllUsersByDesignation(designation);
	}
	
	
	
	//Retrieve list of active Users REST API
	//http://localhost:8080/api/users/true 
	@GetMapping("/active/{active}")
	List<User> findByActive(@PathVariable("active") boolean active)
	{
		return userService.getAllUsersByActive(active);
	}
	
	
	
}