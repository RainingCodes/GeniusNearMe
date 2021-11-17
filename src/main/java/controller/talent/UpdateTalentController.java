package controller.talent;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import controller.Controller;
import controller.user.UpdateMemberController;
import controller.user.UserSessionUtils;
import service.MemberService;
import service.MemberServiceImpl;
import service.PriceService;
import service.PriceServiceImpl;
import service.TalentService;
import service.TalentServiceImpl;
import service.dto.PriceDTO;
import service.dto.TalentDTO;

public class UpdateTalentController implements Controller {

	static final Logger log = LoggerFactory.getLogger(UpdateTalentController.class);
	
	 SimpleDateFormat format1 = new SimpleDateFormat ("yyyy-MM-dd");
	 long miliseconds = System.currentTimeMillis();

	
	public String execute(HttpServletRequest request, HttpServletResponse response) throws Exception {	
		Date writtenDate = null;
		if (request.getMethod().equals("GET")) {	
    		// GET request: 회원정보 수정 form 요청	
    		int talentId = Integer.parseInt(request.getParameter("talentId"));
    		int userId = Integer.parseInt(request.getParameter("userId"));
    		
    		MemberService member = new MemberServiceImpl();
    		String email = member.getEmailByUserId(userId);

    		log.debug("UpdateForm Request : {}", email);
    		
    		TalentService talentService = new TalentServiceImpl();
    		TalentDTO talent = talentService.findTalent(talentId);
			request.setAttribute("talent", talent);			
			writtenDate = talent.getWrittenDate();

			HttpSession session = request.getSession();
			if (UserSessionUtils.isLoginUser(email, session) ||
				UserSessionUtils.isLoginUser("admin", session)) {
				// 현재 로그인한 사용자가 수정 대상 사용자이거나 관리자인 경우 -> 수정 가능
				
				PriceService priceService = new PriceServiceImpl();
				List<PriceDTO> list = priceService.PriceList(talentId);
				request.setAttribute("priceList", list);
							
				return "/talent/updateForm.jsp"; 
			}    
			
			// else (수정 불가능한 경우) 게시글 보기 화면으로 오류 메세지를 전달
			request.setAttribute("updateFailed", true);
			request.setAttribute("exception", 
					new IllegalStateException("타인의 정보는 수정할 수 없습니다."));            
			return "/talent/view.jsp";	// 사용자 보기 화면으로 이동 (forwarding)
	    }	
		System.out.println("이제 시작");
    	
		//post
		Date start = format1.parse(request.getParameter("startDate"));
		Date deadline = format1.parse(request.getParameter("deadline"));
		System.out.println(start);
		System.out.println(deadline);
		
		HttpSession session = request.getSession();
		String email = UserSessionUtils.getLoginUserId(session);
		MemberService mem = new MemberServiceImpl();
		int userId = mem.getuserIdByEmail(email);
		
		TalentDTO dto = new TalentDTO(
				request.getParameter("title"),
				request.getParameter("content"),
				start,
				deadline,
				writtenDate,
				0,
				userId,
				request.getParameter("category"),
				Integer.parseInt(request.getParameter("postType")));//0=selling, 1=demanding
		System.out.println(dto);
		
		log.debug("Create Talent : {}", dto.getTitle());
		
//		try {
			System.out.println("재능 수정");
			TalentService talentService = new TalentServiceImpl();
			System.out.println("here");
			int talentId = talentService.updateTalent(dto);
			System.out.println(talentId+ "완료");
			
			
			PriceService priceService = new PriceServiceImpl();
			PriceDTO dto1 = new PriceDTO(talentId, 1, Integer.parseInt(request.getParameter("price")));
			int result = priceService.insertPrice(dto1);
			
			System.out.println(result);
			System.out.println("student값: "+request.getParameter("student"));
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
		
			request.setAttribute("talentId", talentId);
			String src = "/talent/view?talentId=" +talentId; 
			System.out.println(src);
			return src;
    	
	}
}
