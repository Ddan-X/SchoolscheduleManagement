package com.school.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.school.request.LoginRequest;

@RestController
public class LoginController {
	
	
	
	@PostMapping("/login")
	public ResponseEntity<?> loginPage(@RequestBody LoginRequest loginRequest){
		String name = loginRequest.getUsername();
		String passowrd = loginRequest.getPassword();
		if(name.equals("zoe")&&passowrd.equals("1016")) {
			return  ResponseEntity.status(200).body(name);
		};
		
		return ResponseEntity.status(404).body("wrong");
		
	}
}
