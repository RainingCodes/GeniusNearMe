package controller.user;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import controller.Controller;
import service.MemberService;
import service.MemberServiceImpl;
import service.TalentService;
import service.TalentServiceImpl;
import service.WishService;
import service.WishServiceImpl;
import service.dto.WishDTO;

public class WishListController implements Controller{
	private static final Logger log = LoggerFactory.getLogger(WishListController.class);
	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response) throws Exception {

		// 로그인 여부 확인
    	if (!UserSessionUtils.hasLogined(request.getSession())) {
    		System.out.println("not Logined");
            return "redirect:/member/login/form";		// login form 요청으로 redirect
        }
    	
    	MemberService manager = new MemberServiceImpl();
    	String email = UserSessionUtils.getLoginUserId(request.getSession());
		
		log.debug("wish List User : {}", email);
		
		int userId = manager.getuserIdByEmail(email);
		
		TalentService talentservice = new TalentServiceImpl();
		int talentId = Integer.parseInt(request.getParameter("talentId"));
		
		WishDTO wish = new WishDTO(talentId, userId);
		
		System.out.println(wish);
		
		WishService manager = new WishServiceImpl();
		
		
		return "/member/wishList.jsp";
	}

}
