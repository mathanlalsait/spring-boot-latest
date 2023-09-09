package com.candidjava.springboot.serviceImpl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.candidjava.springboot.entity.User;
import com.candidjava.springboot.service.UserService;

@Service
public class UserServiceImpl implements UserService {

	List<User> userList=new ArrayList<User>();
	
	static
	{
		// add 3 users
	}
	
	@Override
	public User createUser(User user) {
		// TODO Auto-generated method stub
		userList.add(user);
        return user;
	}

	@Override
	public User updateUser(Long id, User user) {
		// TODO Auto-generated method stub
		User userFromDB = userRepository.findById(id).get();
		userFromDB.setName(user.getName());
		userFromDB.setEmail(user.getEmail());
		userFromDB.setCity(user.getCity());
		userFromDB.setAge(user.getAge());
		userFromDB.setPassword(user.getPassword());
        return userRepository.save(userFromDB);
	}

	@Override
	public List<User> getUsers() {
		// TODO Auto-generated method stub
		return userList;
	}

	@Override
	public User getUserById(Long id) {
		// TODO Auto-generated method stub
		return userRepository.findById(id).get();
	}

	@Override
	public void deleteUser(Long id) {
		// TODO Auto-generated method stub
		userRepository.deleteById(id);
	}
}
