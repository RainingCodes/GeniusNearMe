package controller.user;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import controller.Controller;
import service.UserNotFoundException;
import service.dto.MemberDTO;
import service.dto.MatchingDTO;
import service.MatchingServiceImpl;
import service.MemberService;
import service.MemberServiceImpl;

public class MyMatchingListController implements Controller {
    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) throws Exception {			
    	// 로그인 여부 확인
    	if (!UserSessionUtils.hasLogined(request.getSession())) {
    		System.out.println("not Logined");
            return "redirect:/member/login/form";		// login form 요청으로 redirect
        }
    	
    	MemberService manager = new MemberServiceImpl();
		String email = UserSessionUtils.getLoginUserId(request.getSession());
		
		System.out.println(email);

    	MatchingService mService = new MatchingServiceImpl();
    	List<MatchingDTO> matchingList = mService.MatchingList(userId);
    	request.setAttribute("matchingList", matchingList);
    	
    	try {
    		member = manager.findUserByEmail(email);	// 사용자 정보 검색
		} catch (UserNotFoundException e) {				
	        return "redirect:/member/login/form";
		}	
		
    	request.setAttribute("member", member);		// 사용자 정보 저장				
		return "/member/view.jsp";				// 사용자 보기 화면으로 이동
    }
}
