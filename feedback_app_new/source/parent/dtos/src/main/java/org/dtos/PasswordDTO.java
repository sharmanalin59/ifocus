package org.dtos;
/**
 * 
 * @author nalin sharma
 *
 */
public class PasswordDTO {

	private Integer userId;
	private String password;
	private String appendedString;
	
	
	public String getAppendedString() {
		return appendedString;
	}

	public void setAppendedString(String appendedString) {
		this.appendedString = appendedString;
	}

	public Integer getUserId() {
		return userId;
	}

	public void setUserId(Integer userId) {
		this.userId = userId;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}
	
}
