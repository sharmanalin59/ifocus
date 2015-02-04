package org.domain;
/**
 * @author : nalin sharma
 *
 */
import java.io.Serializable;

import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQuery;
import javax.persistence.Table;


/**
 * The persistent class for the user_manager database table.
 * 
 */
@Entity
@Table(name="user_manager")
@NamedQuery(name="UserManager.findAll", query="SELECT u FROM UserManager u")
public class UserManager implements Serializable {
	private static final long serialVersionUID = 1L;
    
/*	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="usermanager_id")
	private Long usermanagerId;
*/
	@Id
	@EmbeddedId UserManagerId userManagerId;
	
/*	//bi-directional many-to-one association to User
	@ManyToOne
	@JoinColumn(name="manager_id")
	private User managerId;

	//bi-directional many-to-one association to User
	@ManyToOne
	@JoinColumn(name="user_id")
	private User userId;

	public UserManager() {
	}*/
	
/*	@Column(name="assigned_date")
	private Date assignedDate;
	*/

/*	public Long getUsermanagerId() {
		return this.usermanagerId;
	}

	public void setUsermanagerId(Long usermanagerId) {
		this.usermanagerId = usermanagerId;
	}*/



/*	public Date getAssignedDate() {
		return assignedDate;
	}

	public void setAssignedDate(Date assignedDate) {
		this.assignedDate = assignedDate;
	}*/

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	public UserManagerId getUserManagerId() {
		return userManagerId;
	}

	public void setUserManagerId(UserManagerId userManagerId) {
		this.userManagerId = userManagerId;
	}

	/*public void setManagerId(User managerId) {
		this.managerId = managerId;
	}

	public Date getAssignedDate() {
		return assignedDate;
	}

	public void setAssignedDate(Date assignedDate) {
		this.assignedDate = assignedDate;
	}

	public User getManagerId() {
		return managerId;
	}

	public User getUserId() {
		return userId;
	}

	public void setUserId(User userId) {
		this.userId = userId;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}
*/
}