package persistence.dao.impl;

import java.util.ArrayList;
import java.util.List;
import java.sql.*;

import service.dto.*;
import persistence.DAOFactory;
import persistence.dao.*;
import persistence.util.JDBCUtil;

public class MemberDAOImpl implements MemberDAO{
	private JDBCUtil jdbcUtil = null;
	
	// Member�� �⺻ ������ �����ϴ� query��
	private static String query = "";
	
	// ������
	public MemberDAOImpl() {
		jdbcUtil = new JDBCUtil();
	}
	// ��ü ��������� List �� ��ȯ�ϴ� �޼ҵ�
		public List<MemberDTO> getMemberList() {	
			return null;	
		}
		public int insertMember(MemberDTO member) {
			return 0;
		}
		public int updateMember(MemberDTO member) {
			return 0;
		}
		public int deleteMember(int userId) {
			return 0;
		}
		public MemberDTO getMemberByNickname(String nickName) {
			return null;
		}
}
