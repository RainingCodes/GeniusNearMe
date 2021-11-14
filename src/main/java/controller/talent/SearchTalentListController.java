package controller.talent;

import java.util.List;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import controller.Controller;
import service.dto.TalentDTO;
import service.TalentNotFoundException;
import service.TalentService;
import service.TalentServiceImpl;

public class SearchTalentListController implements Controller{

	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		TalentService manager = new TalentServiceImpl();
		String title = request.getParameter("title");
		
		List<TalentDTO> talent = null;
		try {
			talent = manager.getTalent(title);
		}catch(TalentNotFoundException e) {
			return "redirect:/talent/list";
		}
		request.setAttribute(title, talent);
		return "/talent/view.jsp";
	}
	
}
