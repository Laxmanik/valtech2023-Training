package com.valtech.poc.mutualfundportfolio.services;

import com.valtech.poc.mutualfundportfolio.entities.Transaction;
import com.valtech.poc.mutualfundportfolio.entities.User;

public interface EmailService {

	String getUserRegistrationDetails(User user) throws Exception;

	void sendUserRegistrationMail(User user) throws Exception;

	void sendUserTransactionMail(Transaction transaction) throws Exception;

	String getUserTransactionDetails(Transaction transaction) throws Exception;
}