package org.domain;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

/**
 * 
 * @author nalin sharma
 *
 */
@Embeddable
public class UserManagerId implements Serializable {
	

	//bi-directional many-to-one association to User
	//@ManyToOne
	@Column(name="manager_id")
	private Integer managerId;

	//bi-directional many-to-one association to User
	//@ManyToOne
	@Column(name="user_id")
	private Integer userId;

	

/*	public Long getUsermanagerId() {
		return this.usermanagerId;
	}

	public void setUsermanagerId(Long usermanagerId) {
		this.usermanagerId = usermanagerId;
	}*/

	public void setManagerId(Integer managerId) {
		this.managerId = managerId;
	}

	public Integer getManagerId() {
		return managerId;
	}

	public Integer getUserId() {
		return userId;
	}

	public void setUserId(Integer userId) {
		this.userId = userId;
	}

}
