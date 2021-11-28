package controller.talent;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import controller.Controller;
import service.TalentService;
import service.TalentServiceImpl;
import service.dto.TalentDTO;

public class DetailedSearchController implements Controller{

	SimpleDateFormat format1 = new SimpleDateFormat ("yyyy-MM-dd");
	
	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		
		String search_bar = request.getParameter("search_bar");
		// 옵션들
		String reSearch = request.getParameter("reSearch");
		int price = Integer.parseInt(request.getParameter("price"));
		
		Date startDate = null;
		Date deadLine = null;
		String strStartDate = request.getParameter("startDate");
		String strDeadLine = request.getParameter("deadLine");
		if (strStartDate == null) {
			startDate = format1.parse("2000-01-01");
		}
		if (strDeadLine == null) {
			deadLine = format1.parse("2030-12-31");
		}
		
		String[] categories = request.getParameterValues("category");
		
		TalentService manager = new TalentServiceImpl();
		List<TalentDTO> talentList = manager.getTalentByOptions(search_bar, reSearch, categories, price, startDate, deadLine);
		
		request.setAttribute("talentList", talentList);
		request.setAttribute("search_bar", search_bar);
		
		return "/talent/detailedSearch/list.jsp";
	}
	
	
}