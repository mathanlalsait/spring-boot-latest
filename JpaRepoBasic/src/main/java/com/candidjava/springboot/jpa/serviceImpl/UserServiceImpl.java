package com.candidjava.springboot.jpa.serviceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.candidjava.springboot.jpa.entity.User;
import com.candidjava.springboot.jpa.repository.UserRepository;
import com.candidjava.springboot.jpa.service.UserService;

@Service
public class UserServiceImpl implements UserService {

	@Autowired
	private UserRepository userRepository;

	@Override
	public User createUser(User user) {
		// TODO Auto-generated method stub
        return userRepository.save(user);
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
		return userRepository.findAll();
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
