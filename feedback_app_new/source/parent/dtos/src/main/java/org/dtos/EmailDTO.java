package org.dtos;

public class EmailDTO {
private String name;
private String subject;
private String body;
private String link;
private String emailId;


public String getEmailId() {
	return emailId;
}
public void setEmailId(String emailId) {
	this.emailId = emailId;
}
public String getLink() {
	return link;
}
public void setLink(String link) {
	this.link = link;
}
public String getName() {
	return name;
}
public void setName(String name) {
	this.name = name;
}
public String getSubject() {
	return subject;
}
public void setSubject(String subject) {
	this.subject = subject;
}
public String getBody() {
	return body;
}
public void setBody(String body) {
	this.body = body;
}


}
