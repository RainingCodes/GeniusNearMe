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
	
	public List<MyMatchingDTO> getMyMatchingListByUserId(int userId) {
		String searchQuery = query + "FROM MATCHING, TALENT "+
				"WHERE MATCHING.TALENTID = TALENT.TALENTID AND USERID = ? ";
		
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
				
				System.out.println(dto);
				
				list.add(dto);
			}
			return list;
		}catch(Exception ex) {
			ex.printStackTrace();
		}finally {
			jdbcUtil.close();
		}return null;
	}
}
