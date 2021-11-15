package controller.talent;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import controller.Controller;
import controller.user.UserSessionUtils;
import service.TalentService;
import service.TalentServiceImpl;
import service.dto.TalentDTO;

public class ViewTalentController implements Controller{
	public String execute(HttpServletRequest request, HttpServletResponse response) throws Exception {			
    	
		int talentId = Integer.parseInt(request.getParameter("talentId"));
		TalentService talentService = new TalentServiceImpl();
		TalentDTO talent = talentService.findTalent(talentId);
			
		request.setAttribute("talent", talent);		// 사용자 정보 저장				
		return "/talent/view.jsp";				// 사용자 보기 화면으로 이동
    }

}
