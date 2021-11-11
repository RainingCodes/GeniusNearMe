package persistence.dao.impl;

import java.util.List;

import persistence.util.JDBCUtil;
import service.dto.TalentDTO;

public class TalentDAOImpl {
	private JDBCUtil jdbcUtil = null;
	
	private static String query = "SELECT TITLE, CONTENT, STARTDATE, DEADLINE, "
			+ "WRITTENDATE, MATCHINGCOUNTS, WRITERID, TALENTCATEGORYNAME, POSTTYPE ";

	public TalentDAOImpl() {
		jdbcUtil = new JDBCUtil();
	}
	
	public List<TalentDTO> getAllTalentList() {
		String allQuery = query + ""
	}
	
	
	
}
