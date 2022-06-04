package com.school.security;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

/**
 * spring security configuration
 * @author Dan
 *
 */
@Configuration
@EnableWebSecurity //it's allow the static resource
public class SecurityConfig extends WebSecurityConfigurerAdapter {

	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		// TODO Auto-generated method stub
		super.configure(auth);
	}

//	@Override
//	public void configure(WebSecurity web) throws Exception {
//		web.ignoring().antMatchers("/css/**","/images/**","/js/**"); //it's allow the static resource
//	}

	/**
	 * to do the http request authenticated
	 */
	@Override
	protected void configure(HttpSecurity http) throws Exception {
//		http.httpBasic()//allow httpbaisc(pop-up) authenticated, do not have high security
//		.and().authorizeHttpRequests().anyRequest().authenticated();//all request need to authenticated
		
		http.formLogin()//form authenticated
		.loginPage("/login") //use custom login page
		.and().authorizeHttpRequests()
		.antMatchers("/login").permitAll() // login do not need to authenticated
		.anyRequest().authenticated();
	}
	
}
