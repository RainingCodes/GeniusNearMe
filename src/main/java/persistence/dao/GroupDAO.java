package persistence.dao;

import java.util.List;
import service.dto.GroupDTO;

public interface GroupDAO {
	public int insertGroup(GroupDTO group);
	public int[] getGroupMembers(int groupId);
	public int insertGroupMember(int groupId, int talentId, int userId);
	public int setRepresentative(int groupId, int userId);
	public List<GroupDTO> getGroupList(int talentId);
	public int deleteGroupMember(int groupId, int userId);
	public int deleteGroup(int groupId);
	public int countGroupMembers(int groupId, int talentId);
	public GroupDTO getGroup(int groupId);
	public int updateCurrent(int groupId);
}
