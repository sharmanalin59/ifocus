package org.dtos;
/**
 * @author nalin.sharma
 */
public class EmployeeGroupDTO {
	private Integer groupId;
	private String groupName;
	private String groupDescription;
	private Integer approverId;
	private Integer feedbackFrequency;
	private Integer appraisalFrequency;
	private Float defaultHike;
	
	public Integer getGroupId() {
		return groupId;
	}
	public void setGroupId(Integer groupId) {
		this.groupId = groupId;
	}
	public String getGroupName() {
		return groupName;
	}
	public void setGroupName(String groupName) {
		this.groupName = groupName;
	}
	public String getGroupDescription() {
		return groupDescription;
	}
	public void setGroupDescription(String groupDescription) {
		this.groupDescription = groupDescription;
	}
	public Integer getApproverId() {
		return approverId;
	}
	public void setApproverId(Integer approverId) {
		this.approverId = approverId;
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
	public Float getDefaultHike() {
		return defaultHike;
	}
	public void setDefaultHike(Float defaultHike) {
		this.defaultHike = defaultHike;
	}
	@Override
	public String toString() {
		return "EmpoyeeGroupDTO [groupName=" + groupName
				+ ", groupDescription=" + groupDescription + ", approverId="
				+ approverId + ", feedbackFrequency=" + feedbackFrequency
				+ ", appraisalFrequency=" + appraisalFrequency
				+ ", defaultHike=" + defaultHike + "]";
	}
	
}
