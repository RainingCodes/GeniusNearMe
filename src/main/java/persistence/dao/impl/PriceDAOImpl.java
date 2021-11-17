package persistence.dao.impl;

import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import persistence.dao.PriceDAO;
import persistence.util.JDBCUtil;
import service.dto.PriceDTO;

public class PriceDAOImpl implements PriceDAO{
	private JDBCUtil jdbcUtil = null;
	
	private static String query = "SELECT TALENTID, HEADCOUNT, PRICE ";
	
	public PriceDAOImpl() {
		jdbcUtil = new JDBCUtil();
	}
	public List<PriceDTO> getPriceListByTalentId(int talentId){
		String searchQuery = query + "FROM PRICE WHERE TALENTID = ? ";
		
		Object[] param = new Object[] { talentId };
		jdbcUtil.setSql(searchQuery);
		jdbcUtil.setParameters(param);
		
		try {
			ResultSet rs = jdbcUtil.executeQuery();
			List<PriceDTO> list = new ArrayList<PriceDTO>();
			
			while(rs.next()) {
				PriceDTO dto = new PriceDTO();
				dto.setTalentID(rs.getInt("TALENTID"));
				dto.setHeadCount(rs.getInt("HEADCOUNT"));
				dto.setPrice(rs.getInt("PRICE"));
				
				list.add(dto);
			}
			return list;
		}catch(Exception ex) {
			ex.printStackTrace();
		}finally {
			jdbcUtil.close();
		}return null;
	}
	
	
	public int insertPrice(PriceDTO priceDto) {
		int result = 0;
		String insertQuery = "INSERT INTO PRICE (TALENTID, HEADCOUNT, PRICE) VALUES (?, ?, ?) ";
		
		Object[] param = new Object[] { priceDto.getTalentID(), priceDto.getHeadCount(), priceDto.getPrice()};
		
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
	public PriceDTO getPriceDTOByIdHead(int talentId, int headCount){//priceDto 반환
		String searchQuery = query + "FROM PRICE " + "WHERE TALENTID=? AND HEADCOUNT=? ";
		
		Object[] param = new Object[] {talentId, headCount};
		jdbcUtil.setSql(searchQuery);
		jdbcUtil.setParameters(param);
		
		try {
			ResultSet rs = jdbcUtil.executeQuery();
			PriceDTO dto = null;
			
			if(rs.next()) {
				dto = new PriceDTO();
				dto.setTalentID(rs.getInt("TALENTID"));
				dto.setHeadCount(rs.getInt("HEADCOUNT"));
				dto.setPrice(rs.getInt("PRICE"));
			}
			return dto;
		}catch(Exception ex) {
			ex.printStackTrace();
		}finally {
			jdbcUtil.close();
		}return null;
	}
	public int getPriceByIdHead(int talentId, int headCount){//price 반환
		String searchQuery = query + "FROM PRICE " + "WHERE TALENTID=? AND HEADCOUNT=? ";
		
		Object[] param = new Object[] {talentId, headCount};
		jdbcUtil.setSql(searchQuery);
		jdbcUtil.setParameters(param);
		
		try {
			ResultSet rs = jdbcUtil.executeQuery();
			int price = -1;
			
			if(rs.next()) {
				price = rs.getInt("PRICE");
			}
			return price;
		}catch(Exception ex) {
			ex.printStackTrace();
		}finally {
			jdbcUtil.close();
		}return -1;
	}
	
	public int deleteAllPriceById(int talentId) {
		int result = 0;
		String deleteQuery = "DELETE FROM PRICE WHERE = ? ";
		
		Object[] param = new Object[] { talentId };
		jdbcUtil.setSqlAndParameters(deleteQuery, param);
		
		try {
			result = jdbcUtil.executeUpdate();
			return result;
		}catch(Exception e) {
			jdbcUtil.rollback();
			e.printStackTrace();
		}finally {
			jdbcUtil.commit();
			jdbcUtil.close();
		}
		return result;
	}
	public int updatePrice(PriceDTO priceDto) {
		int result = 0;
		
		String updateQuery = "UPDATE PRICE SET ";
		int index = 0;
		Object[] tempParam = new Object[10];
		
		if(priceDto.getPrice() != -1) {
			updateQuery += "PRICE = ?, ";
			tempParam[index++] = priceDto.getPrice();
		}
		
		updateQuery += "WHERE TALENTID = ? AND HEADCOUNT = ? ";
		updateQuery = updateQuery.replace(", WHERE", " WHERE");
		
		System.out.println(updateQuery);
		
		tempParam[index++] = priceDto.getTalentID();
		tempParam[index++] = priceDto.getHeadCount();
		
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
}
