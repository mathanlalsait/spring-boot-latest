package com.candidjava.springboot.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.candidjava.springboot.entity.User;
import com.candidjava.springboot.service.UserService;


@RestController
@RequestMapping("/user")
public class UserController {
	@Autowired
	private UserService userService;
	
	//Create User
	@PostMapping("/createUser")
	public User createUser(@RequestBody User user) {
		return userService.createUser(user);
	}

	//Update User
	@PutMapping("/updateUser/{id}")
	public User updateUser(@PathVariable Long id, @RequestBody User user) {
		return userService.updateUser(id, user);
	}

	//Get all users
	@GetMapping("/")
	public List<User> getUsers() {
		return userService.getUsers();
	}

	//Get User By Id
	@GetMapping("/getUserById/{id}")
	public User getUserById(@PathVariable Long id) {
		return userService.getUserById(id);
	}

	
	//Delete User
	@DeleteMapping("/delete/{id}")
	public void deleteUser(@PathVariable Long id) {
		userService.deleteUser(id);
	}

}