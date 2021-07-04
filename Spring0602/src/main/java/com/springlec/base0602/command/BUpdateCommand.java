package com.springlec.base0602.command;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;

import com.springlec.base0602.dao.BDao;
import com.springlec.base0602.dto.BDto;

public class BUpdateCommand implements BCommand {
	private BDao dao = null;
	
	@Autowired
	public void auto(BDao dao) {
		this.dao = dao;
	}
	@Override
	public void execute(Model model) {
		// TODO Auto-generated method stub
		Map<String, Object> map = model.asMap();
		HttpServletRequest request = (HttpServletRequest)map.get("request");
		
		String bId = request.getParameter("bId");
		String bName = request.getParameter("bName");
		String bTitle = request.getParameter("bTitle");
		String bContent =request.getParameter("bContent");
		
		//BDao dao = new BDao();
		dao.update(bId, bName, bTitle, bContent);

		
	}

}
