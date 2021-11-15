package controller.user;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import controller.Controller;
import service.dto.MemberDTO;
import service.MemberService;
import service.MemberServiceImpl;

public class DeleteMemberController implements Controller {
    private static final Logger log = LoggerFactory.getLogger(DeleteMemberController.class);

    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response)	throws Exception {
		String deleteEmail = request.getParameter("userEmail");
    	log.debug("Delete User : {}", deleteEmail);
    	
    	MemberService manager = new MemberServiceImpl();
				
		HttpSession session = request.getSession();	
	
		if ((UserSessionUtils.isLoginUser("admin", session) && 	// 로그인한 사용자가 관리자이고 	
			 !deleteEmail.equals("admin"))							// 삭제 대상이 일반 사용자인 경우, 
			   || 												// 또는 
			(!UserSessionUtils.isLoginUser("admin", session) &&  // 로그인한 사용자가 관리자가 아니고 
			  UserSessionUtils.isLoginUser(deleteEmail, session))) { // 로그인한 사용자가 삭제 대상인 경우 (자기 자신을 삭제)
			
			manager.deleteMember(manager.getuserIdByEmail(deleteEmail)); // 사용자 정보 삭제
			if (UserSessionUtils.isLoginUser("admin", session))	// 로그인한 사용자가 관리자 	
				return "redirect:/main";		// 사용자 리스트로 이동
			else 									// 로그인한 사용자는 이미 삭제됨
				return "redirect:/member/logout";		// logout 처리
		}
		
		/* 삭제가 불가능한 경우 */
		MemberDTO member = manager.getMemberByEmail(deleteEmail);	// 사용자 정보 검색
		request.setAttribute("member", member);						
		request.setAttribute("deleteFailed", true);
		String msg = (UserSessionUtils.isLoginUser("admin", session)) 
				   ? "시스템 관리자 정보는 삭제할 수 없습니다."		
				   : "타인의 정보는 삭제할 수 없습니다.";													
		request.setAttribute("exception", new IllegalStateException(msg));            
		return "/member/view.jsp";		// 사용자 보기 화면으로 이동 (forwarding)	
	}
}
