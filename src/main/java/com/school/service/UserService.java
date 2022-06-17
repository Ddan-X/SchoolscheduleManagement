package com.school.service;

import com.school.entity.User;

public interface UserService {
	public User findByUsername(String userName);
}
