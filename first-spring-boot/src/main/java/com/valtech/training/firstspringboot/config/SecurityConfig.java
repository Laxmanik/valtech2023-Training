package com.valtech.training.firstspringboot.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.provisioning.UserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

import com.valtech.training.firstspringboot.components.Airthmetic;
import com.valtech.training.firstspringboot.components.AirthmeticImpl;
import com.valtech.training.firstspringboot.components.SimpleInterest;
import com.valtech.training.firstspringboot.components.SimpleInterestImpl;

@Configuration
public class SecurityConfig {

//	@Bean
//	public Airthmetic airthmetic() {
//		return new AirthmeticImpl();
//	}
//	
//	@Bean
//	public SimpleInterest simpleInterest() {
//		return new SimpleInterestImpl(airthmetic());
//	}

	@Bean
	public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception { // to filter user and admin
																							// login
		http.csrf().disable()
		.authorizeRequests()
		
		.antMatchers("/user","/order/**","/changePassword")
		.hasAnyRole("USER", "ADMIN")
				
		.antMatchers("/admin")
		.hasAnyRole("ADMIN")
		
		.antMatchers("/anon","/login","/logout","/register")
		.anonymous()
		
		.anyRequest()
		.authenticated();
		
//		http.httpBasic();
		
		http.formLogin()
		.loginPage("/login")
		.defaultSuccessUrl("/hello")
		.failureUrl("/login?error=true");
		
		return http.build();
	}

//	@Bean
//	public UserDetailsManager userDetailsManager() {
//		UserDetails root = User.builder().username("root").password("root").roles("USER").build();
//		UserDetails admin = User.builder().username("admin").password("admin").roles("ADMIN", "USER").build();
//		return new InMemoryUserDetailsManager(root, admin);
//	}

	@Bean
	public PasswordEncoder passwordEncoder() {
//		return NoOpPasswordEncoder.getInstance();
		return new BCryptPasswordEncoder();
	}

}
