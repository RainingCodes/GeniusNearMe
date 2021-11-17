package controller.matching;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import controller.Controller;
import service.MatchingService;
import service.MatchingServiceImpl;
import service.dto.MatchingDTO;

public class ApplicationMatchingController implements Controller {
	private static final Logger log = LoggerFactory.getLogger(ApplicationMatchingController.class);
	
	public String execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		
		int applicationId = Integer.parseInt(request.getParameter("userId"));
		log.debug("Application Matching - member : {}", applicationId);
		
		int talentId = Integer.parseInt(request.getParameter("talentId"));
		int writerId = Integer.parseInt(request.getParameter("writerId"));
		
		if (applicationId == writerId) {
			System.out.println("멤버 추가 실패");
            request.setAttribute("registerFailed", true);
			request.setAttribute("exception", e);
			request.setAttribute("member", member);
			
			String src = "/talent/view?talentId=" +talentId; 
			System.out.println(src);
			return src;
		}
		
		MatchingService mService = new MatchingServiceImpl();
		int result = -1;
		
		
		MatchingDTO mDTO = new MatchingDTO(-1, 0, talentId, -1, applicationId);
		result = mService.insertMatching(mDTO);
		System.out.println("결과"+result);
		
		return "/member/ApplyMatching";		//매칭 신청 화면으로 이동
    }
	
}
