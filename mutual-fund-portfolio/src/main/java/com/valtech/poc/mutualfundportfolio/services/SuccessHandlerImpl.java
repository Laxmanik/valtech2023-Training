package com.valtech.poc.mutualfundportfolio.services;

import java.io.IOException;

import org.slf4j.LoggerFactory;
import org.springframework.security.core.Authentication;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;
import org.springframework.stereotype.Service;

import ch.qos.logback.classic.Logger;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@Service
public class SuccessHandlerImpl implements AuthenticationSuccessHandler {
	
	private static final Logger logger = (Logger) LoggerFactory.getLogger(SuccessHandlerImpl.class);

	@Override
	public void onAuthenticationSuccess(HttpServletRequest request, HttpServletResponse response,
			Authentication authentication) throws IOException, ServletException {

		var authourities = authentication.getAuthorities();
		var role = authourities.stream().map(r -> r.getAuthority()).findFirst();

		if (role.orElse("").equals("USER")) {
			response.sendRedirect("/mutualfund/home");
		} else if (role.orElse("").equals("ADMIN")) {
			response.sendRedirect("/mutualfund/admin");
		} else {
			response.sendRedirect("/error");
		}
	}
}
