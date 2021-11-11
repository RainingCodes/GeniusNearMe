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
	//매징 리스트 반환  userId에 따른
		public List<MatchingDTO> getMatchingListByUserId(int userId){
			
		}
		
		//매칭상세 보기
		public MatchingDTO getMatchingByMatchingId(int matchingId);
		
		//매칭 결정
		public MatchingDTO decideMatching(MatchingDTO matchingDto);
		
		//매칭 apply
		public MatchingDTO applyMatching(MatchingDTO matchingDto);
}
