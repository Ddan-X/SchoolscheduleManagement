package com.school.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;

import com.school.service.Impl.UserDetailsServiceImpl;

/**
 * spring security configuration
 * @author Dan
 *
 */
@Configuration
@EnableWebSecurity //it's allow the static resource, image, css, js..
@EnableGlobalMethodSecurity(prePostEnabled = true) //allow the multiple endpoint
public class SecurityConfig extends WebSecurityConfigurerAdapter {

	@Autowired
	UserDetailsServiceImpl userDetailsServiceImpl;
	
	@Bean
	@Override
	protected AuthenticationManager authenticationManager() throws Exception {
		// TODO Auto-generated method stub
		return super.authenticationManager();
	}
	
	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		// TODO Auto-generated method stub
		auth.userDetailsService(userDetailsServiceImpl);
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
		
//		http.formLogin()//form authenticated
//		.loginPage("/login") //use custom login page
//		.loginProcessingUrl("")//submit form url
//		.usernameParameter("zoeDan")
//		.passwordParameter("101609")
//		.successForwardUrl("")//success login transfer url
		http.cors().and().csrf().disable()
		 .authorizeHttpRequests()
		.antMatchers("/api/school/login").permitAll() // login do not need to authenticated
		.anyRequest().authenticated()
		.and().sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS)
		.and().httpBasic();
        

		//http.headers().frameOptions().sameOrigin();//load same url iframe page
	}
	
}
