package controller.group;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import controller.Controller;
import service.GroupService;
import service.GroupServiceImpl;
import service.MemberService;
import service.MemberServiceImpl;
import service.dto.GroupDTO;

public class ViewGroupController implements Controller {

	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		// TODO Auto-generated method stub
		
		int talentId = Integer.parseInt(request.getParameter("talentId"));
		MemberService mService = new MemberServiceImpl();
		
		GroupService gService = new GroupServiceImpl();
		List<GroupDTO> groupList = gService.GroupList(talentId);
			
		for(int i = 0; i < groupList.size(); i++) {
			int[] id = groupList.get(i).getUserId();
			if(id != null) {
				ArrayList<String> groupMembersNick = new ArrayList<>();
				for(int j = 0; j < id.length; j++)
					groupMembersNick.add(mService.getNicknameByUserId(id[j]));
				//groupMemberList.put(groupList.get(i).getGroupId(), groupMembersNick);'
			} 
		}
		
		request.setAttribute("talentId", talentId);
		request.setAttribute("groupList", groupList);
		
		return "/talent/review";
	}

}