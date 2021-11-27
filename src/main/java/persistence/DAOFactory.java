package persistence;

import persistence.dao.*;
import persistence.dao.impl.*;

// DAO �� ������ Implementation ��ü�� �����ϴ� Ŭ����
public class DAOFactory {
	
	// MemberDAO �� ���� RDB �� DAO Implementation ��ü�� ��ȯ
	public MemberDAO getMemberDAO() {
		return new MemberDAOImpl();
	}
	public TalentDAO getTalentDAO() {
		return new TalentDAOImpl(); 
	}
	public CommentDAO getCommentDAO() {
		return new CommentDAOImpl();
		
	}
	public MatchingDAO getMatchingDAO() {
		return new MatchingDAOImpl();		
	}
	public GroupDAO getGroupDAO() {
		return new GroupDAOImpl();
	}
	
	public MyMatchingDAO getMyMatchingDAO() {
		return new MyMatchingDAOImpl();
	}
	
	public PriceDAO getPriceDAO() {
		return new PriceDAOImpl();
	}
	public TalentTestDAO getTalentTestDAO() {
		return new TalentTestDAOImpl();
	}
}
