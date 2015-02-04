package model;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Date;


/**
 * The persistent class for the link database table.
 * 
 */
@Entity
@Table(name="link")
@NamedQuery(name="Link.findAll", query="SELECT l FROM Link l")
public class Link implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="link_id")
	private int linkId;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name="link_date")
	private Date linkDate;

	@Column(name="link_type")
	private byte linkType;

	@Column(name="link_validity")
	private int linkValidity;

	//bi-directional many-to-one association to User
	@ManyToOne
	@JoinColumn(name="user_id")
	private User user1;

	//bi-directional many-to-one association to User
	@ManyToOne
	@JoinColumn(name="manager_id")
	private User user2;

	public Link() {
	}

	public int getLinkId() {
		return this.linkId;
	}

	public void setLinkId(int linkId) {
		this.linkId = linkId;
	}

	public Date getLinkDate() {
		return this.linkDate;
	}

	public void setLinkDate(Date linkDate) {
		this.linkDate = linkDate;
	}

	public byte getLinkType() {
		return this.linkType;
	}

	public void setLinkType(byte linkType) {
		this.linkType = linkType;
	}

	public int getLinkValidity() {
		return this.linkValidity;
	}

	public void setLinkValidity(int linkValidity) {
		this.linkValidity = linkValidity;
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