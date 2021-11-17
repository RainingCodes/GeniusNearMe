package controller.user;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import controller.Controller;

public class LogoutController implements Controller {
	private static final Logger log = LoggerFactory.getLogger(LogoutController.class);
    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		//세션에 저장된 사용자 이이디를 삭제하고 세션을 무효화 함 
		HttpSession session = request.getSession();
		session.removeAttribute(UserSessionUtils.USER_SESSION_KEY);
		session.invalidate();		
        
        return "redirect:/main";
    }
}
