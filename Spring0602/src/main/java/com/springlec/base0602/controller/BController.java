package com.springlec.base0602.controller;

import javax.servlet.ServletRequest;
import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.springlec.base0602.command.BCommand;
import com.springlec.base0602.command.BContentCommand;
import com.springlec.base0602.command.BDeleteCommand;
import com.springlec.base0602.command.BListCommand;
import com.springlec.base0602.command.BUpdateCommand;
import com.springlec.base0602.command.BWriteCommand;

@Controller
public class BController {
	
	//BCommand command = null;
	private BCommand listCommand = null;
	private BCommand writeCommand = null;
	private BCommand contentCommand = null;
	private BCommand updateCommand = null;
	private BCommand deleteCommand = null;
	
	@Autowired
	public void auto(BListCommand list,BWriteCommand write,BContentCommand content,BUpdateCommand update,BDeleteCommand delete) {
		this.listCommand = list;
		this.writeCommand = write;
		this.contentCommand = content;
		this.updateCommand = update;
		this.deleteCommand = delete;
		
	}
	
	@RequestMapping("/list")
	public String list(Model model) {
		System.out.println("list()");
		listCommand.execute(model);
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
//		command = new BWriteCommand();
		writeCommand.execute(model);
		
		return "redirect:list";
	}
	
	@RequestMapping("/content_view")
	public String Content(HttpServletRequest request,Model model) {
		System.out.println("content_view()");
		
		model.addAttribute("request", request);
		//command = new BContentCommand();
		contentCommand.execute(model);
		return "content_view";
	}
	
	@RequestMapping("delete")
	public String delete(HttpServletRequest request,Model model) {
		System.out.println("delete()");
		
		model.addAttribute("request", request);
//		command = new BDeleteCommand();
		deleteCommand.execute(model);
		return "redirect:list";
	}
	
	@RequestMapping("update")
	public String update(HttpServletRequest request,Model model) {
		System.out.println("update()");
		
		model.addAttribute("request", request);
		//command = new BUpdateCommand();
		updateCommand.execute(model);
		return "redirect:list";
	}
}
