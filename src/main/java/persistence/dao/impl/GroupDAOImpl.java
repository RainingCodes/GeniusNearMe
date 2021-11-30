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
			+ "GROUPING.REPRESENTATIVEID AS REPRESENTATIVE_ID, "
			+ "GROUPING.HEADCOUNT AS HEAD_COUNT FROM GROUPING ";
	
	public GroupDAOImpl() {
		jdbcUtil = new JDBCUtil();
	}
	
	@Override
	public int insertGroup(GroupDTO group) {
		// TODO Auto-generated method stub
		int result = 0;
		int generatedKey = 0;
		
		String insertGroupQuery = "INSERT INTO GROUPING (GROUPID, MATCHINGID, TALENTID, REPRESENTATIVEID, HEADCOUNT) "
				+ "Values (group_seq.nextval, ?, ?, null, ?) ";
		
		Object[] param = new Object[] { group.getMatchingId(), group.getTalentId(), group.getHeadCount()  };
		jdbcUtil.setSql(insertGroupQuery);
		jdbcUtil.setParameters(param);
		String key[] = {"GROUPID"};
		
		try {
			
			result = jdbcUtil.executeUpdate(key);
			ResultSet rs = jdbcUtil.getGeneratedKeys();
			
			if(rs.next())
				generatedKey = rs.getInt(1);
			
		}catch(Exception ex) {
			jdbcUtil.rollback();
			ex.printStackTrace();
		}finally {
			jdbcUtil.commit();
			jdbcUtil.close();
		}
		return generatedKey;	
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
	public int insertGroupMember(int groupId, int talentId, int userId) {
		// TODO Auto-generated method stub
		int result = 0;
		String insertMemberQuery = "INSERT INTO GROUPMEMBERS (USERID, GROUPID, TALENTID) "
				+ "VALUES (?, ?, ?) ";
		
		Object[] param = new Object[] { userId, groupId, talentId };
		jdbcUtil.setSqlAndParameters(insertMemberQuery, param);
		try {
			result = jdbcUtil.executeUpdate();
		} catch(Exception ex) {
			jdbcUtil.rollback();
			ex.printStackTrace();
		}finally {
			jdbcUtil.commit();
			jdbcUtil.close();
		}				
		
		return result;
	}


	@Override
	public int setRepresentative(int groupId, int talentId, int userId) {
		// TODO Auto-generated method stub
		int result = 0;
		String setRepreQuery = "UPDATE GROUPING SET REPRESENTATIVEID=? WHERE GROUPID=? AND TALENTID=?";
		Object[] param = new Object[] { userId, groupId, talentId };
		jdbcUtil.setSqlAndParameters(setRepreQuery, param);
		try {
			result = jdbcUtil.executeUpdate();
		} catch(Exception ex) {
			jdbcUtil.rollback();
			ex.printStackTrace();
		}finally {
			jdbcUtil.commit();
			jdbcUtil.close();
		}				
		
		return result;
	}

	@Override
	public List<GroupDTO> getGroupList(int talentId) {
		// TODO Auto-generated method stub
		String listQuery = query
				+ "WHERE TALENTID=? ";
		Object[] param = new Object[] { talentId };
		jdbcUtil.setSqlAndParameters(listQuery, param);
		
		try {
			ResultSet rs = jdbcUtil.executeQuery();
			List<GroupDTO> list = new ArrayList<GroupDTO>();
			while (rs.next()) {
				GroupDTO dto = new GroupDTO();
				dto.setGroupId(rs.getInt("GROUP_ID"));
				dto.setMatchingId(rs.getInt("MATCHING_ID"));
				dto.setTalentId(talentId);
				dto.setRepresentativeId(rs.getInt("REPRESENTATIVE_ID"));
				dto.setHeadCount(rs.getInt("HEAD_COUNT"));
				
				list.add(dto);
			}
			return list;
		} catch (Exception e) {
			jdbcUtil.rollback();
			e.printStackTrace();
		} finally {
			jdbcUtil.commit();
			jdbcUtil.close();
		}
		return null;
	
	}

	@Override
	public int deleteGroupMember(int groupId, int talentId, int userId) {
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
			GroupDTO group = getGroup(groupId, talentId);
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
	public int deleteGroup(int groupId) {
		int result = 0;
		String deleteGroupMembersQuery = "DELETE FROM GROUPMEMBERS WHERE GROUPID=? ";
		Object[] param = new Object[] { groupId };
		jdbcUtil.setSqlAndParameters(deleteGroupMembersQuery, param);
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
			String deleteGroupQuery = "DELETE FROM GROUPING WHERE GROUPID=? ";
			param = new Object[] { groupId };
			jdbcUtil.setSqlAndParameters(deleteGroupMembersQuery, param);
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
		}
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
				group.setGroupId(groupId);
				group.setMatchingId(rs.getInt("MATCHING_ID"));
				group.setTalentId(talentId);
				group.setHeadCount(rs.getInt("HEAD_COUNT"));
				group.setRepresentativeId(rs.getInt("REPRESENTATIVE_ID"));
				group.setUserId(getGroupMembers(groupId, talentId));
				return group;
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
	
}
