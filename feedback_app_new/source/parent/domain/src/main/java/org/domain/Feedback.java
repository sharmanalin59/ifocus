package org.domain;
/**
 * @author : nalin sharma
 *
 */
import java.io.Serializable;
import javax.persistence.*;
import java.util.Date;


/**
 * The persistent class for the feedback database table.
 * 
 */
@Entity
@Table(name="feedback")
@NamedQuery(name="Feedback.findAll", query="SELECT f FROM Feedback f")
public class Feedback implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="feedback_id")
	private int feedbackId;

	private String feedback;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name="feedback_date")
	private Date feedbackDate;

	@Column(name="feedback_type")
	private byte feedbackType;

	@Column(name="manager_id")
	private int managerId;

	@Column(name="marked_for_deletion")
	private byte markedForDeletion;

	private byte submitted;

	//bi-directional many-to-one association to User
	@ManyToOne
	@JoinColumn(name="user_id")
	private User user1;

	//bi-directional many-to-one association to EmployeeGroup
	@ManyToOne
	@JoinColumn(name="group_id")
	private EmployeeGroup employeeGroup;

	public Feedback() {
	}

	public int getFeedbackId() {
		return this.feedbackId;
	}

	public void setFeedbackId(int feedbackId) {
		this.feedbackId = feedbackId;
	}

	public String getFeedback() {
		return this.feedback;
	}

	public void setFeedback(String feedback) {
		this.feedback = feedback;
	}

	public Date getFeedbackDate() {
		return this.feedbackDate;
	}

	public void setFeedbackDate(Date feedbackDate) {
		this.feedbackDate = feedbackDate;
	}

	public byte getFeedbackType() {
		return this.feedbackType;
	}

	public void setFeedbackType(byte feedbackType) {
		this.feedbackType = feedbackType;
	}

	public int getManagerId() {
		return this.managerId;
	}

	public void setManagerId(int managerId) {
		this.managerId = managerId;
	}

	public byte getMarkedForDeletion() {
		return this.markedForDeletion;
	}

	public void setMarkedForDeletion(byte markedForDeletion) {
		this.markedForDeletion = markedForDeletion;
	}

	public byte getSubmitted() {
		return this.submitted;
	}

	public void setSubmitted(byte submitted) {
		this.submitted = submitted;
	}

	public User getUser1() {
		return this.user1;
	}

	public void setUser1(User user1) {
		this.user1 = user1;
	}

	public EmployeeGroup getEmployeeGroup() {
		return this.employeeGroup;
	}

	public void setEmployeeGroup(EmployeeGroup employeeGroup) {
		this.employeeGroup = employeeGroup;
	}

}