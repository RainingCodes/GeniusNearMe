package persistence.dao.impl;

import java.util.Date;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

import persistence.dao.TalentDAO;
import persistence.util.JDBCUtil;
import service.dto.TalentDTO;

public class TalentDAOImpl implements TalentDAO  {
	
	SimpleDateFormat format1 = new SimpleDateFormat ("yyyy-MM-dd");
	long miliseconds = System.currentTimeMillis();
    Date current = new Date(miliseconds);
	
	private JDBCUtil jdbcUtil = null;
	
	private static String query = "SELECT TALENTID, TITLE, CONTENT, STARTDATE, DEADLINE, "
			+ "WRITTENDATE, MATCHINGCOUNTS, WRITERID, TALENTCNAME, POSTTYPE ";

	public TalentDAOImpl() {
		jdbcUtil = new JDBCUtil();
	}
	
	public List<TalentDTO> getAllTalentList() {
		String getAllQuery = query + "FROM TALENT ";
		
		jdbcUtil.setSql(getAllQuery);
		try {
			ResultSet rs = jdbcUtil.executeQuery();
			List<TalentDTO> list = new ArrayList<TalentDTO>();
			
			while (rs.next()) {
				TalentDTO dto = new TalentDTO();
				dto.setTalentId(rs.getInt("TALENTID"));
				dto.setTitle(rs.getString("TITLE"));
				dto.setContent(rs.getString("CONTENT"));
				dto.setStartDate(rs.getDate("STARTDATE"));
				dto.setDeadLine(rs.getDate("DEADLINE"));
				dto.setWrittenDate(rs.getDate("WRITTENDATE"));
				dto.setMatchingCounts(rs.getInt("MATCHINGCOUNTS"));
				dto.setWriterId(rs.getInt("WRITERID"));
				dto.setTalentCategoryName(rs.getString("TALENTCNAME"));
				dto.setPostType(rs.getInt("POSTTYPE"));
				
				list.add(dto);
			}
			return list;
		} catch (Exception ex) {
			ex.printStackTrace();
		} finally {
			jdbcUtil.close();
		} return null;
	}
	
	public List<TalentDTO> getTalentListByCategory(String[] category) {
	      String getByCategoryQuery = query + "FROM TALENT WHERE ";
	      int i;
	      for(i = 0; i < category.length - 1; i++) {
	         getByCategoryQuery += "TALENTCNAME='" + category[i] + "' or ";
	      }
	      getByCategoryQuery += "TALENTCNAME='" + category[i] + "' ";
	      jdbcUtil.setSql(getByCategoryQuery);
	      
	      try {
	         ResultSet rs = jdbcUtil.executeQuery();
	         List<TalentDTO> list = new ArrayList<TalentDTO>();
	         
	         while (rs.next()) {
	            TalentDTO dto = new TalentDTO();
	            dto.setTalentId(rs.getInt("TALENTID"));
	            dto.setTitle(rs.getString("TITLE"));
	            dto.setContent(rs.getString("CONTENT"));
	            dto.setStartDate(rs.getDate("STARTDATE"));
	            dto.setDeadLine(rs.getDate("DEADLINE"));
	            dto.setWrittenDate(rs.getDate("WRITTENDATE"));
	            dto.setMatchingCounts(rs.getInt("MATCHINGCOUNTS"));
	            dto.setWriterId(rs.getInt("WRITERID"));
	            dto.setTalentCategoryName(rs.getString("TALENTCNAME"));
	            dto.setPostType(rs.getInt("POSTTYPE"));
	            
	            list.add(dto);
	         }
	         return list;
	      } catch (Exception ex) {
	         ex.printStackTrace();
	      } finally {
	         jdbcUtil.close();
	      } return null;
	   }
	
	public List<TalentDTO> getTalentListByTitle(String Title) {
		String getByTitleQuery = query + "FROM TALENT WHERE TITLE LIKE ? ";
		
		Object[] param = new Object[] { "%"+Title+"%" };
		
		jdbcUtil.setSql(getByTitleQuery);
		jdbcUtil.setParameters(param);
		
		try {
			ResultSet rs = jdbcUtil.executeQuery();
			List<TalentDTO> list = new ArrayList<TalentDTO>();
			
			while (rs.next()) {
				TalentDTO dto = new TalentDTO();
				dto.setTalentId(rs.getInt("TALENTID"));
				dto.setTitle(rs.getString("TITLE"));
				dto.setContent(rs.getString("CONTENT"));
				dto.setStartDate(rs.getDate("STARTDATE"));
				dto.setDeadLine(rs.getDate("DEADLINE"));
				dto.setWrittenDate(rs.getDate("WRITTENDATE"));
				dto.setMatchingCounts(rs.getInt("MATCHINGCOUNTS"));
				dto.setWriterId(rs.getInt("WRITERID"));
				dto.setTalentCategoryName(rs.getString("TALENTCNAME"));
				dto.setPostType(rs.getInt("POSTTYPE"));
				
				list.add(dto);
			}
			return list;
		} catch (Exception ex) {
			ex.printStackTrace();
		} finally {
			jdbcUtil.close();
		} return null;
	}
	
	public List<TalentDTO> getTalentListByWriterId(int userId){
		String getByWriterIdQuery = query + "FROM TALENT WHERE WRITERID = ? ";
		
		Object[] param = new Object[] { userId };
		
		jdbcUtil.setSql(getByWriterIdQuery);
		jdbcUtil.setParameters(param);
		
		try {
			ResultSet rs = jdbcUtil.executeQuery();
			List<TalentDTO> list = new ArrayList<TalentDTO>();
			
			while (rs.next()) {
				TalentDTO dto = new TalentDTO();
				dto.setTalentId(rs.getInt("TALENTID"));
				dto.setTitle(rs.getString("TITLE"));
				dto.setContent(rs.getString("CONTENT"));
				dto.setStartDate(rs.getDate("STARTDATE"));
				dto.setDeadLine(rs.getDate("DEADLINE"));
				dto.setWrittenDate(rs.getDate("WRITTENDATE"));
				dto.setMatchingCounts(rs.getInt("MATCHINGCOUNTS"));
				dto.setWriterId(rs.getInt("WRITERID"));
				dto.setTalentCategoryName(rs.getString("TALENTCNAME"));
				dto.setPostType(rs.getInt("POSTTYPE"));
				
				list.add(dto);
			}
			return list;
		} catch (Exception ex) {
			ex.printStackTrace();
		} finally {
			jdbcUtil.close();
		} return null;
	}
		
	public List<TalentDTO> getTalentListByOptions(String title, String reSearch, String[] categories, int price, Date startDate, Date deadLine) throws Exception {
		String resultQuery = query;
		
		if (reSearch==null || categories==null || startDate==null || deadLine==null) { //상세검색 옵션이 없으면 제목(keyword)만으로 검색한 결과 반환
			return getTalentListByTitle(title);
		}
			
		// 제목 옵션
		String titleQuery = "FROM TALENT WHERE (TITLE LIKE '%" + title + "%" + reSearch + "%' OR TITLE LIKE '%" + reSearch + "%" + title + "%') AND ";			
		resultQuery += titleQuery;
		
		// 카테고리 옵션
		String categoryQuery = "(";
		int i;		
		for (i = 0; i < categories.length - 1; i++) {
			categoryQuery += "TALENTCNAME='" + categories[i] + "' OR ";
		}
		categoryQuery += "TALENTCNAME='" + categories[i] + "') ";
		resultQuery += categoryQuery;

//		// 가격 옵션
//		String priceQuery = " AND PRICE <= " + price;
//		resultQuery += priceQuery;
//		
		// 날짜 옵션
		if (startDate == null) { // 날짜 상세 설정이 없을 경우
			startDate = format1.parse("2000-01-01");
		}
		if (deadLine == null) {
			deadLine = format1.parse("2030-12-31");		
		}
		
		String dateQuery = "AND WRITTENDATE BETWEEN TO_DATE('" + startDate + "', 'YYYY-MM-DD') AND TO_DATE('" + deadLine + "', 'YYYY-MM-DD')";
		resultQuery += dateQuery;
	
		jdbcUtil.setSql(resultQuery);
		
		try {
			ResultSet rs = jdbcUtil.executeQuery();
			List<TalentDTO> list = new ArrayList<TalentDTO>();
						
			while (rs.next()) {
				TalentDTO dto = new TalentDTO();
				dto.setTalentId(rs.getInt("TALENTID"));
				dto.setTitle(rs.getString("TITLE"));
				dto.setContent(rs.getString("CONTENT"));
				dto.setStartDate(rs.getDate("STARTDATE"));
				dto.setDeadLine(rs.getDate("DEADLINE"));
				dto.setWrittenDate(rs.getDate("WRITTENDATE"));
				dto.setMatchingCounts(rs.getInt("MATCHINGCOUNTS"));
				dto.setWriterId(rs.getInt("WRITERID"));
				dto.setTalentCategoryName(rs.getString("TALENTCNAME"));
				dto.setPostType(rs.getInt("POSTTYPE"));
				
				list.add(dto);
			}
			return list;
		} catch (Exception ex) {
			ex.printStackTrace();
		} finally {
			jdbcUtil.close();
		} return null;
	}
	
	public TalentDTO getTalentView(int talentId) {
		String getTalentQuery = query + "FROM TALENT WHERE TALENTID = ? ";
		
		List<TalentDTO> list = new ArrayList<TalentDTO>();
		
		Object[] param = new Object[] { talentId };
		
		jdbcUtil.setSql(getTalentQuery);
		jdbcUtil.setParameters(param);
		
		try {
			ResultSet rs = jdbcUtil.executeQuery();
			TalentDTO dto = null;
			
			if (rs.next()) {
				dto = new TalentDTO();
				dto.setTalentId(rs.getInt("TALENTID"));
				dto.setTitle(rs.getString("TITLE"));
				dto.setContent(rs.getString("CONTENT"));
				dto.setStartDate(rs.getDate("STARTDATE"));
				dto.setDeadLine(rs.getDate("DEADLINE"));
				dto.setWrittenDate(rs.getDate("WRITTENDATE"));
				dto.setMatchingCounts(rs.getInt("MATCHINGCOUNTS"));
				dto.setWriterId(rs.getInt("WRITERID"));
				dto.setTalentCategoryName(rs.getString("TALENTCNAME"));
				dto.setPostType(rs.getInt("POSTTYPE"));
				
				list.add(dto);
			}
			return dto;
		} catch (Exception ex) {
			ex.printStackTrace();
		} finally {
			jdbcUtil.close();
		} return null;
	}
	
	public int insertTalent(TalentDTO t) {
		int result = 0;
		int generatedKey = 0;
		String insertQuery = "INSERT INTO TALENT (TALENTID, TITLE, CONTENT, STARTDATE, DEADLINE, " +
				"WRITTENDATE, MATCHINGCOUNTS, WRITERID, TALENTCNAME, POSTTYPE) " +
				"VALUES (talent_seq.nextval, ?, ?, ?, ?, ?, ?, ?, ?, ?) ";	
		
		Object[] param = new Object[] { t.getTitle(), t.getContent(), new java.sql.Date(t.getStartDate().getTime()),
							new java.sql.Date(t.getDeadLine().getTime()),
							new java.sql.Date(t.getWrittenDate().getTime()),
							t.getMatchingCounts(),
							t.getWriterId(), t.getTalentCategoryName(),
							t.getPostType() };
		jdbcUtil.setSql(insertQuery);
		jdbcUtil.setParameters(param);
		
		String key[]={"TALENTID"};
		
		try {				
			result = jdbcUtil.executeUpdate(key);		// insert 문 실행
			 ResultSet rs = jdbcUtil.getGeneratedKeys(); 
			 
			 if(rs.next()) {

			       generatedKey = rs.getInt(1); 
			 }
			System.out.println(t.getTitle() + " 삽입 완료.");
		} catch (SQLException ex) {
			System.out.println("입력오류 발생!!!");
			ex.printStackTrace();
			if (ex.getErrorCode() == 1)
				System.out.println("동일한 정보가 이미 존재합니다."); 
		} catch (Exception ex) {
			jdbcUtil.rollback();
			ex.printStackTrace();
		} finally {		
			jdbcUtil.commit();
			jdbcUtil.close();		// ResultSet, PreparedStatement, Connection 반환
		}		
		return generatedKey;
	}
	

	public int updateTalent(TalentDTO t) {
		int result = -1;
		String updateQuery = "UPDATE TALENT SET ";
		int index = 0;
		Object[] tempParam = new Object[10];		// update 문에 사용할 매개변수를 저장할 수 있는 임시 배열
		
		if (t.getTitle() != null) {		
			updateQuery += "TITLE = ?, ";		
			tempParam[index++] = t.getTitle();	
		}
		if (t.getContent() != null) {		
			updateQuery += "CONTENT = ?, ";		
			tempParam[index++] = t.getContent();	
		}
		if (t.getStartDate() != null) {		
			updateQuery += "STARTDATE = ?, ";		
			tempParam[index++] = new java.sql.Date(t.getStartDate().getTime());
		}
		if (t.getDeadLine() != null) {		
			updateQuery += "DEADLINE = ?, ";	
			tempParam[index++] = new java.sql.Date(t.getDeadLine().getTime());
		}
		if (t.getWrittenDate() != null) {		
			updateQuery += "WRITTENDATE = ?, ";	
			tempParam[index++] = new java.sql.Date(t.getWrittenDate().getTime());
		}
		if (t.getMatchingCounts() != -1) {		
			updateQuery += "MATCHINGCOUNTS = ?, ";	
			tempParam[index++] = t.getMatchingCounts();	
		}
		if (t.getWriterId() != -1) {		
			updateQuery += "WRITERID = ?, ";	
			tempParam[index++] = t.getWriterId();	
		}
		if (t.getTalentCategoryName() != null) {		
			updateQuery += "TALENTCNAME = ?, ";	
			tempParam[index++] = t.getTalentCategoryName();	
		}
		if (t.getPostType() != -1) {		
			updateQuery += "POSTTYPE = ?, ";
			tempParam[index++] = t.getPostType();	
		}
	
		
		updateQuery += "WHERE TALENTID = ? ";		// update 문에 조건 지정
		updateQuery = updateQuery.replace(", WHERE", " WHERE");		// update 문의 where 절 앞에 있을 수 있는 , 제거
		
		tempParam[index++] = t.getTalentId();		// 찾을 조건에 해당하는 학번에 대한 매개변수 추가
		
		Object[] newParam = new Object[index];
		for (int i=0; i < newParam.length; i++)		// 매개변수의 개수만큼의 크기를 갖는 배열을 생성하고 매개변수 값 복사
			newParam[i] = tempParam[i];
		
		jdbcUtil.setSql(updateQuery);			// JDBCUtil에 update 문 설정
		jdbcUtil.setParameters(newParam);		// JDBCUtil 에 매개변수 설정
		
		try {
			result = jdbcUtil.executeUpdate();		// update 문 실행
			return result;			// update 에 의해 반영된 레코드 수 반환
		} catch (SQLException ex) {
			System.out.println("입력오류 발생!!!");
			ex.printStackTrace();
		}catch (Exception ex) {
			jdbcUtil.rollback();
			ex.printStackTrace();
		}
		finally {
			jdbcUtil.commit();
			jdbcUtil.close();		// ResultSet, PreparedStatement, Connection 반환
		}		
		return result;
	}
	
	public int deleteTalent(int talentId) {
		String deleteQuery = "DELETE FROM TALENT WHERE TALENTID = ?";
		
		jdbcUtil.setSql(deleteQuery);			// JDBCUtil 에 query 문 설정
		Object[] param = new Object[] {talentId};
		jdbcUtil.setParameters(param);			// JDBCUtil 에 매개변수 설정
		
		try {
			int result = jdbcUtil.executeUpdate();		// delete 문 실행
			return result;						// delete 에 의해 반영된 레코드 수 반환
		} catch (Exception ex) {
			jdbcUtil.rollback();
			ex.printStackTrace();		
		} finally {
			jdbcUtil.commit();
			jdbcUtil.close();		// ResultSet, PreparedStatement, Connection 반환
		}
		return 0;
	}
}
