package controller.talent;


import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import controller.Controller;
import controller.user.UserSessionUtils;
import model.Wish;
import model.WishMapperRepository;
import service.MatchingService;
import service.MatchingServiceImpl;
import service.MemberService;
import service.MemberServiceImpl;
import service.PriceService;
import service.PriceServiceImpl;
import service.TalentService;
import service.TalentServiceImpl;
import service.WishService;
import service.WishServiceImpl;
import service.dto.MemberDTO;
import service.dto.PriceDTO;
import service.dto.TalentDTO;
import service.dto.WishDTO;

public class ViewTalentController implements Controller{
	 private static final Logger log = LoggerFactory.getLogger(ViewTalentController.class);
	 
	public String execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		//로그인 여부 확인
		if (!UserSessionUtils.hasLogined(request.getSession())) { //로그인 안되있을때
    		System.out.println("not Logined");
    		int talentId = Integer.parseInt(request.getParameter("talentId"));
    		TalentService talentService = new TalentServiceImpl();
    		TalentDTO talent = talentService.findTalent(talentId);
    		
    		MemberService mService = new MemberServiceImpl();
    		String nickName = mService.getNicknameByUserId(talent.getWriterId());
    		
    		PriceService pService = new PriceServiceImpl();
    		List<PriceDTO> price = pService.PriceList(talentId);
    			
    		request.setAttribute("talent", talent);		// 사용자 정보 저장
    		request.setAttribute("prices", price);
    		request.setAttribute("userId", -1);
    		request.setAttribute("nickName", nickName);
    		
    		return "/talent/view.jsp";				// 사용자 보기 화면으로 이동
        }
		
		//로그인 되있을때
		HttpSession session = request.getSession();
		MemberService mService = new MemberServiceImpl();
		MatchingService maService = new MatchingServiceImpl();
		
		log.debug("talent view"+ session);
		log.debug("email : {}",session.getAttribute("email"));
		String email = (String) session.getAttribute("email");
		MemberDTO member = mService.getMemberByEmail(email);
		int userId = member.getUserId();
		log.debug("UserId : {}", userId);
		
		
    	
		int talentId = Integer.parseInt(request.getParameter("talentId"));
		TalentService talentService = new TalentServiceImpl();
		TalentDTO talent = talentService.findTalent(talentId);
		
		
		
		PriceService pService = new PriceServiceImpl();
		List<PriceDTO> price = pService.PriceList(talentId);
		String nickName = mService.getNicknameByUserId(talent.getWriterId());
		
		boolean matchingCheck = maService.checkMatching(talentId, userId);
		boolean existWorkOnetoOneMatching = maService.existWorkOnetoOneMatchingByTalentId(userId, talentId);
		
		
		request.setAttribute("talent", talent);		// 사용자 정보 저장
		request.setAttribute("prices", price);
		request.setAttribute("userId", userId);
		request.setAttribute("nickName", nickName);
		request.setAttribute("matchingCheck", matchingCheck);
		request.setAttribute("infoOnetoOneMatching", existWorkOnetoOneMatching);
	
			
			
//			WishService wService = new WishServiceImpl();
//			WishDTO wish = wService.getWish(talentId, userId);
		Wish wish = new Wish();
		wish.setUserId(userId);
		wish.setTalentId(talentId);
		WishMapperRepository dao = new WishMapperRepository();
		Wish wished = dao.selectWish(wish);
		
			if(wished == null) {
				request.setAttribute("isAlreadyInWish", "no");
			}
			else {
				request.setAttribute("isAlreadyInWish","yes");
			}
			/*
			ReviewService reviewService = new ReviewServiceImpl();
			List<ReviewDTO> reviewList = reviewService.getReviewListByTalent(talentId);
			request.setAttribute("reviewList", reviewList);
				
			*/
			
			
			Date now = new Date();
			request.setAttribute("today", now);
			
			return "/talent/comment";
			//return "/talent/view.jsp";				// 사용자 보기 화면으로 이동
	    }

	}