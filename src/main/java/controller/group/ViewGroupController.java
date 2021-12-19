package controller.group;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import controller.Controller;
import model.Group;
import model.dao.GroupDAO;
import service.GroupService;
import service.GroupServiceImpl;
import service.MemberService;
import service.MemberServiceImpl;
import service.dto.GroupDTO;

public class ViewGroupController implements Controller {

	private static final Object[] String = null;
	private static GroupDAO groupDao = new GroupDAO();

	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		// TODO Auto-generated method stub
		
		int talentId = Integer.parseInt(request.getParameter("talentId"));
		MemberService mService = new MemberServiceImpl();
		
		GroupService gService = new GroupServiceImpl();
		List<GroupDTO> groupList = gService.GroupList(talentId);
		
		ArrayList<Group> group = new ArrayList<Group>(); 
		
		
		HashMap<Integer, String[]> groupMemberList = new HashMap<Integer, String[]>();
		HashMap<Integer, Integer[]> userIdList = new HashMap<Integer, Integer[]>();
		
		
		for(int i = 0; i < groupList.size(); i++) {
			Integer[] id = gService.getGroupMembers(groupList.get(i).getGroupId());
			group.add(groupDao.getGroupByGroupId(groupList.get(i).getGroupId()));
			if(id != null) {
				
				ArrayList<String> groupMembersNick = new ArrayList<String>();
				for(int j = 0; j < id.length; j++) {
					groupMembersNick.add(mService.getNicknameByUserId(id[j]));
				}
				groupMemberList.put(groupList.get(i).getGroupId(), groupMembersNick.toArray(new String[groupMembersNick.size()]));
				userIdList.put(groupList.get(i).getGroupId(), id);
			} 
			
		}
		
		request.setAttribute("group", group);
		request.setAttribute("talentId", talentId);
		request.setAttribute("groupList", groupList);
		request.setAttribute("groupMemberList", groupMemberList);
		request.setAttribute("userIdList",  userIdList);
		
		return "/talent/review";
	}

}