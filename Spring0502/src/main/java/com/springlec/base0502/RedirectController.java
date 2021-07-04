package com.springlec.base0502;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class RedirectController {
	
	
	//http://localhost:8080/base0502/studentConfirm?id=123
	
	@RequestMapping("studentConfirm")
	public String studentRedirect(HttpServletRequest httpServletRequest, Model model) {
		String id = httpServletRequest.getParameter("id");
		if(id.equals("abc")) {
			return "redirect:studentOK";
		}
		return "redirect:studentNG";
	}
	
	@RequestMapping("studentOK")
	public String ok(Model model) {
		return "student/studentOK";
	}
	
	@RequestMapping("studentNG")
	public String ng(Model model) {
		return "student/studentNG";
	}

}//---------------------------------------------
