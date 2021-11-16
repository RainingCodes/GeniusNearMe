package controller.talent;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import controller.Controller;

import service.PriceService;
import service.PriceServiceImpl;

import service.TalentService;
import service.TalentServiceImpl;

import service.dto.PriceDTO;
import service.dto.TalentDTO;

public class ViewTalentController implements Controller{
	public String execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		HttpSession session = request.getSession();
		int userId = (int) session.getAttribute("userId");
    	
		int talentId = Integer.parseInt(request.getParameter("talentId"));
		TalentService talentService = new TalentServiceImpl();
		TalentDTO talent = talentService.findTalent(talentId);
		
		PriceService pService = new PriceServiceImpl();
		List<PriceDTO> price = pService.PriceList(talentId);
			
		request.setAttribute("talent", talent);		// 사용자 정보 저장
		request.setAttribute("prices", price);
		request.setAttribute("userId", userId);
		return "/talent/view.jsp";				// 사용자 보기 화면으로 이동
    }

}
