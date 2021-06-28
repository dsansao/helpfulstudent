package br.com.initialproject.controller;

import br.com.initialproject.dto.UserDTO;
import br.com.initialproject.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/api/user")
public class UserController {
	
	@Autowired
	private UserService userService;
	
	@GetMapping
	public List<UserDTO> findAll() {
		return userService.findAll();
	}	
	
	@GetMapping("/{id}")
	public UserDTO findById(@PathVariable("id") Long id) {
		return userService.findById(id);
	}

	@GetMapping("/users")
	public List<UserDTO> find() {
		return userService.findAll();
	}

	@PostMapping
	public UserDTO create(@RequestBody UserDTO user) {
		return userService.create(user);
	}
	
	@PutMapping
	public UserDTO update(@RequestBody UserDTO user) {
		return userService.update(user);
	}	
	
	@DeleteMapping("/{id}")
	public ResponseEntity<?> delete(@PathVariable("id") Long id) {
		userService.delete(id);
		return ResponseEntity.ok().build();
	}	
	
}