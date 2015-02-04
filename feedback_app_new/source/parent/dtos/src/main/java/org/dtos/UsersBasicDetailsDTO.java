package org.dtos;
/**
 * @author : nalin sharma
 *
 */
public class UsersBasicDetailsDTO {

	private Integer userId;
	private String employeeId;
	private String firstName;
	private String lastName;
	public Integer getUserId() {
		return userId;
	}
	public void setUserId(Integer userId) {
		this.userId = userId;
	}

	public String getEmployeeId() {
		return employeeId;
	}
	public void setEmployeeId(String employeeId) {
		this.employeeId = employeeId;
	}
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	@Override
	public String toString() {
		return "UsersBasicDetailsDTO [userId=" + userId + ", employeeId="
				+ employeeId + ", firstName=" + firstName + ", lastName="
				+ lastName + "]";
	}
	
}
