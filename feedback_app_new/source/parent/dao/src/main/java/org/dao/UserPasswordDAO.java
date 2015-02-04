package org.dao;

import java.util.List;

import org.domain.UserPassword;

public interface UserPasswordDAO {

	public List<UserPassword> getUserPasswords();
	public void saveUserPassword(UserPassword userPassword);
	public void updateUserPassword(UserPassword userPassword);
	public void updateIsActive(Integer userId);
	public UserPassword getPasswordRequest(Integer userId,boolean isActive,String token);
}
