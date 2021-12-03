package controller.user;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import controller.Controller;
import service.MemberService;
import service.MemberServiceImpl;
import service.dto.MemberDTO;
import service.dto.MyMatchingDTO;

public class MyGroupMatchingListController implements Controller {
	private static final Logger log = LoggerFactory.getLogger(MyGroupMatchingListController.class);

	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		if (!UserSessionUtils.hasLogined(request.getSession())) {
    		System.out.println("not Logined");
            return "redirect:/member/login/form";		// login form 요청으로 redirect
        }
    	
    	
    	MemberService manager = new MemberServiceImpl();
		String email = UserSessionUtils.getLoginUserId(request.getSession());
		
		log.debug("apply my group matching User : {}", email);
		
		int userId = manager.getuserIdByEmail(email);
		List<MyMatchingDTO> myApplyMatchingInfo = null;
		List<MemberDTO> matchingWriterInfo = null; // 매칭글 작성자 info를 가져오기 위해 이렇게 짬
    	
    	try {
    		myApplyMatchingInfo =  manager.ListingApplyMyGroupMatchingByUserId(userId);	// 사용자 정보 검색
    		myApplyMatchingInfo.sort(Comparator.reverseOrder());
    		
    		matchingWriterInfo = new ArrayList<MemberDTO>();
    		
    		for (int i = 0; i < myApplyMatchingInfo.size(); i++) {
    			//탤런트Id로 writerId 불러오기
    			int writerId = manager.getWriterIdByTalentId(myApplyMatchingInfo.get(i).getTalentId());
        		
        		//유저Id 바탕으로 member Info 가져오기
    			MemberDTO m = manager.getMember(writerId);
    			matchingWriterInfo.add(m);
    		}
    		
    		
		} catch (SQLException e) {	
	        return "redirect:/member/login/form";
		}
    	
    	
    	log.debug("receive my group matching User : {}", email);
		
		List<MyMatchingDTO> myReceiveMatchingInfo = null;
		List<String> ReceiveUserNicekname = null;
    	
    	try {
    		myReceiveMatchingInfo =  manager.ListingReceiveMyGroupMatchingByUserId(userId);	// 사용자 정보 검색
    		myReceiveMatchingInfo.sort(Comparator.reverseOrder());
    		
    		ReceiveUserNicekname = new ArrayList<String>();
    		
    		for (int i = 0; i < myReceiveMatchingInfo.size(); i++) {
    			int mId = myReceiveMatchingInfo.get(i).getMatchingId();
    			
    			
    			//매칭 아이디 통해서 userId 구해오고, userNickname 구해오기 (와 진짜 미친 조인)
    			int mUserId = manager.getUserIdByMatchingId(mId);
    			String nickname = manager.getNicknameByUserId(mUserId);
    			
    			ReceiveUserNicekname.add(nickname);
    		}
    		
		} catch (SQLException e) {	
	        return "redirect:/member/login/form";
		}
    	
    	
    	//receive 받은
    	request.setAttribute("receiveList", myReceiveMatchingInfo);		// 사용자 정보 저장	
    	request.setAttribute("nickList", ReceiveUserNicekname);
    	
    	//apply 신청
    	request.setAttribute("applyList", myApplyMatchingInfo);		// 사용자 정보 저장	
    	request.setAttribute("matchingWriterInfo", matchingWriterInfo);
    	
		return "/member/groupMatching/viewGroupMatchingList.jsp";				// 사용자 보기 화면으로 이동
	}

}

