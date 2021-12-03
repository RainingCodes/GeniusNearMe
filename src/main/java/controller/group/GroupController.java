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

public class GroupController implements Controller {

	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		// TODO Auto-generated method stub
		
		int talentId = Integer.parseInt(request.getParameter("talentId"));
		MemberService mService = new MemberServiceImpl();
		
		GroupService gService = new GroupServiceImpl();
		List<GroupDTO> groupList = gService.GroupList(talentId);
		HashMap<Integer, Integer> memberChange = (HashMap<Integer, Integer>) request.getAttribute("memberChange");
		if(memberChange != null) {
			Iterator<Integer> keys = memberChange.keySet().iterator();
			if(keys.hasNext()) {
				int key = keys.next();
				for(GroupDTO group : groupList)
					if(group.getGroupId() == key)
						group.setMembers(memberChange.get(key));
			}
		}
			
		HashMap<Integer, ArrayList<String>> groupMemberList = new HashMap<Integer, ArrayList<String>>();
			for(int i = 0; i < groupList.size(); i++) {
				int[] id = groupList.get(i).getUserId();
				if(id != null) {
					ArrayList<String> groupMembersNick = new ArrayList<>();
					for(int j = 0; j < id.length; j++)
						groupMembersNick.add(mService.getNicknameByUserId(id[j]));
					groupMemberList.put(groupList.get(i).getGroupId(), groupMembersNick);
				} 
			}
		
		 
		request.setAttribute("groupList", groupList);
		
		return "/talent/view.jsp";
	}

}
