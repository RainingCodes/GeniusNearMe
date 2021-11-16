package persistence.dao.impl;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import persistence.dao.GroupDAO;
import persistence.util.JDBCUtil;
import service.dto.GroupDTO;
import service.dto.MemberDTO;

public class GroupDAOImpl implements GroupDAO {
	
	private JDBCUtil jdbcUtil =  null;
	
	private static String query = "SELECT GROUPING.GROUPID AS GROUP_ID, "
			+ "GROUPING.MATCHINGID AS MATCHING_ID, "
			+ "GROUPING.TALENTID AS TALENT_ID, "
			+ "GROUPING.REPRESENTATIVEID AS REPRESENTATIVE_ID "
			+ "GROUPING.HEADCOUNT AS HEAD_COUNT ";
	
	public GroupDAOImpl() {
		jdbcUtil = new JDBCUtil();
	}
	
	@Override
	public int insertGroup(GroupDTO group) {
		// TODO Auto-generated method stub
		int result = 0;
		String insertGroupQuery = "INSERT INTO GROUPING "
				+ "Values (group_seq.nextqal, ?, ?, ?, ?) ";
		
		Object[] param = new Object[] { ) };
		jdbcUtil.setSqlAndParameters(insertGroupQuery, param);
		
		try {
			result = jdbcUtil.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		String insertMatchingQuery = "INSERT INTO MATCHING (MATCHINGID, TALENTID, "
				+ "MATCHINGSTATE, GROUPID, USERID) "
				+ "VALUES (matching_seq.nextval, ?, DEFAULT, ?, ?) ";
		jdbcUtil.close();
		
		return result;
	}

	@Override
	public int[] getGroupMembers(int groupId, int talentId) {
		// TODO Auto-generated method stub
		String MembersQuery = "SELECT GROUPMEMBERS.USERID "
				+ "FROM GROUPMEMBERS "
				+ "WHERE GROUPID=? AND TALENTID=?";
		Object[] param = new Object[] { groupId, talentId };
		jdbcUtil.setSqlAndParameters(MembersQuery, param);
		ResultSet rs = jdbcUtil.executeQuery();
		int count = countGroupMembers(groupId, talentId);
		if(count != 0) {
			int[] memberList = new int[count];
			int i = 0;
			try {
				while(rs.next()) {
					memberList[i++] = rs.getInt("USER_ID");
				}
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
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
		jdbcUtil.setSqlAndParameters(insertMemberQuery, param);
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
		jdbcUtil = new JDBCUtil();
		if(result > 0) {
			group.setCountMembers(group.getCountMembers() + 1);
			String updateMembersQuery = "UPDATE GROUP SET MEMBERSCOUNT=? WHERE GROUPID=? ";
			param = new Object[] { group.getCountMembers(), group.getGroupId() };
			jdbcUtil.setSqlAndParameters(updateMembersQuery, param);
			try {
				jdbcUtil.executeUpdate();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			jdbcUtil.close();
		}
		return result;
	}


	@Override
	public int setRepresentative(GroupDTO group, int userId) {
		// TODO Auto-generated method stub
		int result = 0;
		String setRepreQuery = "UPDATE GROUPING SET REPRESENTATIVEID=? WHERE GROUPID=? ";
		Object[] param = new Object[] { userId, group.getGroupId() };
		jdbcUtil.setSqlAndParameters(setRepreQuery, param);
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
		String listQuery = query
				+ "WHERE TALENTID=? ";
		Object[] param = new Object[] { talentId };
		jdbcUtil.setSqlAndParameters(listQuery, param);
		ResultSet rs = jdbcUtil.executeQuery();
		List<GroupDTO> list = new ArrayList<GroupDTO>();
		try {
			while (rs.next()) {
				GroupDTO dto = new GroupDTO();
				dto.setGroupId(rs.getInt("GROUP_ID"));
				dto.setTalentId(talentId);
				dto.setRepresentativeId(rs.getInt("REPRESENTATIVE_ID"));
				dto.setMembersCount(rs.getInt("MEMBERS_COUNT"));
				dto.setMaximum(rs.getInt("MAXIMUM"));
				dto.setUserId(getGroupMembers(dto.getGroupId(), talentId));

				list.add(dto);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		jdbcUtil.close();
		return list;
	
	}

	@Override
	public int deleteGroupMember(GroupDTO group, int userId) {
		// TODO Auto-generated method stub
		int result = 0;
		String deleteMemQuery = "DELETE FROM GROUPMEMBERS WHERE USERID=? ";
		Object[] param = new Object[] { userId };
		jdbcUtil.setSqlAndParameters(deleteMemQuery, param);
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
		if(result > 0) {
			jdbcUtil = new JDBCUtil();
			group.setCountMembers(group.getCountMembers() - 1);
			String updateMembersQuery = "UPDATE GROUP SET MEMBERSCOUNT=? WHERE GROUPID=? ";
			param = new Object[] { group.getCountMembers(), group.getGroupId() };
			jdbcUtil.setSqlAndParameters(updateMembersQuery, param);
			try {
				jdbcUtil.executeUpdate();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			jdbcUtil.close();
		}
		
		return result;
		
	}

	@Override
	public int deleteGroup(GroupDTO group) {
		// TODO Auto-generated method stub
		int result = 0;
		String deleteGroupQuery = "DELETE FROM GROUPING WHERE GROUPID=? ";
		Object[] param = new Object[] { group.getGroupId() };
		jdbcUtil.setSqlAndParameters(deleteGroupQuery, param);
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
	public int countGroupMembers(int groupId, int talentId) {
		// TODO Auto-generated method stub
		String countMembersQuery = "SELECT * FROM GROUPMEMBERS WHERE GROUPID=? AND TALENTID=?";
		Object[] param = new Object[] { groupId, talentId };
		jdbcUtil.setSqlAndParameters(countMembersQuery, param);
		ResultSet rs = jdbcUtil.executeQuery();
		int count = 0;
		try {
			while(rs.next()) {
				count++;
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return count;
	}

	@Override
	public GroupDTO getGroup(int groupId, int talentId) {
		// TODO Auto-generated method stub
		String getGroupQuery = query + "WHERE GROUPID=? AND TALENTID=? ";
		Object[] param = new Object[] { groupId, talentId};
		jdbcUtil.setSqlAndParameters(getGroupQuery, param);
		ResultSet rs = jdbcUtil.executeQuery();
		try {
			if(rs.next()) {
				GroupDTO group = new GroupDTO();
				group.setGroupId(rs.getInt("GROUP_ID"));
				group.setMaximum(rs.getInt("MAXIMUM"));
				group.setCountMembers(rs.getInt("MEMBERS_COUNT"));
				group.setRepresentativeId(rs.getInt("REPRESENTATIVE_ID"));
				group.setTalentId(talentId);
				group.setUserId(getGroupMembers(groupId, talentId));
				return group;
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public int groupMatching(GroupDTO group) {
		int result = 0;
		return result;
	}

	

	
}
