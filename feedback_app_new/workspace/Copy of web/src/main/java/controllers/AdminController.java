package controllers;

import java.text.DateFormat;
import java.util.Date;
import java.util.Locale;
import java.util.concurrent.atomic.AtomicLong;

import org.domain.Dept;
import org.dtos.ResponseBean;
import org.dtos.UserDTO;
import org.service.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;


@Controller
@RequestMapping(value="/admin")
public class AdminController {
	
	/*@Autowired
	Mapper mapper;*/
	
	@Autowired
	UserService service;
	
    private static final String template = "Hello, %s!";
    private final AtomicLong counter = new AtomicLong();
	
	private static final Logger logger = LoggerFactory.getLogger(AdminController.class);
	
	/**
	 * Simply selects the home view to render by returning its name.
	 */
	@RequestMapping(value = "/createUser", method = RequestMethod.POST)
	public @ResponseBody ResponseBean createUser(/*@ModelAttribute("user") */ @RequestBody UserDTO user,Locale locale, Model model) {
		logger.info("----inside createUser------.", locale);
		Date date = new Date();
		ResponseBean bean = new ResponseBean<Object>();
		DateFormat dateFormat = DateFormat.getDateTimeInstance(DateFormat.LONG, DateFormat.LONG, locale);
		
		String formattedDate = dateFormat.format(date);
		System.out.println("hellooooo--------------"+user.getFirstName());
		model.addAttribute("serverTime", formattedDate );
		try {
			service.createUser(user);
			bean.setStatus(true);
			bean.setMessage("successfully saved");
		} catch (Exception e) {

			bean.setStatus(false);
			bean.setMessage("something went wrong");
			
		}
		
		return bean;
	}
	
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public @ResponseBody ResponseBean use(Locale locale, Model model) {
		logger.info("----inside createUser------.", locale);
		Date date = new Date();
		DateFormat dateFormat = DateFormat.getDateTimeInstance(DateFormat.LONG, DateFormat.LONG, locale);
		
		String formattedDate = dateFormat.format(date);
		System.out.println("hellooooo--------------");
		model.addAttribute("serverTime", formattedDate );
		ResponseBean bean = new ResponseBean<Object>();
		return bean;
	}
	
	@RequestMapping(value = "/dept", method = RequestMethod.POST)
	public @ResponseBody ResponseBean dept(Locale locale, Model model,@RequestBody Dept dept) {
		logger.info("----inside createUser------.", locale);
		Date date = new Date();
		DateFormat dateFormat = DateFormat.getDateTimeInstance(DateFormat.LONG, DateFormat.LONG, locale);
		
		String formattedDate = dateFormat.format(date);
		System.out.println("hellooooo--------------"+dept.getName());
		model.addAttribute("serverTime", formattedDate );
		ResponseBean bean = new ResponseBean<Object>();
		return bean;
	}
	
	

/*    @RequestMapping("/greeting")
    public Greeting greeting(@RequestParam(value="name", defaultValue="World") String name) {
        return new Greeting(counter.incrementAndGet(),
                            String.format(template, name));
    }
*/
}