package com.valtech.poc.mutualfundportfolio.services;

import java.io.IOException;

import org.springframework.security.core.Authentication;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;
import org.springframework.stereotype.Service;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@Service
public class SuccessHandlerImpl implements AuthenticationSuccessHandler {

	@Override
	public void onAuthenticationSuccess(HttpServletRequest request, HttpServletResponse response,
			Authentication authentication) throws IOException, ServletException {

		var authourities = authentication.getAuthorities();
		var role = authourities.stream().map(r -> r.getAuthority()).findFirst();

		if (role.orElse("").equals("USER")) {
			response.sendRedirect("/home");
		} else if (role.orElse("").equals("ADMIN")) {
			response.sendRedirect("/admin");
		} else {
			response.sendRedirect("/error");
		}
	}
}
