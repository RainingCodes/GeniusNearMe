package controller.talent;

import java.sql.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import controller.Controller;
import service.TalentService;
import service.TalentServiceImpl;
import service.dto.TalentDTO;

public class DetailedSearchController implements Controller{

	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		
		// 옵션들
		int price = Integer.parseInt(request.getParameter("price"));
		Date startDate = Date.valueOf(request.getParameter("startDate"));
		Date deadLine = Date.valueOf(request.getParameter("deadLine"));
		String[] categories = request.getParameterValues("category");
		
		TalentService manager = new TalentServiceImpl();
		List<TalentDTO> talentList = manager.getTalentByOptions(categories, price, startDate, deadLine);
		
		request.setAttribute("talentList", talentList);
		
		return "/talent/detailedSearch/list";
	}
	
	
}