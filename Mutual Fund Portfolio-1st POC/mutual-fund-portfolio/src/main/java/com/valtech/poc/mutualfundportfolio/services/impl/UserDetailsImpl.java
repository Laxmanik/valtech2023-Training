package com.valtech.poc.mutualfundportfolio.services.impl;

import java.util.Collection;
import java.util.Collections;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import com.valtech.poc.mutualfundportfolio.entities.User;

public class UserDetailsImpl implements UserDetails {

	private static final long serialVersionUID = 1L;
	private transient User user;

	public UserDetailsImpl() {
	}

	public UserDetailsImpl(User user) {
		this.user = user;
	}

	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		SimpleGrantedAuthority authority = new SimpleGrantedAuthority(user.getRole());

		return Collections.singletonList(authority);
	}

	@Override
	public String getPassword() {

		return user.getPassword();
	}

	@Override
	public String getUsername() {

		return (user != null) ? user.getPortfolioNumber() : null;
	}

	@Override
	public boolean isAccountNonExpired() {

		return true;
	}

	@Override
	public boolean isAccountNonLocked() {

		return true;
	}

	@Override
	public boolean isCredentialsNonExpired() {

		return true;
	}

	@Override
	public boolean isEnabled() {

		return user.isEnabled();
	}

	public int getUserId() {

		return user.getId();
	}

}