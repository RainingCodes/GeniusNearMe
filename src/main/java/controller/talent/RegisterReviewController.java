package controller.talent;

import java.util.Date;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import controller.Controller;
import controller.user.UserSessionUtils;
import service.MemberService;
import service.MemberServiceImpl;
import service.ReviewService;
import service.ReviewServiceImpl;
import service.dto.ReviewDTO;

public class RegisterReviewController implements Controller{
	private static final Logger log = LoggerFactory.getLogger(RegisterReviewController.class);
	
	long miliseconds = System.currentTimeMillis();
    Date current = new Date(miliseconds);
    String src = null;
    
	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		int talentId = Integer.parseInt(request.getParameter("talentId"));
		
		String email = UserSessionUtils.getLoginUserId(request.getSession());
		MemberService memberService = new MemberServiceImpl();
		int userId = memberService.getuserIdByEmail(email);
		
		ReviewDTO review = new ReviewDTO(
				current,
				0,
				userId,
				talentId,
				request.getParameter("content")
		);
		
		log.debug("RegisterReviewController Request : {}", review);
		
		ReviewService service = new ReviewServiceImpl();
		int key = service.insertReview(review);
		
		System.out.println("리뷰 생성 키: "+ key);
		request.setAttribute("talentId", talentId);
		
		src = "/talent/view.jsp"; 
		
		return src;
	}

}
