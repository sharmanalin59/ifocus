package org.dao;
/**
 * @author : nalin sharma
 *
 */
import java.util.List;

import org.domain.User;


public interface UserDAO {
	
	public void createUser(User userEntity);
	public void updateUser(User userEntity);
	public List<User> getUsers(List<Integer> userId);
	public List<User> getUsers(Integer roleId);
	public User getUser(Integer userId);
	public User getUser(String empId);
	public User getUserBasedOnEmailId(String emailId);
	public User getUser(String emailId, String password);
	public List<User> getUsers();
	

}
