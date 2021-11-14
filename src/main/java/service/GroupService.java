package service;

import java.util.List;

import service.dto.GroupDTO;

public interface GroupService {
	public List<GroupDTO> GroupList();
	public GroupDTO getGroup(int groupId);
	public int insertGroupMember(GroupDTO group, int userId); 
	public int insertGroup (GroupDTO group);
	public int deleteGroupMember(GroupDTO group, int userId);
	public int deleteGroup(GroupDTO group);
}
