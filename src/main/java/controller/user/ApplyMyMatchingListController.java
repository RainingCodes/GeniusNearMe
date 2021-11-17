package controller.user;

import java.sql.SQLException;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import controller.Controller;
import service.dto.MyMatchingDTO;
import service.MemberService;
import service.MemberServiceImpl;

public class ApplyMyMatchingListController implements Controller {
	private static final Logger log = LoggerFactory.getLogger(ApplyMyMatchingListController.class);
	
    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) throws Exception {			
    	// 로그인 여부 확인
    	if (!UserSessionUtils.hasLogined(request.getSession())) {
    		System.out.println("not Logined");
            return "redirect:/member/login/form";		// login form 요청으로 redirect
        }
    	
    	
    	MemberService manager = new MemberServiceImpl();
		String email = UserSessionUtils.getLoginUserId(request.getSession());
		
		log.debug("apply my matching User : {}", email);
		
		int userId = manager.getuserIdByEmail(email);
		List<MyMatchingDTO> myMatchingInfo = null;
    	
    	try {
    		myMatchingInfo =  manager.ListingMyMatchingByUserId(userId);	// 사용자 정보 검색
		} catch (SQLException e) {	
	        return "redirect:/member/login/form";
		}
   		
    	request.setAttribute("list", myMatchingInfo);		// 사용자 정보 저장				
		return "/member/applyMatchingList.jsp";				// 사용자 보기 화면으로 이동
    }
}
