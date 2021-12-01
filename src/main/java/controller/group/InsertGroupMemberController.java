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
import service.MemberService;
import service.MemberServiceImpl;
import service.dto.GroupDTO;
import service.dto.MatchingDTO;
import service.dto.TalentDTO;
import service.dto.PriceDTO;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class InsertGroupMemberController implements Controller {

	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		// TODO Auto-generated method stub
		HttpSession session = request.getSession();
		int talentId = Integer.parseInt(request.getParameter("talentId"));
		int userId = (int)session.getAttribute("userId");

		int groupId = Integer.parseInt(request.getParameter("groupId"));

		MatchingService mService = new MatchingServiceImpl();
		GroupService gService = new GroupServiceImpl();
		GroupDTO group = gService.getGroup(groupId, talentId);

		MemberService m2Service = new MemberServiceImpl();
		
		if(group.getMembers() == 0) {
			System.out.println(gService.setRepresentative(groupId, talentId, userId) + "1번과정");
			System.out.println(mService.updateUserId(groupId, userId) + "2번 과정");
			
		}
		
		int result = gService.insertGroupMember(groupId, talentId, userId);
		System.out.println(result);
		group.setMembers(group.getMembers() + 1);
		//System.out.println(group.getMembers() + "호롤ㄹ록");
		
		List<GroupDTO> groupList = gService.GroupList(talentId);
		
		
		
		request.setAttribute("groupList", groupList);
		
		return "/talent/view";
	}

}
