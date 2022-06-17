package com.school.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.school.request.LoginRequest;
import com.school.response.LoginResponse;
import com.school.service.Impl.UserDetailsServiceImpl;

@CrossOrigin(origins = "*", maxAge = 3600)//allow cross-origin resource sharing (CORS) request
@RestController
@RequestMapping("/api/school")
public class LoginController {
	
	@Autowired
	AuthenticationManager authenticationManager;
	
	@PostMapping("/login")
	public ResponseEntity<?> loginPage(@RequestBody LoginRequest loginRequest){
		String name = loginRequest.getUsername();
		String passowrd = loginRequest.getPassword();
//		if(name.equals("zoe")&&passowrd.equals("1016")) {
//			return  ResponseEntity.status(200).body(name);
//		};
		Authentication authentication= authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(name, passowrd));
		SecurityContextHolder.getContext().setAuthentication(authentication);
		UserDetails userDetails = (UserDetails)authentication.getPrincipal();
		LoginResponse loginResponse =new LoginResponse();
		loginResponse.setUsername(userDetails.getUsername());
		return ResponseEntity.ok(loginResponse);
	}
}
