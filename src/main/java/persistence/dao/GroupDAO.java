package persistence.dao;

import java.util.List;
import service.dto.GroupDTO;

public interface GroupDAO {
	public int insertGroup(int groupId);
	public int[] getGroupMembers(int groupId);
	public int insertGroupMember(int userId);
	public int setRepresentative(int groupId, int userId);
	public List<GroupDTO> getGroupList();
	public int deleteGroupMember(int userId);
	public int deleteGroup(int groupId);
}
