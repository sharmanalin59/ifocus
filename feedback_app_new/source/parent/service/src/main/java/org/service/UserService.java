package org.service;
/**
 * @author : nalin sharma
 *
 */
import org.domain.User;
import org.dtos.UserDTO;

public interface UserService {

	public String createUser(UserDTO userDTO);
	public void updateUser(UserDTO userDTO);
	public UserDTO getUser(Integer userId); 
	public void removeUser(Integer userId); 
	public void saveArchieveEntries(String employeeId);
	public User getUser(String emailId,String password);
	
}
