package controller.user;

import java.sql.SQLException;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import controller.Controller;
import service.dto.MyMatchingDTO;
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
		
		int userId = manager.getuserIdByEmail(email);
		System.out.println("유저id : " + userId);

		List<MyMatchingDTO> myMatchingInfo = null;
    	
    	try {
    		myMatchingInfo =  manager.ListingMyMatchingByUserId(userId);	// 사용자 정보 검색
    		System.out.println("리턴사이즈 : "+ myMatchingInfo.size());
		} catch (SQLException e) {	
	        return "redirect:/member/login/form";
		}
   		
    	request.setAttribute("myMatchingInfo", myMatchingInfo);		// 사용자 정보 저장				
		return "/member/myMatchingList.jsp";				// 사용자 보기 화면으로 이동
    }
}
