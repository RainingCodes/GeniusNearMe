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
			return "/member/registerForm.jsp";   // 검색한 사용자 정보를 update form으로 전송     	
	    }	

    	// POST request (회원정보가 parameter로 전송됨)
       	MemberDTO member = new MemberDTO(
			request.getParameter("email"),
			request.getParameter("password"),
			request.getParameter("nickname"),
			request.getParameter("phone"));
       	System.out.println(member);
		
        log.debug("Create member : {}", member.getEmail());

		try {
			System.out.println("멤버 추가");
			MemberService manager = new MemberServiceImpl();
			int i = manager.insertMember(member);
			System.out.println(i+"완료");
			
			request.setAttribute("email", member.getEmail());
			request.setAttribute("password", member.getPw());
	        return "redirect:/member/login";	// 성공 시 로그인으로 연결
	        
		} catch (ExistingUserException e) {	// 예외 발생 시 회원가입 form으로 forwarding
			System.out.println("멤버 추가 실패");
            request.setAttribute("registerFailed", true);
			request.setAttribute("exception", e);
			request.setAttribute("member", member);
			return "/member/registerForm.jsp";
		}
    }
}
