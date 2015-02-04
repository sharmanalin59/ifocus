package model;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the user_manager database table.
 * 
 */
@Entity
@Table(name="user_manager")
@NamedQuery(name="UserManager.findAll", query="SELECT u FROM UserManager u")
public class UserManager implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="usermanager_id")
	private int usermanagerId;

	//bi-directional many-to-one association to User
	@ManyToOne
	@JoinColumn(name="manager_id")
	private User user1;

	//bi-directional many-to-one association to User
	@ManyToOne
	@JoinColumn(name="user_id")
	private User user2;

	public UserManager() {
	}

	public int getUsermanagerId() {
		return this.usermanagerId;
	}

	public void setUsermanagerId(int usermanagerId) {
		this.usermanagerId = usermanagerId;
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