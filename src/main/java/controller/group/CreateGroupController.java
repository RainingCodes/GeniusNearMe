package controller.group;

import java.util.ArrayList;
import java.util.List;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import controller.Controller;
import service.GroupService;
import service.GroupServiceImpl;
import service.MatchingService;
import service.MatchingServiceImpl;
import service.dto.GroupDTO;
import service.dto.MatchingDTO;
import service.dto.PriceDTO;

public class CreateGroupController implements Controller {
	private static final Logger log = LoggerFactory.getLogger(CreateGroupController.class);

	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		// TODO Auto-generated method stub
		HttpSession session = request.getSession();
		int talentId = Integer.parseInt(request.getParameter("talentId"));
		int userId = (int)session.getAttribute("userId");
		List<PriceDTO> priceList = (List<PriceDTO>) session.getAttribute("priceList");
		GroupService gService = new GroupServiceImpl();
		MatchingService mService = new MatchingServiceImpl();
		ArrayList<GroupDTO> groupList = new ArrayList<GroupDTO>();
		
		
		for(int i = 1; i < priceList.size(); i++) {
			String a = "group" + priceList.get(i).getHeadCount();
			String n = request.getParameter(a);
			log.debug(n);
			if(n != null) {
				for(int j = 0; j < Integer.parseInt(n); j++) {
					MatchingDTO mDTO = new MatchingDTO(-1, 0, talentId, -1, userId);
					int matchingId = mService.insertMatching(mDTO);
					GroupDTO group = new GroupDTO(talentId, priceList.get(i).getHeadCount(), matchingId);
					int groupId = gService.insertGroup(group);
					group.setGroupId(groupId);
					group.setMembers(0);
					groupList.add(group);
					int result = mService.updateGroupId(matchingId, groupId);
					log.debug("Create group : {}", group);
				}
			}
		}
		
		if(groupList != null)
			request.setAttribute("groupList", groupList);
		
	    return "/talent/view";	
	}

}
