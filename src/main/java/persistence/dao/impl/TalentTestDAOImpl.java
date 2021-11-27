package persistence.dao.impl;

import java.sql.ResultSet;

import persistence.dao.TalentTestDAO;
import persistence.util.JDBCUtil;
import service.dto.TalentTestDTO;

public class TalentTestDAOImpl implements TalentTestDAO {
	private JDBCUtil jdbcUtil = null;

	private static String query = "SELECT RESULTCATEGORY, RESULTTYPE, USERID ";

	public TalentTestDAOImpl() {
		jdbcUtil = new JDBCUtil();
	}
	
	
	//아이디로 탤런트테스트 가져오기
	public TalentTestDTO getTalentTestByUserId(int userId) {
		String searchQuery = query + "FROM TALENTTEST " + "WHERE USERID = ? ";
		jdbcUtil.setSql(searchQuery);
		Object[] param = new Object[] { userId };
		jdbcUtil.setParameters(param);

		try {
			ResultSet rs = jdbcUtil.executeQuery();
			TalentTestDTO talentTest = null;

			if (rs.next()) {
				talentTest = new TalentTestDTO();
				talentTest.setResultCategory(rs.getString("RESULTCATEGORY"));
				talentTest.setResultType(rs.getString("RESULTTYPE"));
				talentTest.setUserId(rs.getInt("USERID"));
			}
			return talentTest;
		} catch (Exception ex) {
			jdbcUtil.rollback();
			ex.printStackTrace();
		} finally {
			jdbcUtil.commit();
			jdbcUtil.close();
		}
		return null;
	}
		
	//CUD
	public int insertTalent(TalentTestDTO t) {
		int result = 0;
		String insertQuery = "INSERT INTO TALENTTEST (RESULTCATEGORY, RESULTTYPE, USERID) " + "VALUES (?, ?, ?)";

		Object[] param = new Object[] { t.getResultCategory(), t.getResultType(), t.getUserId() };
		jdbcUtil.setSqlAndParameters(insertQuery, param);

		try {
			result = jdbcUtil.executeUpdate();
		} catch (Exception ex) {
			jdbcUtil.rollback();
			ex.printStackTrace();
		} finally {
			jdbcUtil.commit();
			jdbcUtil.close();
		}
		return result;
	}
	public int updateTalent(TalentTestDTO t) {
		int result = 0;

		String updateQuery = "UPDATE TALENTTEST SET ";
		int index = 0;
		Object[] tempParam = new Object[10];

		if (t.getResultCategory() != null) {
			updateQuery += "RESULTCATEGORY = ?, ";
			tempParam[index++] = t.getResultCategory();
		}
		if (t.getResultType() != null) {
			updateQuery += "RESULTTYPE = ?, ";
			tempParam[index++] = t.getResultType();
		}
		
		updateQuery += "WHERE USERID = ? ";
		updateQuery = updateQuery.replace(", WHERE", " WHERE");
		
		System.out.println(updateQuery);
		
		tempParam[index++] = t.getUserId();

		Object[] newParam = new Object[index];
		for (int i = 0; i < newParam.length; i++)
			newParam[i] = tempParam[i];

		jdbcUtil.setSqlAndParameters(updateQuery, newParam);

		try {
			result = jdbcUtil.executeUpdate();
			return result;
		} catch (Exception ex) {
			jdbcUtil.rollback();
			ex.printStackTrace();
		} finally {
			jdbcUtil.commit();
			jdbcUtil.close();
		}
		return result;
	}
	public int deleteTalent(int userId) {
		int result = 0;
		String deleteQuery = "DELETE FROM TALENTTEST WHERE USERID = ? ";

		jdbcUtil.setSql(deleteQuery);
		Object[] param = new Object[] { userId };
		jdbcUtil.setParameters(param);

		try {
			result = jdbcUtil.executeUpdate();
			return result;
		} catch (Exception ex) {
			jdbcUtil.rollback();
			ex.printStackTrace();
		} finally {
			jdbcUtil.commit();
			jdbcUtil.close();
		}
		return 0;
	}

}
