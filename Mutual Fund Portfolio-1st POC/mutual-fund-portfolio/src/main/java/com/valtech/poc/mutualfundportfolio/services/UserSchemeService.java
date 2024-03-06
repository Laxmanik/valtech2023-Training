package com.valtech.poc.mutualfundportfolio.services;

import java.math.BigDecimal;
import java.util.List;

import com.valtech.poc.mutualfundportfolio.entities.UserScheme;
import com.valtech.poc.mutualfundportfolio.entities.UserSchemeId;

public interface UserSchemeService {

	UserScheme createUserScheme(UserScheme userScheme);

	List<UserScheme> findSchemesByUser(int id);

	UserScheme findByuserAndScheme(int userId, int schemeId);

	BigDecimal getSumInvestedAmount(int userId);

	BigDecimal getSumCurrentAmount(int userId);

	BigDecimal calculateReturnsPercentage(int userId);

	void deleteUserScheme(UserSchemeId userSchemeId);

	void updateCurrentAmountForAllUsers(int schemId, BigDecimal newNavValue);
}