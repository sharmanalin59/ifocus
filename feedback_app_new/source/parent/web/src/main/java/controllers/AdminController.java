package controllers;

/**
 * @author : nalin sharma
 *
 */
import java.util.List;
import java.util.Locale;

import org.dtos.FeedbackAppraisalDTO;
import org.dtos.ResponseBean;
import org.dtos.RoleDTO;
import org.dtos.UserDTO;
import org.dtos.UsersBasicDetailsDTO;
import org.service.CommonService;
import org.service.RoleService;
import org.service.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping(value = "/admin")
public class AdminController {
	
	@Autowired
	UserService service;

	@Autowired
	CommonService commonService;
	
	@Autowired
	RoleService roleService;

	private static final Logger logger = LoggerFactory
			.getLogger(AdminController.class);

	@RequestMapping(value = "/createUser", method = RequestMethod.POST)
	public @ResponseBody ResponseBean<Object> createUser(
			@RequestBody UserDTO user, Locale locale) {
		logger.info("----inside createUser------.", locale);
		ResponseBean<Object> bean = new ResponseBean<Object>();
		System.out.println("hellooooo--------------" + user.getFirstName());
		String employeeId = "";
		try {
			 employeeId = service.createUser(user);
			 
		} catch (Exception e) {
			e.printStackTrace();
			logger.debug(e.getMessage());
			bean.setStatus(false);
			bean.setMessage("something wasn't in sync");
			return bean;

		}
		
		try {
			if(!"".equals(employeeId)){
			service.saveArchieveEntries(employeeId);
			bean.setStatus(true);
			bean.setMessage("successfully saved");
			}
		} catch (Exception e) {
			e.printStackTrace();
			logger.debug(e.getMessage());
			bean.setStatus(false);
			bean.setMessage("archieving had problems");
			return bean;
		}
		

		return bean;
	}

	@RequestMapping(value = "/updateUser", method = RequestMethod.POST)
	public @ResponseBody ResponseBean<Object> updateUser(@RequestBody UserDTO user, Locale locale) {
		logger.info("----inside updateUser------.", locale);
		ResponseBean<Object> bean = new ResponseBean<Object>();
		System.out.println("hellooooo--------------" + user.getFirstName());
		try {
			service.updateUser(user);
			bean.setStatus(true);
			bean.setMessage("successfully saved");
		} catch (Exception e) {
			e.printStackTrace();
			logger.debug(e.getMessage());
			bean.setStatus(false);
			bean.setMessage("something went wrong");

		}

		return bean;
	}

	@RequestMapping(value = "/removeUser/{userId}", method = RequestMethod.GET)
	public @ResponseBody ResponseBean<Object> updateUser(@PathVariable int userId, Locale locale) {
		logger.info("----inside createUser------.", locale);
		ResponseBean<Object> bean = new ResponseBean<Object>();
		try {
			service.removeUser(userId);
			bean.setStatus(true);
			bean.setData(userId);
			bean.setMessage("successfully removed");
		} catch (Exception e) {
			e.printStackTrace();
			logger.debug(e.getMessage());
			bean.setStatus(false);
			bean.setMessage("something went wrong");

		}

		return bean;
	}

	@RequestMapping(value = "/get-users/{roleId}", method = RequestMethod.GET)
	public @ResponseBody ResponseBean<List<UsersBasicDetailsDTO>> getRoleBasedUsers(
			Locale locale, @PathVariable int roleId) {
		logger.info("----inside getAllUsers------.", locale);
		ResponseBean<List<UsersBasicDetailsDTO>> bean = new ResponseBean<List<UsersBasicDetailsDTO>>();
		List<UsersBasicDetailsDTO> basicDetailsDTOs = commonService.getUsers(roleId);
		if(basicDetailsDTOs != null){
		System.out.println("basicDetailsDTOs size is...."
				+ basicDetailsDTOs.size());
		bean.setData(basicDetailsDTOs);
		}
		return bean;
	}
	
	
	@RequestMapping(value = "/get-users", method = RequestMethod.GET)
	public @ResponseBody ResponseBean<List<UsersBasicDetailsDTO>> getAllUsers(
			Locale locale) {
		logger.info("----inside getAllUsers------.", locale);
		ResponseBean<List<UsersBasicDetailsDTO>> bean = new ResponseBean<List<UsersBasicDetailsDTO>>();
		List<UsersBasicDetailsDTO> basicDetailsDTOs = commonService.getUsers();
		if(basicDetailsDTOs != null){
		System.out.println("basicDetailsDTOs size is...."
				+ basicDetailsDTOs.size());
		bean.setData(basicDetailsDTOs);
		}
		return bean;
	}
	
	@RequestMapping(value = "/get-roles", method = RequestMethod.GET)
	public @ResponseBody ResponseBean<List<RoleDTO>> getRoles(
			Locale locale) {
		logger.info("----inside getAllUsers------.", locale);
		ResponseBean<List<RoleDTO>> bean = new ResponseBean<List<RoleDTO>>();
		try{
		List<RoleDTO> roleDTOs = roleService.getAllRoles();
		if(roleDTOs != null){
		System.out.println("roleDTOs size is...."
				+ roleDTOs.size());
		bean.setData(roleDTOs);
		bean.setStatus(true);
		}
		}
		catch(Exception e){
			bean.setStatus(false);	
		}
		return bean;
	}
	

	@RequestMapping(value = "/getFeedbackFrequencyType/{feedbackFrequencyType}/groupId/{groupId}", method = RequestMethod.GET)
	public @ResponseBody ResponseBean<FeedbackAppraisalDTO> getFeedbackFrequencyType(
			@PathVariable Integer feedbackFrequencyType, @PathVariable Integer groupId,
			Locale locale) {
		logger.info("----inside getFeedbackFrequencyType------.", locale);
		ResponseBean<FeedbackAppraisalDTO> bean = new ResponseBean<FeedbackAppraisalDTO>();
		try {
			FeedbackAppraisalDTO feedbackAppraisalDTO = commonService
					.getFeedBackAppraisalValue(feedbackFrequencyType, null, groupId);
			bean.setData(feedbackAppraisalDTO);
			bean.setStatus(true);
			bean.setMessage("");
		} catch (Exception e) {
			e.printStackTrace();
			logger.debug(e.getMessage());
			bean.setStatus(false);
			bean.setMessage("something went wrong");

		}

		return bean;
	}

	@RequestMapping(value = "/getAppraisalFrequencyType/{appraisalFrequencyType}/groupId/{groupId}", method = RequestMethod.GET)
	public @ResponseBody ResponseBean<FeedbackAppraisalDTO> getAppraisalFrequencyType(
			@PathVariable int appraisalFrequencyType, @PathVariable int groupId,
			Locale locale) {
		logger.info("----inside getAppraisalFrequencyType------.", locale);
		ResponseBean<FeedbackAppraisalDTO> bean = new ResponseBean<FeedbackAppraisalDTO>();
		try {
			FeedbackAppraisalDTO feedbackAppraisalDTO = commonService
					.getFeedBackAppraisalValue(null, appraisalFrequencyType, groupId);
			bean.setData(feedbackAppraisalDTO);
			bean.setStatus(true);
			bean.setMessage("");
		} catch (Exception e) {
			e.printStackTrace();
			logger.debug(e.getMessage());
			bean.setStatus(false);
			bean.setMessage("something went wrong");

		}

		return bean;
	}

	@RequestMapping(value = "/get-user/{userId}", method = RequestMethod.GET)
	public @ResponseBody ResponseBean<UserDTO> getSingleUser(Locale locale,
			@PathVariable int userId) {
		logger.info("----inside getSingleUser------.", locale);
		UserDTO userDTO = service.getUser(userId);
		ResponseBean<UserDTO> bean = new ResponseBean<UserDTO>();
		bean.setData(userDTO);
		return bean;
	}
}