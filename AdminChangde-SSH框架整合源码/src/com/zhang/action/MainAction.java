package com.zhang.action;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;



@Controller
@RequestMapping(value="/main")
public class MainAction {
	

	@RequestMapping(value="/showInfo")
	public ModelAndView showInfo(HttpServletRequest request){
		
		//return new ModelAndView(info)
		return new ModelAndView("info");
	}
}
