package fr.insa.userService.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import fr.insa.userService.model.User;

@RestController
public class UserResource {
	
	@GetMapping(value="users/{id}")
	public User userInfo(@PathVariable int id) {
		return new User("nombre", "apellido", "test@gmail.com", "123");
	}
}
