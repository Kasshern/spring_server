	package com.revature.controllers;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.revature.entities.User;
import com.revature.services.UserService;

@RestController
@RequestMapping("/user")
@CrossOrigin(origins = "*", 
methods = {RequestMethod.GET, RequestMethod.PUT, 
			RequestMethod.PATCH, RequestMethod.POST},
allowedHeaders = {"Content-Type"})
public class UserController {

	@Autowired
	UserService userService;
	
	@GetMapping
	public List<User> getUsers()  {
			return userService.getUsers();
		}
	
	@PostMapping
	public User saveUser(@Valid @RequestBody User user) {
		return userService.save(user);
	}
	
	@GetMapping("/{id}")
	public User getUserById(@PathVariable int id) {
		return userService.findById(id);
	}
	
	@PutMapping
	public User updateUser(@RequestBody User user) {
		return userService.update(user);
	}

}







