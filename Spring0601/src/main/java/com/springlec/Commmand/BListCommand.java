package com.springlec.Commmand;

import java.util.ArrayList;

import org.springframework.ui.Model;

import com.springlec.Dao.BDao;
import com.springlec.Dto.BDto;

public class BListCommand implements BCommand {

	@Override
	public void execute(Model model) {
		// TODO Auto-generated method stub
			BDao dao = new BDao();
			ArrayList<BDto> dtos = dao.list();
			model.addAttribute("list",dtos);
		

	}

}
