package persistence.dao.impl;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import persistence.dao.GroupDAO;
import persistence.util.JDBCUtil;
import service.dto.GroupDTO;

public class GroupDAOImpl implements GroupDAO {
	
	private JDBCUtil jdbcUtil =  null;
	
	private static String query = "SELECT GROUPING.GROUPID AS GROUP_ID, "
			+ "GROUPING.TALENTID AS TALENT_ID, "
			+ "GROUPING.REPRESENTATIVEID AS REPRESENTATIVE_ID "
			+ "GROUPING.MAXIMUM ";
	
	public GroupDAOImpl() {
		jdbcUtil = new JDBCUtil();
	}
	
	@Override
	public int insertGroup(GroupDTO group) {
		// TODO Auto-generated method stub
		int result = 0;
		String insertGroupQuery = "INSERT INTO GROUPING (TALENT_ID, REPSENTATIVE_ID, MAXIMUM) "
				+ "Values (?, ?, ?) ";
		
		Object[] param = new Object[] { group.getTalentId(), group.getRepresentativeId(), group.getMaximum() };
		jdbcUtil.setSqlAndParameters(insertGroupQuery, param);
		
		result = jdbcUtil.executeUpdate();
		jdbcUtil.close();
		return result;
	}

	@Override
	public int[] getGroupMembers(GroupDTO group) {
		// TODO Auto-generated method stub
		String MemebersQuery = "SELECT GROUPMEMBERS.USERID "
				+ "WHERE GROUPID=? ";
		ResultSet rs = jdbcUtil.setSqlAndParameters(MembersQuery, group.getGroupId());
		int count = group.getMembersCount();
		if(count != 0) {
			int[] memberList = new int[count)];
			int i = 0;
			while(rs.next()) {
				memberList[i++] = rs.getInt("USER_ID");
			}
			return memberList;
		}
		jdbcUtil.executeQuery();
		jdbcUtil.close();
		
		return null;
	}

	@Override
	public int insertGroupMember(GroupDTO group, int userId) {
		// TODO Auto-generated method stub
		int result = 0;
		String insertMemberQuery = "INSERT INTO GROUPMEMBERS (USERID, GROUPID, TALENTID) "
				+ "VALUES (?, ?, ?) ";
		
		Object[] param = new Object[] { userId, group.getGroupId(), group.getTalentId()};
		
		try {
			result = jdbcUtil.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try {
			result = jdbcUtil.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		jdbcUtil.close();
		return result;
	}


	@Override
	public int setRepresentative(GroupDTO group, int userId) {
		// TODO Auto-generated method stub
		int result = 0;
		String setRepreQuery = "UPDATE GROUPING SET REPRESENTATIVEID=? WHERE GROUPID=? ";
		Object[] params = new Object[] { userId, group.getGroupId() };
		try {
			result = jdbcUtil.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		jdbcUtil.close();
		return result;
	}

	@Override
	public List<GroupDTO> getGroupList(int talentId) {
		// TODO Auto-generated method stub
		String listQuery = "SELECT GROUP.GROUPID AS GROUP_ID, "
				+ "GROUP.TALENTID AS TALENT_ID, "
				+ "GROUP.REPRESENTATIVEID AS REPRESENTATIVE_ID "
				+ "WHERE TALENTID=? ";
		ResultSet rs = jdbcUtil.setSqlAndParameters(listQuery, talentId);
		
		
		
		while(rs.next()) {
			GroupDTO dto = new GroupDTO();
			dto.setGroupId(rs.getInt("GROUP_Id"));
			dto.setRepresentativeId(rs.getInt("REPRESENTATIVE_ID"));
			dto.setTalentId(rs.getInt("TALENT_ID"));
			dto.setUserId(getGroupMembers(dto.getGroupId(talentId)));
		}
		jdbcUtil.executeQuery();
		jdbcUtil.close();
		
		return null;
	}

	@Override
	public int deleteGroupMember(GroupDTO group, int userId) {
		// TODO Auto-generated method stub
		int result = 0;
		String deleteMemQuery = "DELETE FROM GROUPMEMBERS WHERE USERID=? ";
		ResultSet rs = jdbcUtil.setSqlAndParameters(deleteMemQuery, userId);
		result = jdbcUtil.executeUpdate();
		jdbcUtil.close();
		return result;
	}

	@Override
	public int deleteGroup(GroupDTO group) {
		// TODO Auto-generated method stub
		int result = 0;
		String deleteGroupQuery = "DELETE FROM GROUPING WHERE GROUPID=? ";
		ResultSet rs = jdbcUtil.setSqlAndParameters(deleteGroupQuery, group.getGroupId());
		result = jdbcUtil.executeUpdate();
		jdbcUtil.close();
		return result;
	}

	

	@Override
	public int countGroupMembers(int groupId) {
		// TODO Auto-generated method stub
		int count = 0;
		String CountQuery = "SELECT COUNT(*) AS MEMBERSCOUNT"
				+ "FROM GROUPMEBMERS "
				+ "WHERE GROUPID=? ";
		ResultSet rs = jdbcUtil.setSqlAndParameters(CountQuery, groupId);
		
		if(rs.next()) {
			count = rs.getInt("MEMBERS_NUM");
			
		jdbcUtil.executeQuery();
		jdbcUtil.close();
		return count;
	}
	
	
}
