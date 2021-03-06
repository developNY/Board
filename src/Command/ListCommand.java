package Command;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Dao.Dao;
import Dto.Dto;

public class ListCommand implements Command {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) {
		// TODO Auto-generated method stub
		
		Dao dao = new Dao();
		ArrayList<Dto> dtos = dao.list();
		
		request.setAttribute("list", dtos);	//view페이지가 필요한 부분은 이렇게 setAttribute하나봄. 
	}

}
