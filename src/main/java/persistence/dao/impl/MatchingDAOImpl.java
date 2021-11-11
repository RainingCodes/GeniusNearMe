package persistence.dao.impl;

import java.util.List;

import persistence.dao.MatchingDAO;
import persistence.util.JDBCUtil;
import service.dto.MatchingDTO;

public class MatchingDAOImpl implements MatchingDAO{

	private JDBCUtil jdbcUtil = null;
	
	private static String query = "SELECT MATCHING.MATCHINGID AS MATCHINGID, "+
			"MATCHING.TALENTID AS TALENTID, "+
			"MATCHING.MATCHINGSTATE AS MATCHINGSTATE, "+
			"MATCHING.GROUPID AS GROUPID, "+
			"MATCHING.USERID AS USERID ";
	
	
	public MatchingDAOImpl() {
		jdbcUtil = new JDBCUtil();
	}
	//��¡ ����Ʈ ��ȯ  userId�� ����
		public List<MatchingDTO> getMatchingListByUserId(int userId){
			
		}
		
		//��Ī�� ����
		public MatchingDTO getMatchingByMatchingId(int matchingId);
		
		//��Ī ����
		public MatchingDTO decideMatching(MatchingDTO matchingDto);
		
		//��Ī apply
		public MatchingDTO applyMatching(MatchingDTO matchingDto);
}
