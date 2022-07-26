package com.school.service.Impl;

import java.util.ArrayList;
import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.school.entity.User;
import com.school.service.UserService;


/**
 * base on database to do auth
 * @author Dan
 *
 */
@Service
public class UserDetailsServiceImpl implements UserDetailsService {
	@Autowired
	UserService userService;

	/**
	 * find user by username
	 */
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		// TODO Auto-generated method stub
		User user = userService.findByUsername(username);
		if(user==null) {
			throw new UsernameNotFoundException("username not found: "+username);
		}
		Collection<? extends GrantedAuthority> authorities = new ArrayList<>();
		//auto compare password and username
		UserDetails userDetails = new org.springframework.security.core.userdetails.User
				(username,"{bcrypt}"+user.getPassword(),
	// boolean enabled, boolean accountNonExpired, boolean credentialsNonExpired, boolean accountNonLocked, 
						true,
						true,
						true,
						true,
						authorities);
				//(username, "{noop}"+user.getPassword(), authorities);
		//{noop} do not user password encode
		//{bcrypt} use password encode
		return userDetails;
	}
	
//	public static void main(String[] args) {
//		BCryptPasswordEncoder bCryptPasswordEncoder = new BCryptPasswordEncoder();
//		String encode = bCryptPasswordEncoder.encode("123");
//		System.out.println(encode);
//	}

}
