package service;

import java.util.List;

import service.dto.GroupDTO;

public interface GroupService {
	public List<GroupDTO> GroupList(int talentId);
	public GroupDTO getGroup(int groupId, int talentId);
	public int insertGroupMember(GroupDTO group, int userId); 
	public int insertGroup (GroupDTO group, int talentId);
	public int deleteGroupMember(GroupDTO group, int userId);
	public int deleteGroup(GroupDTO group);
}
