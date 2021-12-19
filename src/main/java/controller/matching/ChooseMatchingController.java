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
		int groupId = Integer.parseInt(request.getParameter("groupId"));
		String option = request.getParameter("state");
		String group = request.getParameter("group");
		
		MatchingService mService = new MatchingServiceImpl();
		int result = -1;
		if(group != null) {
			if (option.equals("decideMatching")) {
				result = mService.decideGroupMatching(groupId);
			} else if (option.equals("denyMatching")) {
				result = mService.denyGroupMatching(groupId);
			}
		}
		
		if (option.equals("decideMatching")) {
			result = mService.decideMatching(matchingId);
		} else if (option.equals("denyMatching")) {
			result = mService.denyMatching(matchingId);
		}
		
		System.out.println("결과"+result);
		
		if(group != null)
			return "/member/GroupMatching";
		
		return "/member/OneMatching";				// 사용자 보기 화면으로 이동
    }
	
}
