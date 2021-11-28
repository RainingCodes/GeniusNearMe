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
import service.MemberService;
import service.MemberServiceImpl;
import service.PriceService;
import service.PriceServiceImpl;

import service.TalentService;
import service.TalentServiceImpl;
import service.dto.MemberDTO;
import service.dto.PriceDTO;
import service.dto.TalentDTO;

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
		
		log.debug("talent view"+ session);
		log.debug("email : {}",session.getAttribute("email"));
		String email = (String) session.getAttribute("email");
		MemberDTO member = mService.getMemberByEmail(email);
		int userId = member.getUserId();
		log.debug("UserId : {}", userId);

    	
		int talentId = Integer.parseInt(request.getParameter("talentId"));
		TalentService talentService = new TalentServiceImpl();
		TalentDTO talent = talentService.findTalent(talentId);
		
		
		String nickName = mService.getNicknameByUserId(talent.getWriterId());
		
		PriceService pService = new PriceServiceImpl();
		List<PriceDTO> price = pService.PriceList(talentId);
			
		request.setAttribute("talent", talent);		// 사용자 정보 저장
		request.setAttribute("prices", price);
		request.setAttribute("userId", userId);
		request.setAttribute("nickName", nickName);
		
		Date now = new Date();
		request.setAttribute("today", now);
		
		return "/talent/comment";
//		return "/talent/view.jsp";				// 사용자 보기 화면으로 이동
    }

}
