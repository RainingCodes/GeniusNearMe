package controller.talent;

import java.util.List;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import controller.Controller;
import service.dto.TalentDTO;
import service.TalentService;
import service.TalentServiceImpl;

public class KeywordSearchController implements Controller{ 
	
	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response) throws Exception {		

		String search_bar = request.getParameter("search_bar");
		int search_options = Integer.parseInt(request.getParameter("search_options"));
		
		TalentService manager = new TalentServiceImpl();
		
		List<TalentDTO> talentList;
		switch(search_options) {
		case 0:
			talentList = manager.getTalent(search_bar);
			request.setAttribute("talentList", talentList);			
			break;
		case 1:
			talentList = manager.getTalentListByNickname(search_bar);
			request.setAttribute("talentList", talentList);
			break;
		}
		
		request.setAttribute("search_bar", search_bar);	
		
		System.out.println("선택한 옵션: "+search_options);
		
		return "/talent/keywordSearch/list.jsp";
	}
	
}
