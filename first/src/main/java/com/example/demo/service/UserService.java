package com.example.demo.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.entity.User;
import com.example.demo.repository.UserRepository;

@Service
public class UserService {
	
	@Autowired
	private UserRepository userRepository;
	
	public User addUser(User u) {
		return userRepository.save(u);
	}
	
	public List<User> getAllUsers(){
		return userRepository.findAll();
	}
	
	public Optional<User> getUserById(Integer id) {
        return userRepository.findById(id);
    }
	
	  public User updateUser(Integer id, User userDetails) {
	        Optional<User> optionalUser = userRepository.findById(id);
	        if (optionalUser.isPresent()) {
	            User user = optionalUser.get();
	            user.setName(userDetails.getName());
	            user.setCity(userDetails.getCity());
	            return userRepository.save(user);
	        }
	        return null;
	    }
	  
	  public void deleteUserById(Integer id) {
		   userRepository.deleteById(id);
	  }

}
