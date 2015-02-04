package model;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the email_template database table.
 * 
 */
@Entity
@Table(name="email_template")
@NamedQuery(name="EmailTemplate.findAll", query="SELECT e FROM EmailTemplate e")
public class EmailTemplate implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="emailtemplate_id")
	private int emailtemplateId;

	@Column(name="default_template")
	private byte defaultTemplate;

	private String template;

	@Column(name="template_type")
	private byte templateType;

	public EmailTemplate() {
	}

	public int getEmailtemplateId() {
		return this.emailtemplateId;
	}

	public void setEmailtemplateId(int emailtemplateId) {
		this.emailtemplateId = emailtemplateId;
	}

	public byte getDefaultTemplate() {
		return this.defaultTemplate;
	}

	public void setDefaultTemplate(byte defaultTemplate) {
		this.defaultTemplate = defaultTemplate;
	}

	public String getTemplate() {
		return this.template;
	}

	public void setTemplate(String template) {
		this.template = template;
	}

	public byte getTemplateType() {
		return this.templateType;
	}

	public void setTemplateType(byte templateType) {
		this.templateType = templateType;
	}

}