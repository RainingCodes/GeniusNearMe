package persistence.dao.impl;

import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import persistence.dao.MatchingDAO;
import persistence.util.JDBCUtil;
import service.dto.MatchingDTO;

public class MatchingDAOImpl implements MatchingDAO {
	private JDBCUtil jdbcUtil = null;
	private static String query = "SELECT MATCHINGID, "+
			"TALENTID, "+
			"MATCHINGSTATE, "+
			"GROUPID, "+
			"USERID ";
	
	public MatchingDAOImpl() {
		jdbcUtil = new JDBCUtil();
	}
	//��¡ ����Ʈ ��ȯ  userId�� ����
		public List<MatchingDTO> getMatchingListByUserId(int userId){
			String searchQuery = query + "FROM MATCHING "+
							"WHERE USERID = ? ";
			
			Object[] param = new Object[] { userId };
			jdbcUtil.setSql(searchQuery);
			jdbcUtil.setParameters(param);
			
			try {
				ResultSet rs = jdbcUtil.executeQuery();
				List<MatchingDTO> list = new ArrayList<MatchingDTO>();
				
				while(rs.next()) {
					MatchingDTO dto = new MatchingDTO();
					dto.setMatchingId(rs.getInt("MATCHINGID"));
					dto.setTalentId(rs.getInt("TALENTID"));
					dto.setGroupId(rs.getInt("GROUPID"));
					dto.setUserId(rs.getInt("USERID"));
					dto.setMatchingState(rs.getInt("MATCHINGSTATE"));
					
					list.add(dto);
				}
				return list;
			}catch(Exception ex) {
				ex.printStackTrace();
			}finally {
				jdbcUtil.close();
			}return null;
		}
		
		//��Ī�� ����
		public MatchingDTO getMatchingByMatchingId(int matchingId) {
			String searchQuery = query + "FROM MATCHING "+
						"WHERE MATCHINGID = ? ";
			
			Object[] param = new Object[] { matchingId };
			jdbcUtil.setSql(searchQuery);
			jdbcUtil.setParameters(param);
			
			try {
				ResultSet rs = jdbcUtil.executeQuery();
				MatchingDTO dto = null;
				
				if(rs.next()) {
					dto = new MatchingDTO();
					dto.setMatchingId(rs.getInt("MATCHINGID"));
					dto.setTalentId(rs.getInt("TALENTID"));
					dto.setGroupId(rs.getInt("GROUPID"));
					dto.setUserId(rs.getInt("USERID"));
					dto.setMatchingState(rs.getInt("MATCHINGSTATE"));
				}
				return dto;
			}catch(Exception ex) {
				ex.printStackTrace();
			}finally {
				jdbcUtil.close();
			}return null;			
		}
		
		public int decideMatching(int matchingId) {
			String updateQuery = "UPDATE MATCHING SET MATCHINGSTATE = 1 WHERE MATCHINGID = ? ";
		
			Object[] param = new Object[] { matchingId };
			jdbcUtil.setSql(updateQuery);
			jdbcUtil.setParameters(param);
			int result = 0;
			
			try {
				result = jdbcUtil.executeUpdate();
			}catch(Exception ex) {
				jdbcUtil.rollback();
				ex.printStackTrace();
			}finally {
				jdbcUtil.commit();
				jdbcUtil.close();
			}
			return result;			
		}
		
		public int decideGroupMatching(int groupId) {
			String updateQuery = "UPDATE MATCHING SET MATCHINGSTATE = 1 WHERE GROUPID = ? ";
		
			Object[] param = new Object[] { groupId };
			jdbcUtil.setSql(updateQuery);
			jdbcUtil.setParameters(param);
			int result = 0;
			
			try {
				result = jdbcUtil.executeUpdate();
			}catch(Exception ex) {
				jdbcUtil.rollback();
				ex.printStackTrace();
			}finally {
				jdbcUtil.commit();
				jdbcUtil.close();
			}
			return result;			
		}
		
	
		public int denyMatching(int matchingId) {
			String updateQuery = "UPDATE MATCHING SET MATCHINGSTATE = 2 WHERE MATCHINGID = ? ";
			
			Object[] param = new Object[] { matchingId };
			jdbcUtil.setSql(updateQuery);
			jdbcUtil.setParameters(param);
			int result = 0;
			
			try {
				result = jdbcUtil.executeUpdate();
			}catch(Exception ex) {
				jdbcUtil.rollback();
				ex.printStackTrace();
			}finally {
				jdbcUtil.commit();
				jdbcUtil.close();
			}
			return result;	
		}
		public int denyGroupMatching(int groupId) {
			String updateQuery = "UPDATE MATCHING SET MATCHINGSTATE = 2 WHERE GROUPID = ? ";
			
			Object[] param = new Object[] { groupId };
			jdbcUtil.setSql(updateQuery);
			jdbcUtil.setParameters(param);
			int result = 0;
			
			try {
				result = jdbcUtil.executeUpdate();
			}catch(Exception ex) {
				jdbcUtil.rollback();
				ex.printStackTrace();
			}finally {
				jdbcUtil.commit();
				jdbcUtil.close();
			}
			return result;	
		}
		
		//��Ī apply
		public int insertMatching(MatchingDTO matchingDto) {
			int result = 0;
			int generatedKey = 0;
			String insertQuery;
			Object[] param;
			if(matchingDto.getGroupId() != -1) {
				insertQuery = "INSERT INTO MATCHING (MATCHINGID, TALENTID, "
						+ "MATCHINGSTATE, GROUPID, USERID) "
						+ "VALUES (matching_seq.nextval, ?, ?, ?, ?) ";
				param = new Object[] { matchingDto.getTalentId(), matchingDto.getMatchingState(), matchingDto.getGroupId(), matchingDto.getUserId()};
			}
			else {
				insertQuery = "INSERT INTO MATCHING (MATCHINGID, TALENTID, "
						+ "MATCHINGSTATE, GROUPID, USERID) "
						+ "VALUES (matching_seq.nextval, ?, ?, null, ?) ";
				param = new Object[] { matchingDto.getTalentId(), matchingDto.getMatchingState(), matchingDto.getUserId()};
			}
					
			
			
			
			jdbcUtil.setSql(insertQuery);
			jdbcUtil.setParameters(param);
			
			String key[] = {"MATCHINGID"};
			
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
		//��Ī ����
		public int deleteMatching(int matchingId) {
			int result = 0;
			String DeleteQuery = "DELETE FROM MATCHING WHERE MATCHINGID = ? ";
			
			Object[] param = new Object[] {matchingId};
			try {
				jdbcUtil.setSqlAndParameters(DeleteQuery, param);
				result = 1;
			}catch(Exception ex) {
				ex.printStackTrace();
			}finally {
				jdbcUtil.commit();
				jdbcUtil.close();
			}
			
			return result;	
		}
		@Override
		public int updateGroupId(int matchingId, int groupId) {
			// TODO Auto-generated method stub
			int result = 0;
			
			String updateGroupIdQuery = "UPDATE MATCHING SET GROUPID=? WHERE MATCHINGID=? ";
			
			Object[] param = new Object[] {groupId, matchingId};
			try {
				jdbcUtil.setSqlAndParameters(updateGroupIdQuery, param);
				result = jdbcUtil.executeUpdate();
			}catch(Exception ex) {
				ex.printStackTrace();
			}finally {
				jdbcUtil.commit();
				jdbcUtil.close();
			}
			
			return result;	
			
		}
		@Override
		public int updateUserId(int groupId, int userId) {
			// TODO Auto-generated method stub
			int result = 0;
			
			String updateUserIdQuery = "UPDATE MATCHING SET USERID=? WHERE GROUPID=? ";
			
			Object[] param = new Object[] {userId, groupId};
			try {
				jdbcUtil.setSqlAndParameters(updateUserIdQuery, param);
				result = jdbcUtil.executeUpdate();
			}catch(Exception ex) {
				ex.printStackTrace();
			}finally {
				jdbcUtil.commit();
				jdbcUtil.close();
			}
			
			return result;	
		}
		@Override
		public boolean checkMatching(int talentId, int userId) {
			// TODO Auto-generated method stub
			String checkMatchingQuery = "SELECT M.MATCHINGID FROM MATCHING M, TALENT T, GROUPING G, GROUPMEMBERS GM "
					+ "WHERE M.TALENTID=T.TALENTID AND T.WRITERID!=? AND M.TALENTID=? AND MATCHINGSTATE=0 AND "
					+ "(M.USERID=? OR (G.MATCHINGID=M.MATCHINGID AND G.GROUPID=GM.GROUPID AND GM.USERID=?))";
			Object[] param = new Object[] {userId, talentId, userId, userId};
			jdbcUtil.setSqlAndParameters(checkMatchingQuery, param);
			try {
				ResultSet rs = jdbcUtil.executeQuery();
				if(rs.next())
					return true;
			} catch(Exception ex) {
				jdbcUtil.rollback();
				ex.printStackTrace();
			}finally {
				jdbcUtil.close();
			}
			
			return false;
		}
		
		//진행중인 1:1매칭 확인 dao
		public boolean existWorkOnetoOneMatchingByTalentId(int userId, int talentId) {
			String  query = "SELECT MATCHINGID FROM MATCHING M, TALENT T "
					+ "WHERE M.TALENTID = T.TALENTID AND M.MATCHINGSTATE = 0 AND M.USERID = ? AND T.TALENTID = ?";
			
			Object[] param = new Object[] {userId, talentId};
			jdbcUtil.setSqlAndParameters(query, param);
			try {
				ResultSet rs = jdbcUtil.executeQuery();
				if(rs.next())
					return true;
			} catch(Exception ex) {
				ex.printStackTrace();
			}finally {
				jdbcUtil.close();
			}
			
			return false;
		}
		
}
