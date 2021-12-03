package controller.talent;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import controller.Controller;
import service.ReviewService;
import service.ReviewServiceImpl;
import service.dto.ReviewDTO;

public class ViewReviewController implements Controller{
	private static final Logger log = LoggerFactory.getLogger(ViewReviewController.class);

	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		int talentId = Integer.parseInt(request.getParameter("talentId"));
		
		ReviewService reviewService = new ReviewServiceImpl();
		List<ReviewDTO> reviewList = reviewService.getReviewListByTalent(talentId);
		
		request.setAttribute("reviewList", reviewList);
		request.setAttribute("talentId", talentId);
		
		String src = "/talent/view";
		System.out.println(src);
		
       return src;
	}
	
}
