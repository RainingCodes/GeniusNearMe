package controller.user;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import controller.Controller;
import service.MemberService;
import service.MemberServiceImpl;
import service.WishService;
import service.WishServiceImpl;

public class DeleteWishController implements Controller{
	private static final Logger log = LoggerFactory.getLogger(DeleteWishController.class);

	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		// 로그인 여부 확인
    	if (!UserSessionUtils.hasLogined(request.getSession())) {
    		System.out.println("not Logined");
            return "redirect:/member/login/form";		// login form 요청으로 redirect
        }
    	
    	MemberService memberService = new MemberServiceImpl();
    	String email = UserSessionUtils.getLoginUserId(request.getSession());
		WishService wishService = new WishServiceImpl();
		
		log.debug("delete wish User : {}", email);
		
		int userId = memberService.getuserIdByEmail(email);
		System.out.println("talentId : "+request.getParameter("talentId"));
		int talentId = Integer.parseInt(request.getParameter("talentId"));
		
		int result = wishService.deleteWish(talentId, userId);
		System.out.println(result+"deleteWish: "+ email);
		return "redirect:/member/wishList";
	}
}
