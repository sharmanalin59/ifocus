package org.domain;
/**
 * @author : nalin sharma
 *
 */
import java.io.Serializable;
import javax.persistence.*;
import java.util.Date;


/**
 * The persistent class for the appraisal database table.
 * 
 */
@Entity
@Table(name="appraisal")
@NamedQuery(name="Appraisal.findAll", query="SELECT a FROM Appraisal a")
public class Appraisal implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="appraisal_id")
	private int appraisalId;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name="appraisal_date")
	private Date appraisalDate;

	private float ctc;

	@Column(name="default_hike")
	private byte defaultHike;

	private float experience;

	@Column(name="hike_percentage")
	private float hikePercentage;

	@Column(name="previous_ctc")
	private float previousCtc;

	@Column(name="previous_hike_percentage")
	private float previousHikePercentage;

	private byte published;

	private byte rating;

	//bi-directional many-to-one association to User
	@ManyToOne
	@JoinColumn(name="appraised_by")
	private User user1;

	//bi-directional many-to-one association to User
	@ManyToOne
	@JoinColumn(name="user_id")
	private User user2;

	public Appraisal() {
	}

	public int getAppraisalId() {
		return this.appraisalId;
	}

	public void setAppraisalId(int appraisalId) {
		this.appraisalId = appraisalId;
	}

	public Date getAppraisalDate() {
		return this.appraisalDate;
	}

	public void setAppraisalDate(Date appraisalDate) {
		this.appraisalDate = appraisalDate;
	}

	public float getCtc() {
		return this.ctc;
	}

	public void setCtc(float ctc) {
		this.ctc = ctc;
	}

	public byte getDefaultHike() {
		return this.defaultHike;
	}

	public void setDefaultHike(byte defaultHike) {
		this.defaultHike = defaultHike;
	}

	public float getExperience() {
		return this.experience;
	}

	public void setExperience(float experience) {
		this.experience = experience;
	}

	public float getHikePercentage() {
		return this.hikePercentage;
	}

	public void setHikePercentage(float hikePercentage) {
		this.hikePercentage = hikePercentage;
	}

	public float getPreviousCtc() {
		return this.previousCtc;
	}

	public void setPreviousCtc(float previousCtc) {
		this.previousCtc = previousCtc;
	}

	public float getPreviousHikePercentage() {
		return this.previousHikePercentage;
	}

	public void setPreviousHikePercentage(float previousHikePercentage) {
		this.previousHikePercentage = previousHikePercentage;
	}

	public byte getPublished() {
		return this.published;
	}

	public void setPublished(byte published) {
		this.published = published;
	}

	public byte getRating() {
		return this.rating;
	}

	public void setRating(byte rating) {
		this.rating = rating;
	}

	public User getUser1() {
		return this.user1;
	}

	public void setUser1(User user1) {
		this.user1 = user1;
	}

	public User getUser2() {
		return this.user2;
	}

	public void setUser2(User user2) {
		this.user2 = user2;
	}

}