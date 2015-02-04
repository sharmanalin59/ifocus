package model;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the system_default database table.
 * 
 */
@Entity
@Table(name="system_default")
@NamedQuery(name="SystemDefault.findAll", query="SELECT s FROM SystemDefault s")
public class SystemDefault implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="systemdefault_id")
	private int systemdefaultId;

	@Column(name="appraisal_freq")
	private int appraisalFreq;

	@Column(name="approver_id")
	private int approverId;

	@Column(name="feedback_freq")
	private int feedbackFreq;

	@Column(name="group_id")
	private int groupId;

	public SystemDefault() {
	}

	public int getSystemdefaultId() {
		return this.systemdefaultId;
	}

	public void setSystemdefaultId(int systemdefaultId) {
		this.systemdefaultId = systemdefaultId;
	}

	public int getAppraisalFreq() {
		return this.appraisalFreq;
	}

	public void setAppraisalFreq(int appraisalFreq) {
		this.appraisalFreq = appraisalFreq;
	}

	public int getApproverId() {
		return this.approverId;
	}

	public void setApproverId(int approverId) {
		this.approverId = approverId;
	}

	public int getFeedbackFreq() {
		return this.feedbackFreq;
	}

	public void setFeedbackFreq(int feedbackFreq) {
		this.feedbackFreq = feedbackFreq;
	}

	public int getGroupId() {
		return this.groupId;
	}

	public void setGroupId(int groupId) {
		this.groupId = groupId;
	}

}