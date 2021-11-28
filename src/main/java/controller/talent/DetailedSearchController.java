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

	SimpleDateFormat format1 = new SimpleDateFormat("yyyy-MM-dd");
	
	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		
		String search_bar = request.getParameter("search_bar");
		System.out.println("검색창 전달됐는지 확인 => "+ search_bar);
		
		// 옵션들
		String reSearch = request.getParameter("reSearch");
		int price = Integer.parseInt(request.getParameter("price"));
		
	
		String strStartDate = request.getParameter("startDate"); //시작일, 마감일을 문자열로 전달받음
		String strDeadLine = request.getParameter("deadLine");
		
		Date startDate, deadLine;
		if (strStartDate == null) { // 날짜 상세 설정이 없을 경우
			startDate = format1.parse("2000-01-01");
		}
		else {
			startDate = format1.parse(strStartDate); // Date형으로 변환
		}
		
		if (strDeadLine == null) {
			deadLine = format1.parse("2030-12-31");		
		}
		else {			
			deadLine = format1.parse(strDeadLine);
		}
		
		String[] categories = request.getParameterValues("category");
		
		System.out.println("research 전달됐는지 확인 => "+ reSearch);
		System.out.println("가격 전달됐는지 확인 => "+ price);
		System.out.println("시작일 전달됐는지 확인 => "+ startDate);
		System.out.println("마감일 전달됐는지 확인 => "+ deadLine);
		System.out.println("카테고리 전달됐는지 확인 => "+ categories.length);
		
		TalentService manager = new TalentServiceImpl();
		List<TalentDTO> talentList = manager.getTalentByOptions(search_bar, reSearch, categories, price, startDate, deadLine);
		
		request.setAttribute("talentList", talentList);
		request.setAttribute("search_bar", search_bar);
		
		return "/talent/detailedSearch/list.jsp";
	}
	
	
}