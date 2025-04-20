package com.example.demo.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.entity.User;
import com.example.demo.service.UserService;

@RestController
@RequestMapping("/api")
public class UserController {
	
	@Autowired
	private UserService userService;
	
	@PostMapping("/user")
	public ResponseEntity<User> createUSer(@RequestBody User user){
		User u=userService.addUser(user);
		return ResponseEntity.ok(u);
	}
	
	@GetMapping("/user")
	public ResponseEntity<List<User>> getall(){
		return ResponseEntity.ok(userService.getAllUsers());
	}
	
	
	   @GetMapping("/user/{id}")
	    public ResponseEntity<User> getUserById(@PathVariable Integer id) {
	        Optional<User> user = userService.getUserById(id);
	        return user.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
	    }
	   
	@PutMapping("/user/{id}")
	public ResponseEntity<User> update(@PathVariable Integer id,@RequestBody User userdetails){
		User updateduser=userService.updateUser(id, userdetails);
		return updateduser !=null ? ResponseEntity.ok(updateduser) : ResponseEntity.notFound().build();
				
	}
	
	@DeleteMapping("/user/{id}")
	public ResponseEntity<Void> deleteUser(@PathVariable Integer id){
		userService.deleteUserById(id);
		return ResponseEntity.noContent().build();
	}

}
