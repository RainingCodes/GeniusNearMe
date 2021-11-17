package controller.user;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import controller.Controller;
import service.dto.MyMatchingDTO;
import service.MemberService;
import service.MemberServiceImpl;

public class ReceiveMyMatchingListController implements Controller {
	private static final Logger log = LoggerFactory.getLogger(ReceiveMyMatchingListController.class);
	
    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) throws Exception {			
    	// 로그인 여부 확인
    	if (!UserSessionUtils.hasLogined(request.getSession())) {
    		System.out.println("not Logined");
            return "redirect:/member/login/form";		// login form 요청으로 redirect
        }
    	
    	MemberService manager = new MemberServiceImpl();
		String email = UserSessionUtils.getLoginUserId(request.getSession());
		
		log.debug("receive my matching User : {}", email);
		
		int userId = manager.getuserIdByEmail(email);
		List<MyMatchingDTO> myMatchingInfo = null;
		List<String> userNicekname = null;
    	
    	try {
    		myMatchingInfo =  manager.ListingReceiveMyMatchingByUserId(userId);	// 사용자 정보 검색
    		userNicekname = new ArrayList<String>();
    		
    		for (int i = 0; i < myMatchingInfo.size(); i++) {
    			int mId = myMatchingInfo.get(i).getMatchingId();
    			
    			
    			//매칭 아이디 통해서 userId 구해오고, userNickname 구해오기 (와 진짜 미친 조인)
    			int mUserId = manager.getUserIdByMatchingId(mId);
    			String nickname = manager.getNicknameByUserId(mUserId);
    			
    			userNicekname.add(nickname);
    		}
    		
		} catch (SQLException e) {	
	        return "redirect:/member/login/form";
		}
    	
    	
    	request.setAttribute("list", myMatchingInfo);		// 사용자 정보 저장	
    	request.setAttribute("nickList", userNicekname);
		return "/member/receiveMatchingList.jsp";				// 사용자 보기 화면으로 이동
    }
}
