package controller.talent;

import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import controller.Controller;
import controller.user.UserSessionUtils;
import service.dto.TalentDTO;

public class RegisterTalentController implements Controller{
	 private static final Logger log = LoggerFactory.getLogger(RegisterTalentController.class);
	 
	 SimpleDateFormat format1 = new SimpleDateFormat ( "yyyy-MM-dd HH:mm:ss");
	 Date time = new Date();
	 String time1 = format1.format(time);
	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		
		if (!UserSessionUtils.hasLogined(request.getSession())) {
            return "redirect:/talent/register/form";		// login form 요청으로 redirect
        }
		// TODO Auto-generated method stub
		TalentDTO dto = new TalentDTO(
				request.getParameter("title"),
				request.getParameter("content"),
				request.getParameter("startDate"),
				request.getParameter("deadline"),
				time1, UserSessionUtils.getLoginUserId(session)
				request.getParameter("price"),
		return null;
	}

}
