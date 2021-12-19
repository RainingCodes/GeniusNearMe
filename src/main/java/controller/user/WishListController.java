package controller.user;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import controller.Controller;
import model.Wish;
import model.WishMapperRepository;
import service.MemberService;
import service.MemberServiceImpl;
import service.TalentService;
import service.TalentServiceImpl;
import service.WishService;
import service.WishServiceImpl;
import service.dto.TalentDTO;
import service.dto.WishDTO;

public class WishListController implements Controller{
	private static final Logger log = LoggerFactory.getLogger(WishListController.class);
	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response) throws Exception {

		
		// 로그인 여부 확인
    	if (!UserSessionUtils.hasLogined(request.getSession())) {
    		System.out.println("not Logined");
            return "redirect:/member/login/form";		// login form 요청으로 redirect
        }
    	
    	MemberService memberService = new MemberServiceImpl();
    	String email = UserSessionUtils.getLoginUserId(request.getSession());
		WishService wishService = new WishServiceImpl();
		TalentService talentservice = new TalentServiceImpl();
		
		log.debug("wish List User : {}", email);
		
		int userId = memberService.getuserIdByEmail(email);

		int talentId = -1;
		if (request.getMethod().equals("POST")) {	
			
			talentId = Integer.parseInt(request.getParameter("talentId"));
			
			WishDTO wish = new WishDTO(talentId, userId);
			
			System.out.println(wish);
			
			
			int k = wishService.insertWish(wish);
			System.out.println(k+"완료");
		}
		
//		List<WishDTO> wishList = wishService.getWishListByUserId(userId);
		WishMapperRepository dao = new WishMapperRepository();
		List<Wish> wishList = dao.selectAllWishListByUserId(userId);
		List<TalentDTO> talentList = new ArrayList<>();
		for(int i = 0; i < wishList.size(); i++) {
			int wishTalentId = wishList.get(i).getTalentId();
			TalentDTO dto = talentservice.findTalent(wishTalentId);
			talentList.add(dto);
		}
		request.setAttribute("talentId", talentId);
		request.setAttribute("talentList", talentList);
		
		return "/member/wishList.jsp";
	}

}
