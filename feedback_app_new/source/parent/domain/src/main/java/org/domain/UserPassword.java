package org.domain;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="user_password")
public class UserPassword implements Serializable{

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="user_password_id")
	private Integer userPasswordId;
	
	@ManyToOne
	@JoinColumn(name="user_id")
	private User user;
	
	@Column(name="date")
	private Date date;
	
	@Column(name="appended_string")
	private String appendedString;
	
	@Column(name="is_active")
	private Boolean active;

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public String getAppendedString() {
		return appendedString;
	}

	public void setAppendedString(String appendedString) {
		this.appendedString = appendedString;
	}

	public Integer getUserPasswordId() {
		return userPasswordId;
	}

	public void setUserPasswordId(Integer userPasswordId) {
		this.userPasswordId = userPasswordId;
	}

	public Boolean getActive() {
		return active;
	}

	public void setActive(Boolean active) {
		this.active = active;
	}


	
	
}
