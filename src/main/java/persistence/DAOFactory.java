package persistence;

import persistence.dao.*;
import persistence.dao.impl.*;

// DAO 를 구현한 Implementation 객체를 생성하는 클래스
public class DAOFactory {
	
	// MemberDAO 를 위한 RDB 용 DAO Implementation 객체를 반환
	public MemberDAO getMemberDAO() {
		return new MemberDAOImpl();
	}
	public TalentDAO getTalentDAO() {
		return new TalentDAOImpl(); 
	}
	
	public MatchingDAO getMatchingDAO() {
		return new MatchingDAOImpl();		
	}
}
