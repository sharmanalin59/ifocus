package org.service;

import java.util.Map;
/**
 * 
 * @author nalin sharma
 *
 */
public interface UserPasswordService {

	public Map<Integer,String> generateLink(String emialId,String basePath);
	public boolean isRequestActiveNValid(Integer userId,boolean isActive,String token);
	public void changePassword(Integer userId,String newPassword);
	
}
