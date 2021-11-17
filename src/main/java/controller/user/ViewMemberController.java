package controller.user;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import controller.Controller;
import service.UserNotFoundException;
import service.dto.MemberDTO;
import service.MemberService;
import service.MemberServiceImpl;

public class ViewMemberController implements Controller {
	private static final Logger log = LoggerFactory.getLogger(ViewMemberController.class);
	
    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) throws Exception {		
    	// 로그인 여부 확인
    	if (!UserSessionUtils.hasLogined(request.getSession())) {
    		System.out.println("not Logined");
            return "redirect:/member/login/form";		// login form 요청으로 redirect
        }
    	
    	MemberService manager = new MemberServiceImpl();
		String email = UserSessionUtils.getLoginUserId(request.getSession());
		
		log.debug("view User : {}", email);
		
    	MemberDTO member = null;
    	
    	try {
    		member = manager.findUserByEmail(email);	// 사용자 정보 검색
		} catch (UserNotFoundException e) {				
	        return "redirect:/member/login/form";
		}	
		
    	request.setAttribute("member", member);		// 사용자 정보 저장				
		return "/member/view.jsp";				// 사용자 보기 화면으로 이동
    }
}
