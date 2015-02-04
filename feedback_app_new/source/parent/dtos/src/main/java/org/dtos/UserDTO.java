package org.dtos;

/**
 * @author : nalin sharma
 *
 */
import java.util.Arrays;
import java.util.Date;
import java.util.List;
import java.util.Map;

public class UserDTO 
{
	private Integer userId;	
	private String firstName;	
	private String lastName;
	private String gender;
	private String employeeId;
	private String photo;
	private Long phoneNumber;
	private String emailAddress;
	private String password;
	/*private Integer roleId;*/
	private List<Integer> roleIds;
/*	private Integer roleId;
	private String roleName;*/
	private Integer groupId;
	private String groupName;
	private Float experience;
	private String skillset;
	private Float ctc;
	private Integer approverId;
	private String approverName;
	private Byte approverType;
	private List<Integer> managerIds;
	private Map<Integer,String> managersMap;
	/*private Date nextFeedbackDate;*/
	private Byte feedbackFrequencyType;
	/*private Date nextAppraisalDate;*/
	private Byte appraisalFrequencyType;
	private Float lastHikePercentage;
	private Integer feedbackFrequency;
	private Integer appraisalFrequency;
	private Boolean isInternal;
	/*private Date joiningDate;*/
	
	
	
	public Map<Integer, String> getManagersMap() {
		return managersMap;
	}
	public Boolean getIsInternal() {
		return isInternal;
	}
	public void setIsInternal(Boolean isInternal) {
		this.isInternal = isInternal;
	}
	public void setManagersMap(Map<Integer, String> managersMap) {
		this.managersMap = managersMap;
	}
	public String getGroupName() {
		return groupName;
	}
	public void setGroupName(String groupName) {
		this.groupName = groupName;
	}
	public String getApproverName() {
		return approverName;
	}
	public void setApproverName(String approverName) {
		this.approverName = approverName;
	}
	public Integer getUserId() {
		return userId;
	}
	public void setUserId(Integer userId) {
		this.userId = userId;
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
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	public String getEmployeeId() {
		return employeeId;
	}
	public void setEmployeeId(String employeeId) {
		this.employeeId = employeeId;
	}
	public String getPhoto() {
		return photo;
	}
	public void setPhoto(String photo) {
		this.photo = photo;
	}
	public Long getPhoneNumber() {
		return phoneNumber;
	}
	public void setPhoneNumber(Long phoneNumber) {
		this.phoneNumber = phoneNumber;
	}
	public String getEmailAddress() {
		return emailAddress;
	}
	public void setEmailAddress(String emailAddress) {
		this.emailAddress = emailAddress;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
/*	public RoleDTO getRole() {
		return role;
	}
	public void setRole(RoleDTO role) {
		this.role = role;
	}*/
/*	public Integer getRoleId() {
		return roleId;
	}
	public void setRoleId(Integer roleId) {
		this.roleId = roleId;
	}
*/	public Integer getGroupId() {
		return groupId;
	}
	public void setGroupId(Integer groupId) {
		this.groupId = groupId;
	}
	public Float getExperience() {
		return experience;
	}
	public void setExperience(Float experience) {
		this.experience = experience;
	}
	public String getSkillset() {
		return skillset;
	}
	public void setSkillset(String skillset) {
		this.skillset = skillset;
	}
	public Float getCtc() {
		return ctc;
	}
	public void setCtc(Float ctc) {
		this.ctc = ctc;
	}
	public Integer getApproverId() {
		return approverId;
	}
	public void setApproverId(Integer approverId) {
		this.approverId = approverId;
	}
	public Byte getApproverType() {
		return approverType;
	}
	public void setApproverType(Byte approverType) {
		this.approverType = approverType;
	}

	public List<Integer> getManagerIds() {
		return managerIds;
	}
	public void setManagerIds(List<Integer> managerIds) {
		this.managerIds = managerIds;
	}
	/*	public Date getNextFeedbackDate() {
		return nextFeedbackDate;
	}
	public void setNextFeedbackDate(Date nextFeedbackDate) {
		this.nextFeedbackDate = nextFeedbackDate;
	}*/
	public Byte getFeedbackFrequencyType() {
		return feedbackFrequencyType;
	}
	public void setFeedbackFrequencyType(Byte feedbackFrequencyType) {
		this.feedbackFrequencyType = feedbackFrequencyType;
	}
	/*public Date getNextAppraisalDate() {
		return nextAppraisalDate;
	}
	public void setNextAppraisalDate(Date nextAppraisalDate) {
		this.nextAppraisalDate = nextAppraisalDate;
	}*/
	public Byte getAppraisalFrequencyType() {
		return appraisalFrequencyType;
	}
	public void setAppraisalFrequencyType(Byte appraisalFrequencyType) {
		this.appraisalFrequencyType = appraisalFrequencyType;
	}
	public Float getLastHikePercentage() {
		return lastHikePercentage;
	}
	public void setLastHikePercentage(Float lastHikePercentage) {
		this.lastHikePercentage = lastHikePercentage;
	}
	public Integer getFeedbackFrequency() {
		return feedbackFrequency;
	}
	public void setFeedbackFrequency(Integer feedbackFrequency) {
		this.feedbackFrequency = feedbackFrequency;
	}
	public Integer getAppraisalFrequency() {
		return appraisalFrequency;
	}
	public void setAppraisalFrequency(Integer appraisalFrequency) {
		this.appraisalFrequency = appraisalFrequency;
	}
	/*public Date getJoiningDate() {
		return joiningDate;
	}
	public void setJoiningDate(Date joiningDate) {
		this.joiningDate = joiningDate;
	}*/
/*	public String getRoleName() {
		return roleName;
	}
	public void setRoleName(String roleName) {
		this.roleName = roleName;
	}*/
	public List<Integer> getRoleIds() {
		return roleIds;
	}
	public void setRoleIds(List<Integer> roleIds) {
		this.roleIds = roleIds;
	}
	@Override
	public String toString() {
		return "UserDTO [userId=" + userId + ", firstName=" + firstName
				+ ", lastName=" + lastName + ", gender=" + gender
				+ ", employeeId=" + employeeId + ", photo=" + photo
				+ ", phoneNumber=" + phoneNumber + ", emailAddress="
				+ emailAddress + ", password=" + password + ", roleIds="
				+ roleIds + ", groupId=" + groupId + ", groupName=" + groupName
				+ ", experience=" + experience + ", skillset=" + skillset
				+ ", ctc=" + ctc + ", approverId=" + approverId
				+ ", approverName=" + approverName + ", approverType="
				+ approverType + ", managerIds=" + managerIds
				+ ", managersMap=" + managersMap + ", feedbackFrequencyType="
				+ feedbackFrequencyType + ", appraisalFrequencyType="
				+ appraisalFrequencyType + ", lastHikePercentage="
				+ lastHikePercentage + ", feedbackFrequency="
				+ feedbackFrequency + ", appraisalFrequency="
				+ appraisalFrequency + ", isInternal=" + isInternal + "]";
	}

	
}
