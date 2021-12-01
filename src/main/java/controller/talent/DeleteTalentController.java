package controller.talent;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import controller.Controller;
import service.TalentService;
import service.TalentServiceImpl;

public class DeleteTalentController implements Controller {

	private static final Logger log = LoggerFactory.getLogger(DeleteTalentController.class);

	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		
		int talentId = Integer.parseInt(request.getParameter("talentId"));
		log.debug("Delete Talent : {}", talentId);
		
		TalentService talentService = new TalentServiceImpl();
		int result = talentService.deleteTalent(talentId);
		
		System.out.println("삭제 결과 : " + result);
		
		return "/member/myTalentList";
	}

}
