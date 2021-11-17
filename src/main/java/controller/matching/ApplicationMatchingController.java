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
		MatchingService mService = new MatchingServiceImpl();
		
		
		//talentId, applicationId, matchingState==0 인 값이 있으면 추가 안되게 나중에 수정해야함
		
		MatchingDTO mDTO = new MatchingDTO(-1, 0, talentId, -1, applicationId);
		int result = mService.insertMatching(mDTO);
		System.out.println("결과"+result);
		
		return "/member/ApplyMatching";		//매칭 신청 화면으로 이동
    }
	
}
