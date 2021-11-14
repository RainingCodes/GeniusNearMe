package controller.user;


import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import controller.Controller;
import service.dto.MemberDTO;
import service.ExistingUserException;
import service.MemberService;
import service.MemberServiceImpl;

public class RegisterMemberController implements Controller {
    private static final Logger log = LoggerFactory.getLogger(RegisterMemberController.class);

    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
       	if (request.getMethod().equals("GET")) {	
    		// GET request: 회원정보 등록 form 요청	
    		log.debug("RegisterForm Request");		
			return "/user/registerForm.jsp";   // 검색한 사용자 정보를 update form으로 전송     	
	    }	

    	// POST request (회원정보가 parameter로 전송됨)
       	MemberDTO member = new MemberDTO(
			request.getParameter("email"),
			request.getParameter("password"),
			request.getParameter("nickname"),
			request.getParameter("phone"));
		
        log.debug("Create member : {}", member);

		try {
			MemberService manager = new MemberServiceImpl();
			manager.insertMember(member);
	        return "redirect:/user/view";	// 성공 시 사용자 상세 화면으로 redirect
	        
		} catch (ExistingUserException e) {	// 예외 발생 시 회원가입 form으로 forwarding
            request.setAttribute("registerFailed", true);
			request.setAttribute("exception", e);
			request.setAttribute("member", member);
			return "/user/registerForm.jsp";
		}
    }
}
