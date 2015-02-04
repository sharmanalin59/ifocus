package controllers;

import java.util.Iterator;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.dtos.PasswordDTO;
import org.dtos.ResponseBean;
import org.service.UserPasswordService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;
/**
 * 
 * @author nalin sharma
 *
 */
@Controller
@RequestMapping(value="/password")
public class PasswordController {
	
	@Autowired
	UserPasswordService userPasswordService;
	
	@RequestMapping(value="/forgotten/page",method=RequestMethod.GET)
	public ModelAndView getPasswordForgottenPage(){
		System.out.println("forgotten......");
		ModelAndView mnv = new ModelAndView("forgotPassword");
		//userPasswordService.generateLink(emailId);
		mnv.addObject("success",true);
		return mnv;
	}
	
	@RequestMapping(value="/link",method=RequestMethod.GET)
	public @ResponseBody ResponseBean<Object> sendPasswordForgotten(@RequestParam("emailId") String emailId,HttpServletRequest request){
		System.out.println("link......");
		//ModelAndView mnv = new ModelAndView("forgotPassword");
		String path = request.getRequestURL().toString();
		ResponseBean<Object> bean = new ResponseBean<Object>();
		 
		try{
			
		Map userIdToken = userPasswordService.generateLink(emailId,path);
		bean.setStatus(true);
		bean.setMessage("a link has been sent");
		if(userIdToken == null)
			bean.setStatus(false);
		    bean.setMessage("incorrect emailId");
		}
		catch(Exception e){
			e.printStackTrace();
			bean.setStatus(false);
			bean.setMessage("invalid emailId");
		}
/*		Integer userId = null;
		String token = "";
		if(userIdToken != null){
			Iterator it = (Iterator) userIdToken.entrySet().iterator();
			while(it.hasNext()){
				Map.Entry es = (Map.Entry)it.next();
				userId = (Integer) es.getKey();
				token = (String) es.getValue();
			}
			
		}
		if(userId != null && !"".equals(token)){
			String path = request.getRequestURL().toString();
			path = path.substring(0, path.indexOf("link"));
			urlLink = path+"change/page?userId="+userId+"&token="+token;
			bean.setStatus(true);
		}*/
		return bean;
	}
	
	@RequestMapping(value="/change/page",method=RequestMethod.GET)
	public ModelAndView changePassword(@RequestParam("userId") Integer userId,@RequestParam("token") String token){
		System.out.println("change......");
		//String token = userPasswordService.generateLink(emailId);
		//System.out.println("token......"+token);
		boolean valid= userPasswordService.isRequestActiveNValid(userId, true, token);
		ModelAndView modelAndView = null;
		if(valid){
			modelAndView = new ModelAndView("changePassword");
			modelAndView.addObject("userId",userId);
			modelAndView.addObject("token",token);
			return modelAndView;
		}
		else
			return new ModelAndView("passwordExpired");
	}
	
	@RequestMapping(value="/update/pass",method=RequestMethod.POST)
	public @ResponseBody ResponseBean<Object> changePassword(@RequestBody PasswordDTO passwordDTO){
		System.out.println("change......");
		String enteredPassword = passwordDTO.getPassword(); 
		Integer userId = passwordDTO.getUserId();
		//check again has the time lapsed if yes tell user link has already expired
		ResponseBean<Object> bean = new ResponseBean<Object>();
		boolean valid= userPasswordService.isRequestActiveNValid(userId, true, passwordDTO.getAppendedString());
		if(valid){
			try{
			userPasswordService.changePassword(userId, enteredPassword);
			bean.setStatus(true);
			bean.setMessage("changed successfully!!");
			}catch(Exception e){
				bean.setStatus(false);
				bean.setMessage("something went wrong please retry!");
			}
			return bean;
		}
		bean.setMessage("link expired please regenerate the link!!");
		bean.setStatus(false);
		return bean;
	}
	
	
	
}
