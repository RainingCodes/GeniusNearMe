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
	//매징 리스트 반환  userId에 따른
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
		
		//매칭상세 보기
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
		
		//매칭 결정 matching State가 성공(1)
		public int decideMatching(MatchingDTO matchingDto) {
			String updateQuery = "UPDATE MATCHING SET MATCHINGSTATE = 1 WHERE MATCHINGID = ? ";
		
			Object[] param = new Object[] { matchingDto.getMatchingId() };
			jdbcUtil.setSql(updateQuery);
			jdbcUtil.setParameters(param);
			int result = 0;
			
			try {
				result = jdbcUtil.executeUpdate();
			}catch(Exception ex) {
				ex.printStackTrace();
			}finally {
				jdbcUtil.close();
			}
			return result;			
		}
		
		//매칭 거절 및 실패. 즉 matchingState가 2
		public int denyMatching(MatchingDTO matchingDto) {
			String updateQuery = "UPDATE MATCHING SET MATCHINGSTATE = 2 WHERE MATCHINGID = ? ";
			
			Object[] param = new Object[] { matchingDto.getMatchingId() };
			jdbcUtil.setSql(updateQuery);
			jdbcUtil.setParameters(param);
			int result = 0;
			
			try {
				result = jdbcUtil.executeUpdate();
			}catch(Exception ex) {
				ex.printStackTrace();
			}finally {
				jdbcUtil.close();
			}
			return result;	
		}
		
		//매칭 apply
		public int insertMatching(MatchingDTO matchingDto) {
			int result = 0;
			String insertQuery = "INSERT INTO MATCHING (MATCHINGID, TALENTID, "
					+ "MATCHINGSTATE, GROUPID, USERID) "
					+ "VALUES (matchingId_seq.nextval, ?, ?, ?, ?) ";
			
			Object[] param = new Object[] { matchingDto.getMatchingId(), matchingDto.getTalentId(),
					matchingDto.getMatchingState(), matchingDto.getGroupId(), matchingDto.getUserId()};
			
			jdbcUtil.setSql(insertQuery);
			jdbcUtil.setParameters(param);
			
			try {
				
				result = jdbcUtil.executeUpdate();
			}catch(Exception ex) {
				ex.printStackTrace();
			}finally {
				jdbcUtil.close();
			}
			return result;	
			
		}
		//매칭 거절
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
				jdbcUtil.close();
			}
			
			return result;	
		}
}
