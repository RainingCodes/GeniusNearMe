package controller.talent;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import controller.Controller;
import service.MemberService;
import service.MemberServiceImpl;
import service.ReviewService;
import service.ReviewServiceImpl;
import service.dto.ReviewDTO;

public class ViewReviewController implements Controller{
	private static final Logger log = LoggerFactory.getLogger(ViewReviewController.class);

	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		int talentId = Integer.parseInt(request.getParameter("talentId"));
		List<String> nick = new ArrayList<>();
		
		ReviewService reviewService = new ReviewServiceImpl();
		MemberService manager = new MemberServiceImpl();
		List<ReviewDTO> reviewList = reviewService.getReviewListByTalent(talentId);
		
		for(int i =0; i < reviewList.size(); i++) {
			int writerId = reviewList.get(i).getWriterId();
			
			String n = manager.getNicknameByUserId(writerId);
			nick.add(n);
			
		}
		
		request.setAttribute("reviewList", reviewList);
		request.setAttribute("talentId", talentId);
		request.setAttribute("nick", nick);
		
		String src = "/talent/view.jsp"; 
		System.out.println(src);
		
       return src;
	}
	
}
