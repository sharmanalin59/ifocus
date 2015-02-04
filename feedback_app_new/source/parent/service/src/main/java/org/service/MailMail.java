package org.service;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import javax.mail.internet.MimeMessage;

import org.apache.velocity.app.VelocityEngine;
import org.dao.UserDAO;
import org.dtos.EmailDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.MailSender;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.mail.javamail.MimeMessagePreparator;
import org.springframework.stereotype.Service;
import org.springframework.ui.velocity.VelocityEngineUtils;
@Service
public class MailMail {
	/*@Autowired
	private MailSender mailSender;
	private SimpleMailMessage simpleMailMessage;
 
	public void setSimpleMailMessage(SimpleMailMessage simpleMailMessage) {
		this.simpleMailMessage = simpleMailMessage;
	}
 
	public void setMailSender(MailSender mailSender) {
		this.mailSender = mailSender;
	}
 
	public void sendMail(String dear, String content) {
 
	   SimpleMailMessage message = new SimpleMailMessage(simpleMailMessage);
 
	   message.setText(String.format(
			simpleMailMessage.getText(), dear, content));
 
	   mailSender.send(message);
 
	}	*/
		
			
		//private ConfigService configService;	
	    @Autowired
	    private MailSender mailSender;
	    @Autowired
	    private JavaMailSender javaMailSender;
	    @Autowired
	    private VelocityEngine velocityEngine;
	    @Autowired
	    private UserDAO userDAO;
	    public void sendEmail(final EmailDTO emailDTO){

		      MimeMessagePreparator preparator = new MimeMessagePreparator() {
			        @SuppressWarnings({ "rawtypes", "unchecked" })
					public void prepare(MimeMessage mimeMessage) throws Exception {
			             MimeMessageHelper message = new MimeMessageHelper(mimeMessage);
			             message.setTo(emailDTO.getEmailId());
			             message.setBcc("adrianmatei@gmail.com");
			             message.setFrom(emailDTO.getEmailId());
			             message.setSubject("New suggested podcast");
			             message.setSentDate(new Date());
			             Map model = new HashMap();	             
			             model.put("newMessage", emailDTO);
			             
			             String text = VelocityEngineUtils.mergeTemplateIntoString(
			                velocityEngine, "velocity/emailMessage.vm", "UTF-8", model);
			             message.setText(text, true);
			          }
			       };
			       javaMailSender.send(preparator);		
	    }

	    public void sendMail(EmailDTO emailDTO) {  

	    	String from =  emailDTO.getEmailId();
	    	String to =  emailDTO.getEmailId();
	    	String subject = emailDTO.getSubject(); 
	    	String msg = emailDTO.getBody();
	    	//creating message  
	        SimpleMailMessage message = new SimpleMailMessage();  
	        message.setFrom(from);  
	        message.setTo(to);  
	        message.setSubject(subject);  
	        message.setText(msg);  
	        //sending message  
	        mailSender.send(message);     
	    }  
}