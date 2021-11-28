package controller.group;

import java.util.ArrayList;
import java.util.List;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import controller.Controller;
import service.GroupService;
import service.GroupServiceImpl;
import service.MatchingService;
import service.MatchingServiceImpl;
import service.dto.GroupDTO;
import service.dto.MatchingDTO;
import service.dto.TalentDTO;
import service.dto.PriceDTO;

public class CreateGroupController implements Controller {
	private static final Logger log = LoggerFactory.getLogger(CreateGroupController.class);

	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		// TODO Auto-generated method stub
		System.out.println("호로로롥");
		String talentId = request.getParameter("talentId");
		System.out.println("가나다라마바사" + talentId);
		//List<PriceDTO> priceList = (List<PriceDTO>) request.getAttribute("prices");
		//GroupService gService = new GroupServiceImpl();
		
		//System.out.println("와랄ㄹ랄라" + priceList.get(1).getHeadCount());
		
		//for(int i = 1; i < priceList.size(); i++) {
		//	int n = (int) request.getAttribute("group" + priceList.get(i).getHeadCount());
		//	System.out.println("와랄ㄹ랄라" + n);
		//	for(int j = 0; j < n; j++) {
		//		GroupDTO group = new GroupDTO(talentId, priceList.get(i).getHeadCount());
		//		int result = gService.insertGroup(group);
		//		log.debug("Create group : {}", group);
		//	}
		//}
		
	    return "/talent/groupMatching.jsp";	
	}

}
