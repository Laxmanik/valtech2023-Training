package com.valtech.poc.mutualfundportfolio.configuration;

import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;

import com.valtech.poc.mutualfundportfolio.controllers.UserController;
import com.valtech.poc.mutualfundportfolio.services.SuccessHandlerImpl;
import com.valtech.poc.mutualfundportfolio.services.UserDetailsServiceImpl;

import ch.qos.logback.classic.Logger;

@Configuration
@EnableWebSecurity
public class SecurityConfig {
	
	private static final Logger logger = (Logger) LoggerFactory.getLogger(SecurityConfig.class);

	@Autowired
	private UserDetailsServiceImpl userDetailsService;

	@Autowired
	private SuccessHandlerImpl successHandler;

	@Bean
	public SecurityFilterChain securityFilterChain(HttpSecurity httpSecurity) throws Exception {

		httpSecurity.csrf(c -> c.disable())
				.authorizeHttpRequests(request -> request.requestMatchers("/mutualfund/admin").hasAuthority("ADMIN")
						.requestMatchers("/mutualfund/user").hasAuthority("USER").requestMatchers("/mutualfund/register", "/css/**", "/mutualfund")
						.permitAll().anyRequest().authenticated());

		httpSecurity
				.formLogin(formLogin -> formLogin.loginPage("/mutualfund/login").loginProcessingUrl("/mutualfund/login")
						.successHandler(successHandler).permitAll())
				.logout(logout -> logout.invalidateHttpSession(true).clearAuthentication(true)
						.logoutRequestMatcher(new AntPathRequestMatcher("/logout")).logoutSuccessUrl("/login?logout")
						.permitAll());

		return httpSecurity.build();
	}

	@Bean
	public static PasswordEncoder passwordEncoder() {
		return new BCryptPasswordEncoder();
	}

	@Autowired
	public void configure(AuthenticationManagerBuilder auth) throws Exception {
		auth.userDetailsService(userDetailsService).passwordEncoder(passwordEncoder());
	}

}
