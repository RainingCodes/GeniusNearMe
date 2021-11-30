package controller.message;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import controller.Controller;
import controller.user.UserSessionUtils;
import service.ExistingUserException;
import service.MessageService;
import service.MessageServiceImpl;
import service.dto.MessageDTO;

public class SendMessageController implements Controller {
	private static final Logger log = LoggerFactory.getLogger(SendMessageController.class);

	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		
		// GET request : 쪽지 form 요청	
		if (request.getMethod().equals("GET")) {	
    		
    		String senderId = request.getParameter("senderId");
    		String receiverId = request.getParameter("receiverId");

    		log.debug("Send Message Get Request : {}", senderId, receiverId);
    		    		
    		request.setAttribute("updateFailed", true);
			request.setAttribute("exception", 
					new IllegalStateException("수정 권한이 없습니다."));            
			return "/member/view.jsp";	// 사용자 보기 화면으로 이동 (forwarding)
	    }
    	
    	// POST request (회원정보가 parameter로 전송됨)
    	MemberDTO updateMember = new MemberDTO(
   	    	Integer.parseInt(request.getParameter("userId")),
   	    	request.getParameter("email"),
   	    	request.getParameter("password"),
   	    	request.getParameter("nickname"),
   	    	request.getParameter("phone")
   		);
    	
    	HttpSession session = request.getSession();
    	session.setAttribute("nickname", updateMember.getNickname());
    	session.setAttribute("userId", updateMember.getUserId());
    	System.out.println(updateMember);

    	
    	try {    		
    	    log.debug("Update User : {}", updateMember.getEmail());
    	    	
    	    MemberService manager = new MemberServiceImpl();
    		int i = manager.updateMember(updateMember);		
    		System.out.println("수정결과:"+i);
    		return "redirect:/member/view";
	        
		} catch (ExistingUserException e) {	// 예외 발생 시 수정 form으로 forwarding
			
			System.out.println("수정불가");
            request.setAttribute("updateFailed", true);
			request.setAttribute("exception", e);
			request.setAttribute("member", updateMember);
			return "/member/updateForm.jsp";
		}
	}

}
