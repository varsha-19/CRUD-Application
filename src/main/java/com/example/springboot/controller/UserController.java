package com.example.springboot.controller;

import java.util.*;


import com.example.springboot.entity.User;
import com.example.springboot.exception.APIException;
import com.example.springboot.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;



@RestController
@RequestMapping("/api/users")
public class UserController{

	@Autowired
	private UserRepository userRepository;

	// get all user by employee
	@GetMapping("/get-user-By-Name/{name}")
	public List<User> getUserByName(@PathVariable(value="name") String name)
	{
		//return userRepository.findByName(name);
		List<User> user = userRepository.findByName(name);
		return user;
	}

	//get all users by firstName and lastName
	@GetMapping("/get-user-By-firstName-and-lastName/{firstName}-{lastName}")
	public List<User> getUserByFirstNameAndLastName(@PathVariable(value="firstName") String firstName, @PathVariable(value="lastName") String lastName)
	{
		List<User> user = userRepository.findByFirstNameAndLastName(firstName, lastName);
		return user;
	}


	// get all users
	@GetMapping("/get-all-users")
	public List<User> getAllUsers() {
		return this.userRepository.findAll();
	}

	// get user by id
	@GetMapping("/get-an-users/{id}")
	public User getUserById(@PathVariable(value = "id") long userId) {
		Optional<User> user = userRepository.findById(userId);
		if (!user.isPresent()) {
			APIException exception = new APIException("User not found for this id :: " + userId);
			exception.setHttpStatusCode(HttpStatus.NOT_FOUND);
			throw exception;
		}
		return user.get();

	}

	// create user
	@PostMapping("/create-user")
	public User createUser(@RequestBody User user) {
		 User savedUser = userRepository.save(user);
		return savedUser;
	}

	// update user
	@PutMapping("/update-user/{id}")
	public User updateUser(@RequestBody User user,@PathVariable ("id") long userId) {
		 User existingUser = userRepository.findById(userId).orElse(null);
		 if(existingUser == null)
		 {
			 APIException exception = new APIException("User not found for this id : " + userId);
			 exception.setHttpStatusCode(HttpStatus.NOT_FOUND);
			 throw exception;
		 }
		existingUser.setFirstName(user.getFirstName());
		existingUser.setLastName(user.getLastName());
		existingUser.setEmail(user.getEmail());
		final User updatedUser = userRepository.save(existingUser);
		return updatedUser;
	}

	// delete user by id
	@DeleteMapping("/delete-user/{id}")
	public Map<String, Boolean> deleteUser(@PathVariable ("id") long userId){
		User existingUser = userRepository.findById(userId).orElse(null);
		if(existingUser == null)
		{
			APIException exception = new APIException("User not found for this id : " + userId);
			exception.setHttpStatusCode(HttpStatus.NOT_FOUND);
			throw exception;
		}
		this.userRepository.delete(existingUser);
		Map<String, Boolean> response = new HashMap<>();
		response.put("deleted", Boolean.TRUE);
		 return response;
	}
}
