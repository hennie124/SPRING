package com.springlec.base0702.controller;

import javax.servlet.ServletRequest;
import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.springlec.base0702.command.BCommand;
import com.springlec.base0702.command.BContentCommand;
import com.springlec.base0702.command.BDeleteCommand;
import com.springlec.base0702.command.BListCommand;
import com.springlec.base0702.command.BUpdateCommand;
import com.springlec.base0702.command.BWriteCommand;
import com.springlec.base0702.util.Constant;

@Controller
public class BController {
	
	BCommand command = null;
	private JdbcTemplate template;
	
	@Autowired
	public void setTemplate(JdbcTemplate template) {
		this.template = template;
		Constant.template = this.template;
	}
	
	@RequestMapping("/list")
	public String list(Model model) {
		System.out.println("list()");
		command = new BListCommand();
		command.execute(model);
		
		return "list";
	}
	
	@RequestMapping("/write_view")
	public String write_view(Model model) {
		System.out.println("write_view()");
		return "write_view";
	}
	
	@RequestMapping("write")
	public String write(HttpServletRequest request, Model model) {
		System.out.println("write()");
		
		model.addAttribute("request", request);
		command = new BWriteCommand();
		command.execute(model);
		
		return "redirect:list";
	}
	
	@RequestMapping("/content_view")
	public String Content(HttpServletRequest request,Model model) {
		System.out.println("content_view()");
		
		model.addAttribute("request", request);
		command = new BContentCommand();
		command.execute(model);
		return "content_view";
	}
	
	@RequestMapping("delete")
	public String delete(HttpServletRequest request,Model model) {
		System.out.println("delete()");
		
		model.addAttribute("request", request);
		command = new BDeleteCommand();
		command.execute(model);
		return "redirect:list";
	}
	
	@RequestMapping("update")
	public String update(HttpServletRequest request,Model model) {
		System.out.println("update()");
		
		model.addAttribute("request", request);
		command = new BUpdateCommand();
		command.execute(model);
		return "redirect:list";
	}
}
