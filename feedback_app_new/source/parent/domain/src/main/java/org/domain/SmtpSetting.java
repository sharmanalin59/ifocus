package org.domain;
/**
 * @author : nalin sharma
 *
 */
import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the smtp_settings database table.
 * 
 */
@Entity
@Table(name="smtp_settings")
@NamedQuery(name="SmtpSetting.findAll", query="SELECT s FROM SmtpSetting s")
public class SmtpSetting implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="smtpsettings_id")
	private int smtpsettingsId;

	@Column(name="connection_type")
	private String connectionType;

	private String password;

	@Column(name="requires_authentication")
	private byte requiresAuthentication;

	@Column(name="sender_email_id")
	private String senderEmailId;

	@Column(name="smtp_port")
	private int smtpPort;

	@Column(name="smtp_server")
	private String smtpServer;

	private String username;

	public SmtpSetting() {
	}

	public int getSmtpsettingsId() {
		return this.smtpsettingsId;
	}

	public void setSmtpsettingsId(int smtpsettingsId) {
		this.smtpsettingsId = smtpsettingsId;
	}

	public String getConnectionType() {
		return this.connectionType;
	}

	public void setConnectionType(String connectionType) {
		this.connectionType = connectionType;
	}

	public String getPassword() {
		return this.password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public byte getRequiresAuthentication() {
		return this.requiresAuthentication;
	}

	public void setRequiresAuthentication(byte requiresAuthentication) {
		this.requiresAuthentication = requiresAuthentication;
	}

	public String getSenderEmailId() {
		return this.senderEmailId;
	}

	public void setSenderEmailId(String senderEmailId) {
		this.senderEmailId = senderEmailId;
	}

	public int getSmtpPort() {
		return this.smtpPort;
	}

	public void setSmtpPort(int smtpPort) {
		this.smtpPort = smtpPort;
	}

	public String getSmtpServer() {
		return this.smtpServer;
	}

	public void setSmtpServer(String smtpServer) {
		this.smtpServer = smtpServer;
	}

	public String getUsername() {
		return this.username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

}