package service;

import java.util.List;

import persistence.DAOFactory;
import persistence.dao.GroupDAO;
import persistence.util.JDBCUtil;
import service.dto.GroupDTO;

public class GroupServiceImpl implements GroupService {
	private GroupDAO groupDao = null;
	private JDBCUtil jdbcUtil = null;
	public GroupServiceImpl() {
		DAOFactory factory = new DAOFactory();
		groupDao = factory.getGroupDAO();
		jdbcUtil = new JDBCUtil();
	}
	
	@Override
	public List<GroupDTO> GroupList(int talentId) {
		// TODO Auto-generated method stub
		return groupDao.getGroupList(talentId);
	}

	@Override
	public GroupDTO getGroup(int groupId) {
		// TODO Auto-generated method stub
		return groupDao.getGroup(groupId);
	}

	@Override
	public int insertGroupMember(int groupId, int talentId, int userId) {
		// TODO Auto-generated method stub
		return groupDao.insertGroupMember(groupId, talentId, userId);
	}

	@Override
	public int insertGroup(GroupDTO group) {
		// TODO Auto-generated method stub
		System.out.println("로호호혹");
		return groupDao.insertGroup(group);
	}

	@Override
	public int deleteGroupMember(int groupId, int userId) {
		// TODO Auto-generated method stub
		return groupDao.deleteGroupMember(groupId, userId);
	}

	@Override
	public int deleteGroup(int groupId) {
		// TODO Auto-generated method stub
		return groupDao.deleteGroup(groupId);
	}

	@Override
	public int setRepresentative(int groupId, int userId) {
		// TODO Auto-generated method stub
		return groupDao.setRepresentative(groupId, userId);
	}

	@Override
	public int[] getGroupMembers(int groupId) {
		// TODO Auto-generated method stub
		return groupDao.getGroupMembers(groupId);
	}

	@Override
	public int updateCurrent(int groupId) {
		// TODO Auto-generated method stub
		return groupDao.updateCurrent(groupId);
	}
	

}
