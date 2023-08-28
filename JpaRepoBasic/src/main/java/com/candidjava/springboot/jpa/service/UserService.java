package com.candidjava.springboot.jpa.service;

import java.util.List;

import com.candidjava.springboot.jpa.entity.User;

public interface UserService {

	public User createUser(User user);

	public User updateUser(Long id, User user);

	public List<User> getUsers();

	public User getUserById(Long id);

	public void deleteUser(Long id);
}
