package com.candidjava.springboot.serviceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.hateoas.Resource;
import org.springframework.stereotype.Service;

import com.candidjava.springboot.controller.UserController;
import com.candidjava.springboot.entity.User;
import com.candidjava.springboot.repository.UserRepository;
import com.candidjava.springboot.service.UserService;
import static org.springframework.hateoas.mvc.ControllerLinkBuilder.linkTo;
import static org.springframework.hateoas.mvc.ControllerLinkBuilder.methodOn;
 


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
	public Resource<User> getUserById(Long id) {
				User user= userRepository.findById(id).get();
 
        // Creating links as per the hateoas principle.
        Resource<User> userResource= new Resource<User>(user);
        userResource.add(linkTo(methodOn(UserController.class).getUserById(id)).withRel("_self"));
        return userResource;
	}

	@Override
	public void deleteUser(Long id) {
		// TODO Auto-generated method stub
		userRepository.deleteById(id);
	}

}
