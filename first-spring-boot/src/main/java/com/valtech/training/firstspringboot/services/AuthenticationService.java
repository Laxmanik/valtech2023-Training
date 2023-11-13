package com.valtech.training.firstspringboot.services;

import com.valtech.training.firstspringboot.entities.User;
import com.valtech.training.firstspringboot.models.ChangePasswordModel;
import com.valtech.training.firstspringboot.models.RegisterUserModel;

public interface AuthenticationService {

	User createUser(RegisterUserModel regUserModel);

	boolean changePassword(ChangePasswordModel passwordModel);

	void upgradeUserToAdmin(long id);

	void enableUser(long id);

	void disableUser(long id);

}