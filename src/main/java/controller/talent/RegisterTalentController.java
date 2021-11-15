package controller.talent;

import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.Date;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import controller.Controller;
import controller.user.UserSessionUtils;
import service.ExistingUserException;
import service.TalentService;
import service.TalentServiceImpl;
import service.dto.TalentDTO;

public class RegisterTalentController implements Controller{
	private static final Logger log = LoggerFactory.getLogger(RegisterTalentController.class);

	 SimpleDateFormat format1 = new SimpleDateFormat ("yyyy-MM-dd");
	 long miliseconds = System.currentTimeMillis();
     Date date = new Date(miliseconds);
     
	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		// TODO Auto-generated method stub
		if (!UserSessionUtils.hasLogined(request.getSession())) {
            return "redirect:/member/login/form";	
        }
		Date start = format1.parse(request.getParameter("startDate"));
		Date deadline = format1.parse(request.getParameter("deadline"));
		
		TalentDTO dto = new TalentDTO(
				request.getParameter("title"),
				request.getParameter("content"),
				start,
				deadline,
				date,
				0,
				Integer.parseInt(request.getParameter("userId")),
				request.getParameter("category"),
				Integer.parseInt(request.getParameter("postType")),
				Integer.parseInt(request.getParameter("price")));
		System.out.println(dto);
		
		log.debug("Create Talent : {}", dto.getTitle());
		
		try {
			System.out.println("재능 추가");
			TalentService talentService = new TalentServiceImpl();
			int i = talentService.insertTalent(dto);
			System.out.println(i+ "완료");
		
			return "redirect:/talent/view";
		}catch(SQLException e) {
			return "/talent/registerForm.jsp";
		}
	}

}
