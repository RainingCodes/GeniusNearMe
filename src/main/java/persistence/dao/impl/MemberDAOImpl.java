package persistence.dao.impl;

import java.util.ArrayList;
import java.util.List;
import java.sql.*;

import service.dto.*;
import persistence.dao.*;
import persistence.util.JDBCUtil;

public class MemberDAOImpl implements MemberDAO {
	private JDBCUtil jdbcUtil = null;

	private static String query = "SELECT PW, EMAIL, PHONE, USERID, NICKNAME ";

	public MemberDAOImpl() {
		jdbcUtil = new JDBCUtil();
	}

	public List<MemberDTO> getMemberList() {
		String allQuery = query + "FROM MEMBERS ORDER BY USERID ASC ";

		jdbcUtil.setSqlAndParameters(allQuery, null);
		try {
			ResultSet rs = jdbcUtil.executeQuery();
			List<MemberDTO> list = new ArrayList<MemberDTO>();

			while (rs.next()) {
				MemberDTO dto = new MemberDTO();
				dto.setPw(rs.getString("PW"));
				dto.setEmail(rs.getString("EMAIL"));
				dto.setPhone(rs.getString("PHONE"));
				dto.setUserId(rs.getInt("USERID"));
				dto.setNickname(rs.getString("NICKNAME"));

				list.add(dto);
			}
			return list;
		} catch (Exception ex) {
			jdbcUtil.rollback();
			ex.printStackTrace();
		} finally {
			jdbcUtil.commit();
			jdbcUtil.close();
		}
		return null;
	}

	public int insertMember(MemberDTO member) {
		int result = 0;
		String insertQuery = "INSERT INTO MEMBERS (USERID, PW, EMAIL, PHONE, NICKNAME) " + "VALUES (user_seq.nextval, ?, ?, ?, ?)";

		Object[] param = new Object[] { member.getPw(), member.getEmail(), member.getPhone(), member.getNickname() };
		jdbcUtil.setSqlAndParameters(insertQuery, param);

		try {
			result = jdbcUtil.executeUpdate();
		} catch (Exception ex) {
			jdbcUtil.rollback();
			ex.printStackTrace();
		} finally {
			jdbcUtil.commit();
			jdbcUtil.close();
		}
		return result;
	}

	public int updateMember(MemberDTO member) {
		int result = 0;

		String updateQuery = "UPDATE MEMBERS SET ";
		int index = 0;
		Object[] tempParam = new Object[10];

		if (member.getPw() != null) {
			updateQuery += "PW = ?, ";
			tempParam[index++] = member.getPw();
		}
		if (member.getPhone() != null) {
			updateQuery += "PHONE = ?, ";
			tempParam[index++] = member.getPhone();
		}
		if (member.getNickname() != null) {
			updateQuery += "NICKNAME = ?, ";
			tempParam[index++] = member.getNickname();
		}
		updateQuery += "WHERE USERID = ? ";
		updateQuery = updateQuery.replace(", WHERE", " WHERE");
		
		System.out.println(updateQuery);
		
		tempParam[index++] = member.getUserId();

		Object[] newParam = new Object[index];
		for (int i = 0; i < newParam.length; i++)
			newParam[i] = tempParam[i];

		jdbcUtil.setSqlAndParameters(updateQuery, newParam);

		try {
			result = jdbcUtil.executeUpdate();
			return result;
		} catch (Exception ex) {
			jdbcUtil.rollback();
			ex.printStackTrace();
		} finally {
			jdbcUtil.commit();
			jdbcUtil.close();
		}
		return result;
	}

	public int deleteMember(int userId) {
		int result = 0;
		String deleteQuery = "DELETE FROM MEMBERS WHERE USERID = ? ";

		jdbcUtil.setSql(deleteQuery);
		Object[] param = new Object[] { userId };
		jdbcUtil.setParameters(param);

		try {
			result = jdbcUtil.executeUpdate();
			return result;
		} catch (Exception ex) {
			jdbcUtil.rollback();
			ex.printStackTrace();
		} finally {
			jdbcUtil.commit();
			jdbcUtil.close();
		}
		return 0;
	}

	public MemberDTO getMemberByNickname(String nickName) {
		String searchQuery = query + "FROM MEMBERS " + "WHERE NICKNAME = ? ";
		jdbcUtil.setSql(searchQuery);
		Object[] param = new Object[] { nickName };
		jdbcUtil.setParameters(param);

		try {
			ResultSet rs = jdbcUtil.executeQuery();
			MemberDTO member = null;

			if (rs.next()) {
				member = new MemberDTO();
				member.setPw(rs.getString("PW"));
				member.setEmail(rs.getString("EMAIL"));
				member.setPhone(rs.getString("PHONE"));
				member.setUserId(rs.getInt("USERID"));
				member.setNickname(rs.getString("NICKNAME"));
			}
			return member;
		} catch (Exception ex) {
			jdbcUtil.rollback();
			ex.printStackTrace();
		} finally {
			jdbcUtil.commit();
			jdbcUtil.close();
		}
		return null;
	}

	public MemberDTO getMemberByUserId(int userId) {
		String searchQuery = query + "FROM MEMBERS " + "WHERE USERID = ? ";
		jdbcUtil.setSql(searchQuery);
		Object[] param = new Object[] { userId };
		jdbcUtil.setParameters(param);

		try {
			ResultSet rs = jdbcUtil.executeQuery();
			MemberDTO member = null;

			if (rs.next()) {
				member = new MemberDTO();
				member.setPw(rs.getString("PW"));
				member.setEmail(rs.getString("EMAIL"));
				member.setPhone(rs.getString("PHONE"));
				member.setUserId(rs.getInt("USERID"));
				member.setNickname(rs.getString("NICKNAME"));
			}
			return member;
		} catch (Exception ex) {
			jdbcUtil.rollback();
			ex.printStackTrace();
		} finally {
			jdbcUtil.commit();
			jdbcUtil.close();
		}
		return null;
	}
	
	public MemberDTO getMemberByEmail(String email) {
		String searchQuery = query + "FROM MEMBERS " + "WHERE EMAIL = ? ";
		
		jdbcUtil.setSqlAndParameters(searchQuery, new Object[] { email });

		try {
			ResultSet rs = jdbcUtil.executeQuery();
			MemberDTO member = null;

			if (rs.next()) {
				member = new MemberDTO();
				member.setPw(rs.getString("PW"));
				member.setEmail(rs.getString("EMAIL"));
				member.setPhone(rs.getString("PHONE"));
				member.setUserId(rs.getInt("USERID"));
				member.setNickname(rs.getString("NICKNAME"));
			}
			System.out.println("getMemberBYEmail : " + member);
			return member;
			
		} catch (Exception ex) {
			jdbcUtil.rollback();
			ex.printStackTrace();
			
		} finally {
			jdbcUtil.commit();
			jdbcUtil.close();
		}
		return null;
	}
	
	public int getUserIdByEmail(String email) {
		String searchQuery = "SELECT USERID FROM MEMBERS WHERE EMAIL = ? ";
		jdbcUtil.setSql(searchQuery);
		Object[] param = new Object[] { email };
		jdbcUtil.setParameters(param);

		try {
			ResultSet rs = jdbcUtil.executeQuery();
			int userId = -1;

			if (rs.next()) {
				userId = rs.getInt("USERID");
			}
			return userId;
		} catch (Exception ex) {
			jdbcUtil.rollback();
			ex.printStackTrace();
		} finally {
			jdbcUtil.commit();
			jdbcUtil.close();
		}
		return -1;
	}
	
	public String getEmailByUserId(int userId) {
		String searchQuery = "SELECT EMAIL FROM MEMBERS WHERE USERID = ? ";
		jdbcUtil.setSql(searchQuery);
		Object[] param = new Object[] { userId };
		jdbcUtil.setParameters(param);

		try {
			ResultSet rs = jdbcUtil.executeQuery();
			String email = null;

			if (rs.next()) {
				email = rs.getString("EMAIL");
			}
			return email;
		} catch (Exception ex) {
			jdbcUtil.rollback();
			ex.printStackTrace();
		} finally {
			jdbcUtil.commit();
			jdbcUtil.close();
		}
		return null;
	}
	
	//주어진 이메일 ID에 해당하는 사용자가 존재하는지 검사 
	public boolean existingEmail(String email) throws SQLException {
		String sql = "SELECT count(*) FROM MEMBERS WHERE EMAIL = ?";     
		
		System.out.println(email);
		Object[] param = new Object[] { email };
		jdbcUtil.setSqlAndParameters(sql, param);	// JDBCUtil에 query문과 매개 변수 설정

		try {
			ResultSet rs = jdbcUtil.executeQuery();		// query 실행
			if (rs.next()) {
				int count = rs.getInt(1);
				return (count == 1 ? true : false);
			}
		} catch (Exception ex) {
			jdbcUtil.rollback();
			ex.printStackTrace();
		} finally {
			jdbcUtil.commit();
			jdbcUtil.close();		// resource 반환
		}
		return false;
	}
	
	public boolean existingNickname(String nickname) throws SQLException {
		String sql = "SELECT count(*) FROM MEMBERS WHERE NICKNAME = ?";      
		jdbcUtil.setSqlAndParameters(sql, new Object[] { nickname });	// JDBCUtil에 query문과 매개 변수 설정
		
		System.out.println(sql);

		try {
			ResultSet rs = jdbcUtil.executeQuery();		// query 실행
			if (rs.next()) {
				int count = rs.getInt(1);
				System.out.println(count);
				boolean result = (count == 1 ? true : false);
				System.out.println(result);
				return result;
			}
		} catch (Exception ex) {
			jdbcUtil.rollback();
			ex.printStackTrace();
		} finally {
			jdbcUtil.commit();
			jdbcUtil.close();		// resource 반환
		}
		return false;
	}
	
	public boolean existingNicknameForEdit(String nickname, int userId) throws SQLException {
		String sql = "SELECT count(*), USERID FROM MEMBERS WHERE NICKNAME = ?";      
		jdbcUtil.setSqlAndParameters(sql, new Object[] { nickname });	// JDBCUtil에 query문과 매개 변수 설정
		
		System.out.println(sql);

		try {
			ResultSet rs = jdbcUtil.executeQuery();		// query 실행
			if (rs.next()) {
				int count = rs.getInt(1);
				
				boolean result = (count == 1 ? true : false);
				
				if (result == true) { // 유저아이디랑 같은지 체크
					int selectID = rs.getInt("USERID");
					if (selectID == userId) {
						return false;
					}
				}
				return result;
			}
		} catch (Exception ex) {
			jdbcUtil.rollback();
			ex.printStackTrace();
		} finally {
			jdbcUtil.commit();
			jdbcUtil.close();		// resource 반환
		}
		return false;
	}
	
	public String getNicknameByUserId(int userId) {
		String searchQuery = query+ "FROM MEMBERS WHERE USERID=? ";
		
		String nickName = null;
		jdbcUtil.setSqlAndParameters(searchQuery, new Object[] {userId});
		
		try {
			ResultSet rs = jdbcUtil.executeQuery();
			if(rs.next()) {
				nickName = rs.getString("NICKNAME");
			}
			return nickName;
		} catch (Exception ex) {
			ex.printStackTrace();
		} finally {
			jdbcUtil.close();
		} return null;
	}
}
