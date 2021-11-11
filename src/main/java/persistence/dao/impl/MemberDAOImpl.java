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
		String allQuery = query + ", " + "FROM MEMBERS ORDER BY USERID ASC ";

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
			ex.printStackTrace();
		} finally {
			jdbcUtil.close();
		}
		return null;
	}

	public int insertMember(MemberDTO member) {
		int result = 0;
		String insertQuery = "INSERT INTO MEMBERS (PW, EMAIL, PHONE, NICKNAME) " + "VALUES (?, ?, ?, ?)";

		Object[] param = new Object[] { member };
		jdbcUtil.setSqlAndParameters(insertQuery, param);

		try {
			result = jdbcUtil.executeUpdate();
		} catch (Exception ex) {
			ex.printStackTrace();
		} finally {
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
		if (member.getEmail() != null) {
			updateQuery += "EMAIL = ?, ";
			tempParam[index++] = member.getEmail();
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
		String searchQuery = query + ", " + "FROM MEMBERS " + "WHERE MEMBERS.NICKNAME = ? ";
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
			ex.printStackTrace();
		} finally {
			jdbcUtil.close();
		}
		return null;
	}

	public MemberDTO getMemberByUserId(int userId) {
		String searchQuery = query + ", " + "FROM MEMBERS " + "WHERE MEMBERS.USERID = ? ";
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
			ex.printStackTrace();
		} finally {
			jdbcUtil.close();
		}
		return null;
	}
}
