package com.springlec.base0702.command;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.ui.Model;

import com.springlec.base0702.dao.BDao;
import com.springlec.base0702.dto.BDto;

public class BContentCommand implements BCommand {

	@Override
	public void execute(Model model) {
		// TODO Auto-generated method stub
		Map<String, Object> map = model.asMap();
		HttpServletRequest request = (HttpServletRequest)map.get("request");
		
		String Id = request.getParameter("bId");
		BDao dao = new BDao();
		BDto dto = dao.contentView(Id);
		request.setAttribute("content_view", dto);


	}

}
