package controller.group;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import controller.Controller;
import persistence.dao.impl.GroupDAOImpl;
import service.GroupService;
import service.GroupServiceImpl;
import service.MatchingService;
import service.MatchingServiceImpl;
import service.dto.GroupDTO;
import service.dto.MatchingDTO;
import service.dto.TalentDTO;
import service.dto.PriceDTO;
import java.util.List;

public class InsertGroupMemberController implements Controller {

	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		// TODO Auto-generated method stub
		HttpSession session = request.getSession();
		int talentId = Integer.parseInt(request.getParameter("talentId"));
		int userId = (int)session.getAttribute("userId");
		int groupId = Integer.parseInt(request.getParameter("groupId"));
		GroupService gService = new GroupServiceImpl();
		GroupDTO group = gService.getGroup(groupId, talentId);
		
		if(group.getMembers() == 0) 
			gService.setRepresentative(groupId, talentId, userId);

		
		int result = gService.insertGroupMember(groupId, talentId, userId);
		if(result > 0)
			group.setMembers(group.getMembers() + 1);
		
		List<GroupDTO> groupList = gService.GroupList(talentId);
		request.setAttribute("groupList", groupList);
		
		
		return "/talent/view";
	}

}
