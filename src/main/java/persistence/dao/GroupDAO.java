package persistence.dao;

import java.util.List;
import service.dto.GroupDTO;

public interface GroupDAO {
	public int insertGroup(GroupDTO group);
	public int[] getGroupMembers(GroupDTO group);
	public int insertGroupMember(GroupDTO group, int userId);
	public int setRepresentative(GroupDTO group, int userId);
	public List<GroupDTO> getGroupList(int talentId);
	public int deleteGroupMember(GroupDTO group, int userId);
	public int deleteGroup(GroupDTO group);
	public int countGroupMembers(int groupId);
}
