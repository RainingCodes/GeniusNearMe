package controller.talent;

import java.util.List;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import controller.Controller;
import service.dto.TalentDTO;
import service.TalentService;
import service.TalentServiceImpl;

public class SearchTalentListController implements Controller{

	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		TalentService manager = new TalentServiceImpl();
				
		String title = request.getParameter("title");
		List<TalentDTO> talentList = manager.getTalent(title);
		
		request.setAttribute("talentList", talentList);
		
		return "/talent/keywordSearch/list.jsp";
	}
	
}
