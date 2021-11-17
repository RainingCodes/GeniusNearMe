package controller.matching;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import controller.Controller;

public class ChooseMatchingController implements Controller {
	 private static final Logger log = LoggerFactory.getLogger(ChooseMatchingController.class);
	
	public String execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		HttpSession session = request.getSession();
		
		int userId = (int) session.getAttribute("userId");
		
		 log.debug("Choose Matching - member : {}", userId);
		
		int talentId = Integer.parseInt(request.getParameter("talentId"));
		String matchingId = request.getParameter("matchingId");
		
		
		
		return "/talent/view.jsp";				// 사용자 보기 화면으로 이동
    }
	
}
