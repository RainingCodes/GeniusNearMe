package persistence.dao.impl;

import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import persistence.dao.WishDAO;
import persistence.util.JDBCUtil;
import service.dto.WishDTO;

public class WishDAOImpl implements WishDAO{
	private JDBCUtil jdbcUtil = null;
	
	private static String query = "SELECT TALENTID, USERID ";
	
	public WishDAOImpl() {
		jdbcUtil = new JDBCUtil();
	}
	
	@Override
	public int insertWish(WishDTO wishDto) {
		int result = 0;
		String insertQuery = "INSERT INTO WISH (TALENTID, USERID) VALUES (?, ?) ";
		Object[] param = new Object[] { wishDto.getTalentID(), wishDto.getUserId()};
		
		jdbcUtil.setSql(insertQuery);
		jdbcUtil.setParameters(param);
		
		try {
			result = jdbcUtil.executeUpdate();
		}catch(Exception ex) {
			jdbcUtil.rollback();
			ex.printStackTrace();
		}finally {
			jdbcUtil.commit();
			jdbcUtil.close();
		}
		return result;
	}
	

	@Override
	public int deleteWish(int talentId, int userId) {
		int result = 0;
		String deleteQuery = "DELETE FROM WISH WHERE TALENTID = ? AND USERID = ? ";

		jdbcUtil.setSql(deleteQuery);
		Object[] param = new Object[] { talentId, userId };
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
		return result;
	}

	@Override
	public List<WishDTO> getWishListByUserId(int userId) {
		String searchQuery = query + "FROM WISH WHERE USERID = ? ";
		
		Object[] param = new Object[] { userId };


		
		try {
			ResultSet rs = jdbcUtil.executeQuery();
			List<WishDTO> list = new ArrayList<WishDTO>();
			
			while(rs.next()) {
				WishDTO dto = new WishDTO();
				dto.setTalentID(rs.getInt("TALENTID"));
				dto.setUserId(rs.getInt("USERID"));
			
				list.add(dto);
			}
			return list;
		}catch(Exception ex) {
			ex.printStackTrace();
		}finally {
			jdbcUtil.close();
		}return null;
	}
	public WishDTO getWish(int talentId, int userId) {
		String getWishQuery = query + "FROM WISH WHERE TALENTID = ? AND USERID = ? ";

		Object[] param = new Object[] { talentId, userId};
		
		jdbcUtil.setSql(getWishQuery);
		jdbcUtil.setParameters(param);
		
		try {
			ResultSet rs = jdbcUtil.executeQuery();
			WishDTO dto = null;
			
			if (rs.next()) {
				dto = new WishDTO();
				dto.setTalentID(rs.getInt("TALENTID"));
				dto.setUserId(rs.getInt("USERID"));
			}
			return dto;
		} catch (Exception ex) {
			ex.printStackTrace();
		} finally {
			jdbcUtil.close();
		} return null;
	}
}
