package controller.talent;

import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.Date;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import controller.Controller;
import controller.user.UserSessionUtils;
import service.ExistingTalentException;
import service.ExistingUserException;
import service.MemberService;
import service.MemberServiceImpl;
import service.PriceService;
import service.PriceServiceImpl;
import service.TalentService;
import service.TalentServiceImpl;
import service.dto.PriceDTO;
import service.dto.TalentDTO;

public class RegisterTalentController implements Controller{
	private static final Logger log = LoggerFactory.getLogger(RegisterTalentController.class);

	 SimpleDateFormat format1 = new SimpleDateFormat ("yyyy-MM-dd");
	 long miliseconds = System.currentTimeMillis();
     Date current = new Date(miliseconds);
     
	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		// TODO Auto-generated method stub
		if (!UserSessionUtils.hasLogined(request.getSession())) {
            return "redirect:/member/login/form";	
        }
		Date start = format1.parse(request.getParameter("startDate"));
		Date deadline = format1.parse(request.getParameter("deadline"));
		System.out.println(start);
		System.out.println(deadline);
		System.out.println(current);
		
		HttpSession session = request.getSession();
		String email = UserSessionUtils.getLoginUserId(session);
		MemberService mem = new MemberServiceImpl();
		int userId = mem.getuserIdByEmail(email);
		
		System.out.println("유저아이디: "+userId);
		System.out.println(request.getParameter("category"));
		System.out.println(request.getParameter("postType"));		
		
		TalentDTO dto = new TalentDTO(
				request.getParameter("title"),
				request.getParameter("content"),
				start,
				deadline,
				current,
				0,
				userId,
				request.getParameter("category"),
				Integer.parseInt(request.getParameter("postType")));//0=selling, 1=demanding
		System.out.println(dto);
		
		log.debug("Create Talent : {}", dto.getTitle());
		
//		try {
			System.out.println("재능 추가");
			TalentService talentService = new TalentServiceImpl();
			System.out.println("here");
			int talentId = talentService.insertTalent(dto);
			System.out.println(talentId+ "완료");
			
			
			PriceService priceService = new PriceServiceImpl();
			PriceDTO dto1 = new PriceDTO(talentId, 1, Integer.parseInt(request.getParameter("price")));
			int result = priceService.insertPrice(dto1);
			
			System.out.println(result);
			int num = Integer.parseInt(request.getParameter("student"));
			for(int i = 1; i <= num; i++) {
				PriceDTO dto2 = new PriceDTO(
						talentId,
						Integer.parseInt(request.getParameter("num"+i)),
						Integer.parseInt(request.getParameter("price"+i))
						);
				result = priceService.insertPrice(dto2);
				System.out.println(result);
			}
		
			return "redirect:/talent/view?talentId=";
//		}catch(ExistingTalentException e) {
//			System.out.println("재능 추가 실패");
//            request.setAttribute("registerFailed", true);
//			request.setAttribute("exception", e);
//			request.setAttribute("talent", dto);
//			return "/talent/registerForm.jsp";
//		}
			
			
			
			
	}

}
