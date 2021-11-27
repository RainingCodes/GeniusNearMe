package controller.user;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import controller.Controller;
import service.MemberService;
import service.MemberServiceImpl;
import service.TalentService;
import service.TalentServiceImpl;
import service.dto.TalentDTO;

public class MyTalentListController implements Controller{
	private static final Logger log = LoggerFactory.getLogger(MyTalentListController.class);
	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		// TODO Auto-generated method stub
		// 로그인 여부 확인
    	if (!UserSessionUtils.hasLogined(request.getSession())) {
    		System.out.println("not Logined");
            return "redirect:/member/login/form";		// login form 요청으로 redirect
        }
    	
    	MemberService manager = new MemberServiceImpl();
    	String email = UserSessionUtils.getLoginUserId(request.getSession());
		
		log.debug("my talent List User : {}", email);
		
		int userId = manager.getuserIdByEmail(email);
		
		TalentService talentservice = new TalentServiceImpl();
		List<TalentDTO> talentList = talentservice.getTalentByWriter(userId);
		
		request.setAttribute("talentList", talentList);
		
		return "/member/myTalentList.jsp";
	}

}
