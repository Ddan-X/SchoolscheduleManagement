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
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.CorsConfigurationSource;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;

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
		http.cors().configurationSource(configurationSource())
		.and().csrf().disable()
		 .authorizeHttpRequests()
		.antMatchers("/api/school/login").permitAll() // login do not need to authenticated
		.anyRequest().authenticated()
		.and().rememberMe()//allow the remenber me
		.tokenValiditySeconds(1209600)//token allow 2 week
		.rememberMeParameter("remember-me")
		.and().sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS)
		.and().httpBasic();
        

		//http.headers().frameOptions().sameOrigin();//load same url iframe page
	}
	/**
	 * CORS
	 */
	public CorsConfigurationSource configurationSource() {
		CorsConfiguration corsConfiguration = new CorsConfiguration();
		//allow the url
		corsConfiguration.addAllowedOrigin("http://localhost:4200");
		//allow the http method
		corsConfiguration.addAllowedMethod("*");
		//allow the http heard
		corsConfiguration.addAllowedHeader("*");
		
		corsConfiguration.setAllowCredentials(true);
		
		UrlBasedCorsConfigurationSource urlBasedCorsConfigurationSource = new UrlBasedCorsConfigurationSource();
		//allow all url
		urlBasedCorsConfigurationSource.registerCorsConfiguration("/**", corsConfiguration);
		
		return urlBasedCorsConfigurationSource;
	}
	
}
