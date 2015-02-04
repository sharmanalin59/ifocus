package controllers;

import org.dtos.UsersBasicDetailsDTO;
import org.service.CommonService;
import org.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping(value="/welcome")
public class WelcomeController {


	@Autowired
	CommonService commonService;
	
	@RequestMapping(value="/login",method=RequestMethod.GET)
	public String getLoginPage(){
		System.out.println("executing--------------------------------------");
		return "index";
		
	}
	@RequestMapping(value="/login/error",method=RequestMethod.GET)
	public @ResponseBody ModelAndView getLoginPageFailure(){
		ModelAndView modelAndView = new ModelAndView("index");
		modelAndView.addObject("success","false");
		return modelAndView;
		
	}
	
	@RequestMapping(value="/goto",method=RequestMethod.GET)
	public String getGoToPage(){
		return "goTo";
		
	}
	@RequestMapping(value="/modify-user",method=RequestMethod.GET)
	public String getUsersModifyPage(){
		return "modifyUser";
		
	}
	
	@RequestMapping(value="/delete-user",method=RequestMethod.GET)
	public String getUsersViewDeletePage(){
		return "deleteUser";
		
	}
	//after deletion come to view page and show user who's deleted
	@RequestMapping(value="/delete-user-param",method=RequestMethod.GET)
	public ModelAndView getUsersViewDeletePageWithUserDeleted(@RequestParam("userId") Integer userId){
		ModelAndView modelAndView = new ModelAndView("deleteUser");
		UsersBasicDetailsDTO basicDetailsDTO = commonService.getUser(userId);
		modelAndView.addObject("user",basicDetailsDTO);
		return modelAndView;
	}
	
	@RequestMapping(value="/delete-user/userId/{userId}",method=RequestMethod.GET)
	public ModelAndView getUserDeletePage(@PathVariable int userId){
		ModelAndView modelAndView = new ModelAndView("deleteUserPage");
		modelAndView.addObject("userId",userId);
		return modelAndView;
		
	}
	
	@RequestMapping(value="/modify-user/userId/{userId}",method=RequestMethod.GET)
	public ModelAndView getUserModifyPage(@PathVariable int userId){
		ModelAndView modelAndView = new ModelAndView("modifyUserPage");
		modelAndView.addObject("userId",userId);
		return modelAndView;
		
	}
}
