package service;

import java.util.List;

import persistence.DAOFactory;
import persistence.dao.GroupDAO;
import service.dto.GroupDTO;

public class GroupServiceImpl implements GroupService {
	private GroupDAO groupDao = null;
	
	public GroupServiceImpl() {
		DAOFactory factory = new DAOFactory();
		groupDao = factory.getGroupDAO();
	}
	
	@Override
	public List<GroupDTO> GroupList(int talentId) {
		// TODO Auto-generated method stub
		return groupDao.getGroupList(talentId);
	}

	@Override
	public GroupDTO getGroup(int groupId, int talentId) {
		// TODO Auto-generated method stub
		return groupDao.getGroup(groupId, talentId);
	}

	@Override
	public int insertGroupMember(int groupId, int talentId, int userId) {
		// TODO Auto-generated method stub
		return groupDao.insertGroupMember(groupId, talentId, userId);
	}

	@Override
	public int insertGroup(GroupDTO group) {
		// TODO Auto-generated method stub
		return groupDao.insertGroup(group);
	}

	@Override
	public int deleteGroupMember(int groupId, int talentId, int userId) {
		// TODO Auto-generated method stub
		return groupDao.deleteGroupMember(groupId, talentId, userId);
	}

	@Override
	public int deleteGroup(int groupId) {
		// TODO Auto-generated method stub
		return groupDao.deleteGroup(groupId);
	}

	@Override
	public int setRepresentative(int groupId, int talentId, int userId) {
		// TODO Auto-generated method stub
		return groupDao.setRepresentative(groupId, talentId, userId);
	}

	@Override
	public int[] getGroupMembers(int groupId, int talentId) {
		// TODO Auto-generated method stub
		return groupDao.getGroupMembers(groupId, talentId);
	}


}
