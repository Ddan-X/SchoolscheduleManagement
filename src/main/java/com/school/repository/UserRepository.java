package com.school.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.school.entity.User;

@Repository
public interface UserRepository extends JpaRepository<User, Integer> {
	public User findByusername(String username);
}
