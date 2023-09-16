package com.candidjava.springboot.serviceImpl;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.candidjava.springboot.entity.User;
import com.candidjava.springboot.service.UserService;

@Service
public class UserServiceImpl implements UserService {

	static List<User> userList=new ArrayList<User>();
	
	static
	{
		// add 3 users
		User userA= new User((long) 1001001,"karthick","123456",25, "karthick@gmail.com", "chennai");
		userList.add(userA);
		User userB= new User((long) 1001002,"vijay","123456",26, "vijay@gmail.com", "trichy");
		userList.add(userB);
		User userC= new User((long) 1001003,"naveen","123456",24, "naveen@gmail.com", "madurai");
		userList.add(userC);
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
		User updatedUser = null;
		for (User userFromList : userList) {
			if(userFromList.getId().equals(id)) {
				userFromList.setName(user.getName());
				userFromList.setEmail(user.getEmail());
				userFromList.setCity(user.getCity());
				userFromList.setAge(user.getAge());
				userFromList.setPassword(user.getPassword());
				updatedUser = userFromList;
				break;
			}
		}
		return updatedUser;
	}

	@Override
	public List<User> getUsers() {
		// TODO Auto-generated method stub
		return userList;
	}

	@Override
	public User getUserById(Long id) {
		// TODO Auto-generated method stub
		Optional<User> userById = 
				userList.stream().
				filter(user -> user.getId().equals(id))
				.findFirst();
		if (userById.isPresent()) {
			return userById.get();
		} else {
			return null;
		}
	}

	@Override
	public void deleteUser(Long id) {
		// TODO Auto-generated method stub
		userList.removeIf(user -> user.getId().equals(id));
	}
}
