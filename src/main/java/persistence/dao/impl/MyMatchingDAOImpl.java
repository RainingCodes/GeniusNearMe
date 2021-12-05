package persistence.dao.impl;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

import persistence.dao.MyMatchingDAO;
import persistence.util.JDBCUtil;
import service.dto.MyMatchingDTO;

public class MyMatchingDAOImpl implements MyMatchingDAO {
	private JDBCUtil jdbcUtil = null;
	
	private static String query = "SELECT MATCHING.MATCHINGID AS MATCHINGID, "
			+ "TALENT.TALENTID AS TALENTID, "
			+ "TALENT.TITLE AS TITLE, "
			+ "MATCHING.MATCHINGSTATE AS MATCHINGSTATE ";
	
	public MyMatchingDAOImpl() {
		jdbcUtil = new JDBCUtil();
	}
	
	public List<MyMatchingDTO> getApplyMyOneMatchingListByUserId(int userId) {
		String searchQuery = query + "FROM MATCHING, TALENT "+
				"WHERE TALENT.WRITERID != ? AND MATCHING.TALENTID = TALENT.TALENTID AND USERID = ? AND MATCHING.GROUPID IS NULL";
		
		jdbcUtil.setSqlAndParameters(searchQuery, new Object[] { userId, userId });
		
		try {
			ResultSet rs = jdbcUtil.executeQuery();
			List<MyMatchingDTO> list = new ArrayList<MyMatchingDTO>();
			
			while (rs.next()) {
				MyMatchingDTO dto = new MyMatchingDTO();
				dto.setMatchingId(rs.getInt("MATCHINGID"));
				dto.setTalentId(rs.getInt("TALENTID"));
				dto.setTalentTitle(rs.getString("TITLE"));
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
	
	public List<MyMatchingDTO> getReceiveMyOneMatchingListByUserId(int userId) {
		String searchQuery = query + "FROM MATCHING, TALENT "+
				"WHERE MATCHING.TALENTID = TALENT.TALENTID AND TALENT.WRITERID = ? AND MATCHING.GROUPID IS NULL";
		
		jdbcUtil.setSqlAndParameters(searchQuery, new Object[] { userId });
		
		try {
			ResultSet rs = jdbcUtil.executeQuery();
			List<MyMatchingDTO> list = new ArrayList<MyMatchingDTO>();
			
			while (rs.next()) {
				MyMatchingDTO dto = new MyMatchingDTO();
				dto.setMatchingId(rs.getInt("MATCHINGID"));
				dto.setTalentId(rs.getInt("TALENTID"));
				dto.setTalentTitle(rs.getString("TITLE"));
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
	
	public List<MyMatchingDTO> getApplyMyGroupMatchingListByUserId(int userId) {
		String searchQuery = query + "FROM MATCHING, TALENT, GROUPING, GROUPMEMBERS "
				+ "WHERE MATCHING.MATCHINGID=GROUPING.MATCHINGID AND TALENT.TALENTID=GROUPING.TALENTID "
				+ "AND GROUPING.GROUPID=GROUPMEMBERS.GROUPID "+
				"AND TALENT.WRITERID != ? AND MATCHING.TALENTID = TALENT.TALENTID AND GROUPMEMBERS.USERID = ? AND MATCHING.GROUPID IS NOT NULL";
		
		jdbcUtil.setSqlAndParameters(searchQuery, new Object[] { userId, userId });
		
		try {
			ResultSet rs = jdbcUtil.executeQuery();
			List<MyMatchingDTO> list = new ArrayList<MyMatchingDTO>();
			
			while (rs.next()) {
				MyMatchingDTO dto = new MyMatchingDTO();
				dto.setMatchingId(rs.getInt("MATCHINGID"));
				dto.setTalentId(rs.getInt("TALENTID"));
				dto.setTalentTitle(rs.getString("TITLE"));
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
	
	public List<MyMatchingDTO> getReceiveMyGroupMatchingListByUserId(int userId) {
		String searchQuery = query + "FROM MATCHING, TALENT "+
				"WHERE MATCHING.TALENTID = TALENT.TALENTID AND TALENT.WRITERID = ? "
				+"AND MATCHING.GROUPID IS NOT NULL AND MATCHING.USERID != TALENT.WRITERID";
		
		jdbcUtil.setSqlAndParameters(searchQuery, new Object[] { userId });
		
		try {
			ResultSet rs = jdbcUtil.executeQuery();
			List<MyMatchingDTO> list = new ArrayList<MyMatchingDTO>();
			
			while (rs.next()) {
				MyMatchingDTO dto = new MyMatchingDTO();
				dto.setMatchingId(rs.getInt("MATCHINGID"));
				dto.setTalentId(rs.getInt("TALENTID"));
				dto.setTalentTitle(rs.getString("TITLE"));
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
	
	public int getUserIdByMatchingId(int matchingId) {
		String searchQuery = "SELECT USERID FROM MATCHING WHERE MATCHINGID = ? ";
		jdbcUtil.setSql(searchQuery);
		Object[] param = new Object[] { matchingId };
		jdbcUtil.setParameters(param);

		try {
			ResultSet rs = jdbcUtil.executeQuery();
			int userId = -1;

			if (rs.next()) {
				userId = rs.getInt("USERID");
			}
			return userId;
		} catch (Exception ex) {
			ex.printStackTrace();
		} finally {
			jdbcUtil.close();
		}
		return -1;
	}
	
	public int getWriterIdByTalentId(int talentId) {
		String searchQuery = "SELECT WRITERID FROM TALENT WHERE TALENTID = ? ";
		jdbcUtil.setSql(searchQuery);
		Object[] param = new Object[] { talentId };
		jdbcUtil.setParameters(param);

		try {
			ResultSet rs = jdbcUtil.executeQuery();
			int writerId = -1;

			if (rs.next()) {
				writerId = rs.getInt("WRITERID");
			}
			return writerId;
		} catch (Exception ex) {
			ex.printStackTrace();
		} finally {
			jdbcUtil.close();
		}
		return -1;
	}
}