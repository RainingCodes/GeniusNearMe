package controller.user;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import controller.Controller;
import service.UserNotFoundException;
import service.dto.MemberDTO;
import service.MemberService;
import service.MemberServiceImpl;

public class ViewMemberController implements Controller {
    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) throws Exception {			
    	// 로그인 여부 확인
    	if (!UserSessionUtils.hasLogined(request.getSession())) {
            return "redirect:/member/login/form";		// login form 요청으로 redirect
        }
    	
    	MemberService manager = new MemberServiceImpl();
		String userId = request.getParameter("userId");

    	MemberDTO member = null;
    	
    	try {
    		member = manager.findUserByEmail(userId);	// 사용자 정보 검색
		} catch (UserNotFoundException e) {				
	        return "redirect:/member/list";
		}	
		
    	request.setAttribute("member", member);		// 사용자 정보 저장				
		return "/member/view.jsp";				// 사용자 보기 화면으로 이동
    }
}
