package com.school.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.school.request.LoginRequest;

@RestController
public class LoginController {
	
	
	
	@PostMapping("/login")
	public ResponseEntity<?> loginPage(@RequestBody LoginRequest request){
		
		return null;
		
	}
}
