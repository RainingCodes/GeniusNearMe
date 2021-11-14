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
	public int insertGroupMember(GroupDTO group, int userId) {
		// TODO Auto-generated method stub
		return groupDao.insertGroupMember(group, userId);
	}

	@Override
	public int insertGroup(GroupDTO group, int talentId) {
		// TODO Auto-generated method stub
		return groupDao.insertGroup(group, talentId);
	}

	@Override
	public int deleteGroupMember(GroupDTO group, int userId) {
		// TODO Auto-generated method stub
		return groupDao.deleteGroupMember(group, userId);
	}

	@Override
	public int deleteGroup(GroupDTO group) {
		// TODO Auto-generated method stub
		return groupDao.deleteGroup(group);
	}


}
