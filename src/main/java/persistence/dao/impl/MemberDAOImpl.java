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
			jdbcUtil.setSql(query);
			try {
				ResultSet rs = jdbcUtil.executeQuery();
				List<MemberDTO> list = new ArrayList<MemberDTO>();
				
				while(rs.next()) {
					MemberDTO dto = new MemberDTO();
					dto.setUserId(rs.getInt("USERID"));
					dto.setEmail(rs.getString("EMAIL"));
					dto.setPw(rs.getString("PW"));
					dto.setPhone(rs.getString("PHONE"));
					dto.setNickname(rs.getString("NICKNAME"));
					
					list.add(dto);
				}
				return list;
			}catch(Exception ex) {
				ex.printStackTrace();
			}finally {
				jdbcUtil.close();
			}return null;	
		}
		
		public int insertMember(MemberDTO member) {
			int result = 0;
			String insertQuery = "INSERT INTO MEMBERS (USERID, EMAIL, PW, PHONE, NICKNAME) " + 
								"VALUES (?, ?, ?, ?, ?)";
			
			DAOFactory factory = new DAOFactory();
			
			Object[] param = new Object[] {member.getUserId(), member.getEmail(), member.getPw(), member.getPhone(), member.getNickname()};
			//jdbcUtil.setSql(insertQuery, param);
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
