package com.valtech.poc.mutualfundportfolio.services;

public interface EmailService {
	void sendSimpleMessage(String toEmail, String subject, String body);

}
