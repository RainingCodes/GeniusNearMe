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
	
	private static String query = "SELECT MEMBERS.USERID AS USERID, "+
									"MEMBERS.EMAIL AS EMAIL, "+
									"MEMBERS.PW AS PW, "+
									"MEMBERS.PHONE AS PHONE, "+
									"MEMBERS.NICKNAME AS NICKNAME, ";
	
	public MemberDAOImpl() {
		jdbcUtil = new JDBCUtil();
	}
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
		public MemberDTO getMemberByUserId(int userId) {
			
			return null;
		}
}
