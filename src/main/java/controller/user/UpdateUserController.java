package controller.user;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import controller.Controller;
import service.dto.MemberDTO;
import service.ExistingUserException;
import service.MemberService;
import service.MemberServiceImpl;

public class UpdateUserController implements Controller {
    private static final Logger log = LoggerFactory.getLogger(UpdateUserController.class);

    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response)	throws Exception {
    	
    	if (request.getMethod().equals("GET")) {	
    		// GET request: 회원정보 수정 form 요청	
    		// 원래는 UpdateUserFormController가 처리하던 작업을 여기서 수행
    		String updateEmail = request.getParameter("userEmail");

    		log.debug("UpdateForm Request : {}", updateEmail);
    		
    		MemberService manager = new MemberServiceImpl();
			MemberDTO member = manager.getMemberByEmail(updateEmail);
			request.setAttribute("member", member);			
			

			HttpSession session = request.getSession();
			if (UserSessionUtils.isLoginUser(updateEmail, session) ||
				UserSessionUtils.isLoginUser("admin", session)) {
				// 현재 로그인한 사용자가 수정 대상 사용자이거나 관리자인 경우 -> 수정 가능
				return "/user/updateForm.jsp";   // 검색한 사용자 정보를 update form으로 전송     
			}    
			
			// else (수정 불가능한 경우) 사용자 보기 화면으로 오류 메세지를 전달
			request.setAttribute("updateFailed", true);
			request.setAttribute("exception", 
					new IllegalStateException("수정 권한이 없습니다."));            
			return "/user/view.jsp";	// 사용자 보기 화면으로 이동 (forwarding)
	    }
    	
    	
    	// POST request (회원정보가 parameter로 전송됨)
    	
    	MemberDTO updateMember = new MemberDTO(
   	    	Integer.parseInt(request.getParameter("userId")),
   	    	request.getParameter("email"),
   	    	request.getParameter("password"),
   	    	request.getParameter("nickname"),
   	    	request.getParameter("phone")
   		);

    	
    	try {    		
    	    log.debug("Update User : {}", updateMember);
    	    	
    	    MemberService manager = new MemberServiceImpl();
    		manager.updateMember(updateMember);		
    		return "redirect:/user/view";
	        
		} catch (ExistingUserException e) {	// 예외 발생 시 수정 form으로 forwarding
            request.setAttribute("registerFailed", true);
			request.setAttribute("exception", e);
			request.setAttribute("member", updateMember);
			return "/user/updateForm.jsp";
		}
    	
    	
    		
    }
}
