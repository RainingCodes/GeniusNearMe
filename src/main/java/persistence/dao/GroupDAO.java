package persistence.dao;

import java.util.List;
import service.dto.GroupDTO;

public interface GroupDAO {
	public int insertGroup(GroupDTO group);
	public int[] getGroupMembers(GroupDTO group, int talentId);
	public int insertGroupMember(int groupId, int talentId, int userId);
	public int setRepresentative(int group, int userId);
	public List<GroupDTO> getGroupList(int talentId);
	public int deleteGroupMember(int groupId, int userId);
	public int deleteGroup(int groupId);
	public int countGroupMembers(int grouopId);
	public GroupDTO getGroup(GroupDTO group);
	public int groupMatching(GroupDTO group);
}
