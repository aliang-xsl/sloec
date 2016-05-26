package aliang.web.controller.system;


import javax.annotation.Resource;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import aliang.service.system.IUserService;

@Controller
@RequestMapping("/user")
public class UserController {
	
	@Resource
	private IUserService userService;
	
	/*@RequestMapping(value="/login",method=RequestMethod.POST)
	public ModelAndView login(User user){
	//System.out.println(user.getUserName());
		return new ModelAndView("redirect:/");
	}*/
	
	


}
