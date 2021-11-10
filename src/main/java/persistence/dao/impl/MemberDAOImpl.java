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
	
	// Member의 기본 정보를 포함하는 query문
	private static String query = "";
	
	// 생성자
	public MemberDAOImpl() {
		jdbcUtil = new JDBCUtil();
	}
	// 전체 멤버정보를 List 로 반환하는 메소드
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
