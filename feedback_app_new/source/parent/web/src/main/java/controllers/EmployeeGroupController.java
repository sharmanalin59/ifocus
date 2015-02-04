package controllers;

import java.util.List;
import java.util.Locale;

import org.dtos.EmployeeGroupDTO;
import org.dtos.ResponseBean;
import org.service.EmployeeGroupService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping(value="/group")
public class EmployeeGroupController {

	
	@Autowired
	EmployeeGroupService employeeGroupService;
	
	private static final Logger logger = LoggerFactory
			.getLogger(EmployeeGroupController.class);

	@RequestMapping(value = "/getGroups", method = RequestMethod.GET)
	public @ResponseBody ResponseBean<Object> getGroups( Locale locale) {
		logger.info("----inside createUser------.", locale);
		ResponseBean<Object> bean = new ResponseBean<Object>();
		try {

			List<EmployeeGroupDTO> employeeGroups = employeeGroupService.getAllGroups();
			bean.setData(employeeGroups);
			bean.setStatus(true);
			
		} catch (Exception e) {
			e.printStackTrace();
			logger.debug(e.getMessage());
			bean.setStatus(false);
			bean.setData(null);
			bean.setMessage("something wasn't in sync");

		}
		return bean;
		}
	
}
