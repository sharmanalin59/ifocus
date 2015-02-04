package org.service;
/**
 * @author nalin.sharma
 */
import java.util.ArrayList;
import java.util.List;

import org.dao.EmployeeGroupDAO;
import org.dao.SystemDefaultDAO;
import org.dao.UserDAO;
import org.domain.EmployeeGroup;
import org.domain.SystemDefault;
import org.domain.User;
import org.dtos.FeedbackAppraisalDTO;
import org.dtos.UsersBasicDetailsDTO;
import org.hibernate.SessionFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CommonServiceImpl implements CommonService{


	@Autowired
	private SessionFactory sessionFactory;
	
	@Autowired
	private SystemDefaultDAO defaultDAO;
	
	@Autowired
	private UserDAO userDAO;
	
	@Autowired
	private EmployeeGroupDAO employeeGroupDAO;
	
	private SystemDefault defaultFeedbackAppraisal;
	
	private static final Logger logger = LoggerFactory
			.getLogger(CommonServiceImpl.class);
	
	
	public FeedbackAppraisalDTO getFeedBackAppraisalValue(Integer feedbackFrequencyType,
			Integer appraisalFrequencyType,Integer groupId) {
		FeedbackAppraisalDTO feedbackAppraisalDTO = new FeedbackAppraisalDTO();
		if(feedbackFrequencyType != null){
			
			if(feedbackFrequencyType == 1){//system defaults
				return assignSystemDefault(feedbackAppraisalDTO,true,false);
			}
			else if(feedbackFrequencyType == 2 && groupId != null){ //group
				//find user's own group if it doesn't exist get it from default
					EmployeeGroup employeeGroup = employeeGroupDAO.getGroup(groupId);
					if(employeeGroup != null){
						feedbackAppraisalDTO.setFeedbackFrequency(employeeGroup.getFeedbackFrequency());
						return feedbackAppraisalDTO;
					}
					else{//find group from system defaults
						return assignSystemDefault(feedbackAppraisalDTO,true,false);
					}
				}
				else{
					return assignSystemDefault(feedbackAppraisalDTO,true,false);
				}
			}

		if(appraisalFrequencyType != null){
			
			if(appraisalFrequencyType == 1){//system defaults
				return assignSystemDefault(feedbackAppraisalDTO,false,true);
			}
			else if(appraisalFrequencyType == 2){ //group
				//find user's own group if it doesn't exist get it from default
					EmployeeGroup employeeGroup = employeeGroupDAO.getGroup(groupId);
					if(employeeGroup != null){
						feedbackAppraisalDTO.setAppraisalFrequency(employeeGroup.getAppraisalFrequency());
						return feedbackAppraisalDTO;
					}
					else{//find group from system defaults
						return assignSystemDefault(feedbackAppraisalDTO,true,false);
					}
				}
				else{
					return assignSystemDefault(feedbackAppraisalDTO,true,false);
				}
			}
			else if(appraisalFrequencyType == 3){
				//empty..
			}
		
		
		return null;
	}
	
	
	
	
	
	
	
	
	
	public FeedbackAppraisalDTO getFeedBackAppraisal(Integer feedbackFrequencyType,
			Integer appraisalFrequencyType,Integer userId) {
		FeedbackAppraisalDTO feedbackAppraisalDTO = new FeedbackAppraisalDTO();
		if(feedbackFrequencyType != null){
			
			if(feedbackFrequencyType == 1){//system defaults
				return assignSystemDefault(feedbackAppraisalDTO,true,false);
			}
			else if(feedbackFrequencyType == 2){ //group
				//find user's own group if it doesn't exist get it from default
				User user = userDAO.getUser(userId);
				if(user != null){
					EmployeeGroup employeeGroup = user.getGroup();
					if(employeeGroup != null){
						feedbackAppraisalDTO.setFeedbackFrequency(employeeGroup.getFeedbackFrequency());
						return feedbackAppraisalDTO;
					}
					else{//find group from system defaults
						return assignSystemDefault(feedbackAppraisalDTO,true,false);
					}
				}
				else{
					return assignSystemDefault(feedbackAppraisalDTO,true,false);
				}
			}
			else if(feedbackFrequencyType == 3){
				//empty..
			}
		}

		if(appraisalFrequencyType != null){
			
			if(appraisalFrequencyType == 1){//system defaults
				return assignSystemDefault(feedbackAppraisalDTO,false,true);
			}
			else if(appraisalFrequencyType == 2){ //group
				//find user's own group if it doesn't exist get it from default
				User user = userDAO.getUser(userId);
				if(user != null){
					EmployeeGroup employeeGroup = user.getGroup();
					if(employeeGroup != null){
						feedbackAppraisalDTO.setAppraisalFrequency(employeeGroup.getAppraisalFrequency());
						return feedbackAppraisalDTO;
					}
					else{//find group from system defaults
						return assignSystemDefault(feedbackAppraisalDTO,true,false);
					}
				}
				else{
					return assignSystemDefault(feedbackAppraisalDTO,true,false);
				}
			}
			else if(appraisalFrequencyType == 3){
				//empty..
			}
		}
		
		
		return null;
	}
	/**
	 * 
	 * @param feedbackAppraisalDTO , pass object from the caller and it back
	 * @param defaultFeedback, set it true if default feedback is required
	 * @param defaultAppraisal, set it true if default appraisal is required
	 * @return feedbackAppraisalDTO
	 */
	private FeedbackAppraisalDTO assignSystemDefault(FeedbackAppraisalDTO feedbackAppraisalDTO,boolean defaultFeedback, boolean defaultAppraisal){
		if(defaultFeedbackAppraisal == null){
			defaultFeedbackAppraisal = defaultDAO.getSystemDefault();
		}
		if(defaultAppraisal)
		feedbackAppraisalDTO.setAppraisalFrequency(defaultFeedbackAppraisal.getAppraisalFreq());
		if(defaultFeedback)
		feedbackAppraisalDTO.setFeedbackFrequency(defaultFeedbackAppraisal.getFeedbackFreq());
		return feedbackAppraisalDTO;
	}
	
	private List<UsersBasicDetailsDTO> getUsersBasicDetailsDTO(List<User> users){
		List<UsersBasicDetailsDTO> basicDetailsDTOs = new ArrayList<UsersBasicDetailsDTO>();
		if(users != null && users.size()>0){
			logger.debug("users size...."+users.size());
			System.out.println("users size...."+users.size());
		for (User user : users) {
			UsersBasicDetailsDTO basicDetailsDTO = new UsersBasicDetailsDTO();
			basicDetailsDTO.setUserId(user.getUserId());
			basicDetailsDTO.setEmployeeId(user.getEmployeeId());
			basicDetailsDTO.setFirstName(user.getFirstName());
			basicDetailsDTO.setLastName(user.getLastName());
			basicDetailsDTOs.add(basicDetailsDTO);
			}
		}
		return basicDetailsDTOs;
	}
	
	private UsersBasicDetailsDTO getUsersBasicDetailsDTO(User user){
		UsersBasicDetailsDTO basicDetailsDTO = null;
		if(user != null){
			basicDetailsDTO = new UsersBasicDetailsDTO();
			System.out.println("user is...."+user.toString());
			basicDetailsDTO.setUserId(user.getUserId());
			basicDetailsDTO.setEmployeeId(user.getEmployeeId());
			basicDetailsDTO.setFirstName(user.getFirstName());
			basicDetailsDTO.setLastName(user.getLastName());
		}
		return basicDetailsDTO;
	}
	
	public List<UsersBasicDetailsDTO> getUsers(Integer roleId) {
		
		List<User> users = userDAO.getUsers(roleId);
		if(users != null)
		return getUsersBasicDetailsDTO(users);
		else
			return null;
	}
	
	public List<UsersBasicDetailsDTO> getUsers() {
		
		List<User> users = userDAO.getUsers();
		if(users != null)
		return getUsersBasicDetailsDTO(users);
		else
			return null;
	}


	public UsersBasicDetailsDTO getUser(Integer userId) {
		User user = userDAO.getUser(userId);
		return getUsersBasicDetailsDTO(user);

	}


}
