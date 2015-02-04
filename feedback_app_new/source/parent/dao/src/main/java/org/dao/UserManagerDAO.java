package org.dao;

import java.util.List;

import org.domain.User;
import org.domain.UserManager;

public interface UserManagerDAO {

	public void removeUserManagerEntries(Integer userId,List<Integer> managerIds);
	public void removeUserManagerEntriesBasedOnManagerEntityList(Integer userId, List<User> managers);
	public UserManager getUserManager(Integer userId,Integer managerId);
	public void updateAssignedDate(Integer userId, List<Integer> managerIds);
	public void createUserMnagerEntry(Integer userId, Integer managerId);
	public void createUserManager(UserManager userManager);
}
