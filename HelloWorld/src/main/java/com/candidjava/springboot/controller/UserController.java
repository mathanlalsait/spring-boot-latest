package com.candidjava.springboot.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserController 
{
	@GetMapping("/msg")
	public String createUser() 
	{
		return "Hello World...";
	}
}