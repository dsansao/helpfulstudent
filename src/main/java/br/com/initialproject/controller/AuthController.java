package br.com.initialproject.controller;

import static org.springframework.http.ResponseEntity.ok;

import java.util.HashMap;
import java.util.Map;

import br.com.initialproject.repository.UserRepository;
import br.com.initialproject.security.AccountCredentialsVO;
import br.com.initialproject.security.jwt.JwtTokenProvider;
import br.com.initialproject.service.JwtUserDetailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import io.swagger.annotations.ApiOperation;

@RestController
@RequestMapping("/auth")
public class AuthController {
	
	@Autowired
	AuthenticationManager authenticationManager;

	@Autowired
	JwtUserDetailService jwtUserDetailService;

	@Autowired
	JwtTokenProvider tokenProvider;
	
	@Autowired
	UserRepository repository;
	
	@ApiOperation(value = "Authenticates a user and returns a token")
	@PostMapping(value = "/getToken", produces = { "application/json" },
			consumes = { "application/json" })
	public ResponseEntity getToken(@RequestBody AccountCredentialsVO data) {
		try {
			String username = data.getUsername();
			
			UserDetails user = jwtUserDetailService.loadUserByUsername(username);
			
			String token;
			
			if (user != null) {
				token = tokenProvider.createToken(user);
			} else {
				throw new UsernameNotFoundException("Username " + username + " not found!");
			}
			
			Map<Object, Object> model = new HashMap<>();
			model.put("username", username);
			model.put("token", token);
			return ok(model);

		} catch (AuthenticationException e) {
			throw new BadCredentialsException("Invalid username/password");
		}
	}
}
