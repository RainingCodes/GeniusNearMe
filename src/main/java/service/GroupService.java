package service;

import java.util.List;

import service.dto.GroupDTO;

public interface GroupService {
	public List<GroupDTO> GroupList(int talentId);
	public GroupDTO getGroup(int groupId);
	public int insertGroupMember(int groupId, int talentId, int userId); 
	public int insertGroup (GroupDTO group);
	public int deleteGroupMember(int groupId, int userId);
	public int deleteGroup(int groupId);
	public int setRepresentative(int groupId, int userId);
	public Integer[] getGroupMembers(int groupId);
	public int updateCurrent(int groupId);
}
