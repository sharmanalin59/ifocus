package model;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the employee_group database table.
 * 
 */
@Entity
@Table(name="employee_group")
@NamedQuery(name="EmployeeGroup.findAll", query="SELECT e FROM EmployeeGroup e")
public class EmployeeGroup implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="group_id")
	private int groupId;

	@Column(name="appraisal_freq")
	private int appraisalFreq;

	@Column(name="default_hike")
	private float defaultHike;

	@Column(name="feedback_freq")
	private int feedbackFreq;

	@Column(name="group_description")
	private String groupDescription;

	@Column(name="group_name")
	private String groupName;

	//bi-directional many-to-one association to User
	@ManyToOne
	@JoinColumn(name="approver")
	private User user;

	//bi-directional many-to-one association to Feedback
	@OneToMany(mappedBy="employeeGroup")
	private List<Feedback> feedbacks;

	//bi-directional many-to-one association to User
	@OneToMany(mappedBy="employeeGroupBean")
	private List<User> users;

	public EmployeeGroup() {
	}

	public int getGroupId() {
		return this.groupId;
	}

	public void setGroupId(int groupId) {
		this.groupId = groupId;
	}

	public int getAppraisalFreq() {
		return this.appraisalFreq;
	}

	public void setAppraisalFreq(int appraisalFreq) {
		this.appraisalFreq = appraisalFreq;
	}

	public float getDefaultHike() {
		return this.defaultHike;
	}

	public void setDefaultHike(float defaultHike) {
		this.defaultHike = defaultHike;
	}

	public int getFeedbackFreq() {
		return this.feedbackFreq;
	}

	public void setFeedbackFreq(int feedbackFreq) {
		this.feedbackFreq = feedbackFreq;
	}

	public String getGroupDescription() {
		return this.groupDescription;
	}

	public void setGroupDescription(String groupDescription) {
		this.groupDescription = groupDescription;
	}

	public String getGroupName() {
		return this.groupName;
	}

	public void setGroupName(String groupName) {
		this.groupName = groupName;
	}

	public User getUser() {
		return this.user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public List<Feedback> getFeedbacks() {
		return this.feedbacks;
	}

	public void setFeedbacks(List<Feedback> feedbacks) {
		this.feedbacks = feedbacks;
	}

	public Feedback addFeedback(Feedback feedback) {
		getFeedbacks().add(feedback);
		feedback.setEmployeeGroup(this);

		return feedback;
	}

	public Feedback removeFeedback(Feedback feedback) {
		getFeedbacks().remove(feedback);
		feedback.setEmployeeGroup(null);

		return feedback;
	}

	public List<User> getUsers() {
		return this.users;
	}

	public void setUsers(List<User> users) {
		this.users = users;
	}

	public User addUser(User user) {
		getUsers().add(user);
		user.setEmployeeGroupBean(this);

		return user;
	}

	public User removeUser(User user) {
		getUsers().remove(user);
		user.setEmployeeGroupBean(null);

		return user;
	}

}