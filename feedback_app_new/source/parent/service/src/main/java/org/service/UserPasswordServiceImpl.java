package org.service;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.lang3.RandomStringUtils;
import org.dao.UserDAO;
import org.dao.UserPasswordDAO;
import org.domain.User;
import org.domain.UserPassword;
import org.dtos.EmailDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCrypt;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class UserPasswordServiceImpl implements UserPasswordService{

	@Autowired
	UserPasswordDAO userPasswordDAO;
	
	@Autowired
	UserDAO userDAO;
	
	@Autowired
	MailMail mailMAil;
	
	private final static long EXPIRYTIME = 35000;
	@Transactional
	public Map<Integer,String> generateLink(String emailId,String basePath) {
		Map<Integer,String> userIdToken = null;
		String random = "",url="";
		//List<UserPassword> list = userPasswordDAO.getUserPasswords();
		//1st find the user having the email ID
		User user = userDAO.getUserBasedOnEmailId(emailId);
		if(user != null){

			userIdToken = new HashMap<Integer,String>();
			Integer userId = user.getUserId();
			//get all the entries for a user and make isactive- 0
			List<UserPassword> list = userPasswordDAO.getUserPasswords();
			if(list != null){
				  userPasswordDAO.updateIsActive(userId);
			}
			//now save password request
			random = RandomStringUtils.randomAlphanumeric(100);
			Date date = new Date();
			random+=date.getTime();
			UserPassword userPassword = new UserPassword();
			userPassword.setActive(true);
			userPassword.setUser(user);
			userPassword.setAppendedString(random);
			if(basePath != null )
				basePath = basePath.substring(0, basePath.indexOf("link"));
			url = basePath+"change/page?userId="+userId+"&token="+random;
			
			userPassword.setDate(date);
			userPasswordDAO.saveUserPassword(userPassword);
			userIdToken.put(userId, url);
			final EmailDTO emailDTO = new EmailDTO();
			emailDTO.setName(user.getFirstName()+" "+user.getLastName());
			emailDTO.setSubject("email...");
/*			String emailLink = url;
			emailLink = "<a href='"+emailLink;
			emailLink += "'/>";*/
			emailDTO.setBody("click this link to rest the password.. "+ url);
			emailDTO.setLink(url);
			emailDTO.setEmailId(emailId);
			//send mail
			mailMAil.sendMail(emailDTO);
			
		}
		return userIdToken;
	}
	
	private boolean checkLinkExpiryTime(UserPassword userPassword){
		Long linkCreationTime = userPassword.getDate().getTime();
		Long timeNow = (new Date()).getTime();
		Long diff = (timeNow - linkCreationTime)/1000;
		System.out.println("diff in sec....."+diff);
		if(diff > EXPIRYTIME)
			{//mark isActive null if it's not
			userPassword.setActive(false);
			userPasswordDAO.updateUserPassword(userPassword);
			return false;
			}
		return true;
	}
	@Transactional
	public boolean isRequestActiveNValid(Integer userId, boolean isActive,
			String token) {
		UserPassword userPassword = userPasswordDAO.getPasswordRequest(userId, isActive, token);
		if(userPassword != null){
			return checkLinkExpiryTime(userPassword);
		}
		return false;
	}
	@Transactional
	public void changePassword(Integer userId,String newPassword){
		User user = userDAO.getUser(userId);
		String hashedPassword = BCrypt.hashpw(newPassword, BCrypt.gensalt());
		user.setPassword(hashedPassword);
		userDAO.updateUser(user);
	}

}
