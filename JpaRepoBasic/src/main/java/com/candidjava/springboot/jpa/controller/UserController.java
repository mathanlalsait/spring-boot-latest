package com.candidjava.springboot.jpa.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.candidjava.springboot.jpa.entity.User;
import com.candidjava.springboot.jpa.service.UserService;


//Swagger url : http://localhost:8082/swagger-ui.html
@RestController
@RequestMapping("/user")
public class UserController {
	@Autowired
	private UserService userService;
	
	//Create User
	@RequestMapping(method = RequestMethod.POST, value="/createUser")
	public User createUser(@RequestBody User user) {
		return userService.createUser(user);
	}

	//Update User
	@RequestMapping(method = RequestMethod.PUT, value="/updateUser/{id}")
	public User updateUser(@PathVariable Long id, @RequestBody User user) {
		return userService.updateUser(id, user);
	}

	//Get Users
	@RequestMapping(method = RequestMethod.GET)
	public List<User> getUsers() {
		return userService.getUsers();
	}

	//Get User By Id
	@RequestMapping(method = RequestMethod.GET, value="/getUserById/{id}")
	public User getUserById(@PathVariable Long id) {
		return userService.getUserById(id);
	}

	
	//Delete User
	@DeleteMapping("/delete/{id}")
	@RequestMapping(method = RequestMethod.DELETE, value="/deleteUser/{id}")
	public void deleteUser(@PathVariable Long id) {
		userService.deleteUser(id);
	}

}