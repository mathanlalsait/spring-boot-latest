package com.candidjava.springboot.service;

import java.util.List;

import org.springframework.hateoas.Resource;

import com.candidjava.springboot.entity.User;

public interface UserService {

	public User createUser(User user);

	public User updateUser(Long id, User user);

	public List<User> getUsers();

	public Resource<User> getUserById(Long id);

	public void deleteUser(Long id);
}
