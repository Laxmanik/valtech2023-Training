package com.valtech.poc.mutualfundportfolio.services;

import com.valtech.poc.mutualfundportfolio.entities.User;

public interface EmailService {
	String getEmailContent(User user) throws Exception;

	void sendSimpleMessage(User user) throws Exception;

}
