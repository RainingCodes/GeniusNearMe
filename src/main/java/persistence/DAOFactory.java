package persistence;

import persistence.dao.*;
import persistence.dao.impl.*;

// DAO �� ������ Implementation ��ü�� �����ϴ� Ŭ����
public class DAOFactory {
	
	// MemberDAO �� ���� RDB �� DAO Implementation ��ü�� ��ȯ
	public MemberDAO getMemberDAO() {
		return new MemberDAOImpl();
	}
	
	//...
}
