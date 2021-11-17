package controller.matching;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import controller.Controller;
import service.MatchingService;
import service.MatchingServiceImpl;

public class ChooseMatchingController implements Controller {
	private static final Logger log = LoggerFactory.getLogger(ChooseMatchingController.class);
	
	public String execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		HttpSession session = request.getSession();
		
		int userId = (int) session.getAttribute("userId");
		
		log.debug("Choose Matching - member : {}", userId);
		
		//int talentId = Integer.parseInt(request.getParameter("talentId"));
		int matchingId = Integer.parseInt(request.getParameter("matchingId"));
		String option = request.getParameter("state");
		
		MatchingService mService = new MatchingServiceImpl();
		int result = -1;
		
		if (option.equals("decideMatching")) {
			result = mService.decideMatching(matchingId);
		} else if (option.equals("denyMatching")) {
			result = mService.denyMatching(matchingId);
		}
		
		System.out.println("결과"+result);
		
		
		return "/member/ReceiveMatching";				// 사용자 보기 화면으로 이동
    }
	
}
