package aliang.web.controller.test;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import aliang.entity.test.ServiceOrder;

@Controller
@RequestMapping("/test")
public class TestController {
	
	
	
	@RequestMapping("/index")
	public ModelAndView index(HttpSession session,String name){
		ModelAndView mv = new ModelAndView();
		if(name!=null){
			session.setAttribute("user", name);
		}
		mv.setViewName("/test/index");
		return mv;
	}
	
	@RequestMapping("/login")
	public ModelAndView login(){
		ModelAndView mv = new ModelAndView();
		mv.setViewName("login");
		return mv;
	}
	
	
	
	/**
	 * 
	 * 保存并且启动
	 * @return
	 */
	@RequestMapping("/saveAndStart")
	public ModelAndView saveAndStart(HttpSession session,ServiceOrder serviceOrder){
		ModelAndView mv = new ModelAndView();
		mv.setViewName("redirect:/test/index");
		
		return mv;
	}

	
	
	@RequestMapping(value = "/testMenu", produces = {"text/javascript;charset=UTF-8"})  
	@ResponseBody
	public String  testMenu(){
		
		String data="["+
		   "{"+
		        "id: 1,"+
		       "text: \"系统设置\","+
		        "children: ["+
		           " {"+
	                	"id: 11,"+
		        		"text:\"用户管理\","+
		        		"url:\"/test/userList.do\""+
		           " },"+
		            "{"+
		              "id: 12,"+
		        		"text:\"角色管理\","+
		        		"url:\"/test/userList.do\""+
		            "}"+
		       " ]"+
		   " },"+
		    "{"+
		    	"id: 2,"+
		       "text: \"基础数据\","+
		       "children: ["+
		            "{"+
		              " id: 21,"+
		        		"text:\"省市县管理\","+
		        		"url:\"/test/userList.do\""+
		            "}"+
		        "]"+
		    "}"+
		"]";
		
		return data;
	}
	

	@RequestMapping("/userList")
	public ModelAndView userList(){
		ModelAndView mv = new ModelAndView();
		mv.setViewName("/test/userList");
		return mv;
	}

}



