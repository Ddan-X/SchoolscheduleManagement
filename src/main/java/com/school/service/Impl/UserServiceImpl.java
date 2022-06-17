package com.school.service.Impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.school.entity.User;
import com.school.repository.UserRepository;
import com.school.service.UserService;

@Service
public class UserServiceImpl implements UserService {

	@Autowired
	UserRepository userRepository;
	@Override
	public User findByUsername(String userName) {
		// TODO Auto-generated method stub
		return userRepository.findByusername(userName);
	}

}
