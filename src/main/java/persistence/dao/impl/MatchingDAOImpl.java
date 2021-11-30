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
		
		//��Ī apply
		public int insertMatching(MatchingDTO matchingDto) {
			int result = 0;
			int generatedKey = 0;
			String insertQuery = "INSERT INTO MATCHING (MATCHINGID, TALENTID, "
					+ "MATCHINGSTATE, GROUPID, USERID) "
					+ "VALUES (matching_seq.nextval, ?, ?, null, ?) ";
			
			Object[] param = new Object[] { matchingDto.getTalentId(), matchingDto.getMatchingState(), matchingDto.getUserId()};
			
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
		public int updateUserId(int matchingId, int userId) {
			// TODO Auto-generated method stub
			int result = 0;
			
			String updateUserIdQuery = "UPDATE MATCHING SET USERID=? WHERE MATCHINGID=? ";
			
			Object[] param = new Object[] {userId, matchingId};
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
}
