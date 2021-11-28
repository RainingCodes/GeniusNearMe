package controller.group;

import java.util.ArrayList;

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
		int talentId = Integer.parseInt(request.getParameter("talentId"));
		ArrayList<PriceDTO> priceList = (ArrayList<PriceDTO>) request.getAttribute("priceList");
		int[] inGroup = new int[5];
		GroupService gService = new GroupServiceImpl();
		
		
		for(int i = 1; i < priceList.size(); i++) {
			int n = (int) request.getAttribute("group" + priceList.get(i).getHeadCount());
			for(int j = 0; j < n; j++) {
				GroupDTO group = new GroupDTO(talentId, priceList.get(i).getHeadCount());
				int result = gService.insertGroup(group);
				log.debug("Create group : {}", group);
			}
		}
		
	    return "redirect:/talent/view";	
	}

}
