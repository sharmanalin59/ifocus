package org.domain;
/**
 * @author : nalin sharma
 *
 */
import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="employee_group")
public class EmployeeGroup implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="group_id")
	private Integer groupId;	
	@Column(name="group_name")
	private String groupName;
	@Column(name="group_description",nullable=true)
	private String groupDescription;
	
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="approver",referencedColumnName="user_id",nullable=true)
	private User approver;
	@Column(name="feedback_freq")
	private Integer feedbackFrequency;
	@Column(name="appraisal_freq")
	private Integer appraisalFrequency;
	@Column(name="default_hike")
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
	public User getApprover() {
		return approver;
	}
	public void setApprover(User approver) {
		this.approver = approver;
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
	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	
	
}
