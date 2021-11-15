package persistence.dao.impl;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import persistence.dao.TalentDAO;
import persistence.util.JDBCUtil;
import service.dto.TalentDTO;

public class TalentDAOImpl implements TalentDAO  {
	private JDBCUtil jdbcUtil = null;
	
	private static String query = "SELECT TALENTID, TITLE, CONTENT, STARTDATE, DEADLINE, "
			+ "WRITTENDATE, MATCHINGCOUNTS, WRITERID, TALENTCATEGORYNAME, POSTTYPE, PRICE ";

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
				dto.setTalentCategoryName(rs.getString("TALENTCATEGORYNAME"));
				dto.setPostType(rs.getInt("POSTTYPE"));
				dto.setPrice(rs.getInt("PRICE"));
			}
			return list;
		} catch (Exception ex) {
			ex.printStackTrace();
		} finally {
			jdbcUtil.close();
		} return null;
	}
	
	public List<TalentDTO> getTalentListByCategory(String[] category) {
		String getByCategoryQuery = query + "FROM TALENT WHERE TALENTCATEGORYNAME = ? ";
		
		Object[] param = new Object[] { category };
		
		jdbcUtil.setSql(getByCategoryQuery);
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
				dto.setTalentCategoryName(rs.getString("TALENTCATEGORYNAME"));
				dto.setPostType(rs.getInt("POSTTYPE"));
				dto.setPrice(rs.getInt("PRICE"));
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
				dto.setTalentCategoryName(rs.getString("TALENTCATEGORYNAME"));
				dto.setPostType(rs.getInt("POSTTYPE"));
				dto.setPrice(rs.getInt("PRICE"));
			}
			return list;
		} catch (Exception ex) {
			ex.printStackTrace();
		} finally {
			jdbcUtil.close();
		} return null;
	}
	
	public List<TalentDTO> getTalentListBypriceRange(int high) {
		String getByPriceQuery = query + "FROM TALENT WHERE PRICE <= ? ";
		
		Object[] param = new Object[] { high };
		
		jdbcUtil.setSql(getByPriceQuery);
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
				dto.setTalentCategoryName(rs.getString("TALENTCATEGORYNAME"));
				dto.setPostType(rs.getInt("POSTTYPE"));
				dto.setPrice(rs.getInt("PRICE"));
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
				dto.setTalentCategoryName(rs.getString("TALENTCATEGORYNAME"));
				dto.setPostType(rs.getInt("POSTTYPE"));
				dto.setPrice(rs.getInt("PRICE"));
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
		String insertQuery = "INSERT INTO TALENT (TALENTID, TITLE, CONTENT, STARTDATE, DEADLINE, " +
				"WRITTENDATE, MATCHINGCOUNTS, WRITERID, TALENTCATEGORYNAME, POSTTYPE, PRICE) " +
				"VALUES (talent_seq.nextval, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?) ";
		
		//카테고리는 무조건 정해진 내용으로만 전달이 될거니까 (왜냐면 jsp에서 그렇게 구성하겠지?... 굳이 뭐 제약조건 안둠)
		//그리고 writerId는 지금 글쓰고 있는 user꺼 무조건 전달되니까... 오류 안뜨겠지?.......
		
		Object[] param = new Object[] { t.getTitle(), t.getContent(), t.getStartDate(), t.getDeadLine(), 
				t.getWrittenDate(), t.getMatchingCounts(), t.getWriterId(), t.getTalentCategoryName(), t.getPostType(), t.getPrice() };
		jdbcUtil.setSql(insertQuery);
		jdbcUtil.setParameters(param);
		
		try {				
			result = jdbcUtil.executeUpdate();		// insert 문 실행
			System.out.println(t.getTitle() + " 삽입 완료.");
		} catch (SQLException ex) {
			System.out.println("입력오류 발생!!!");
			if (ex.getErrorCode() == 1)
				System.out.println("동일한 정보가 이미 존재합니다."); 
		} catch (Exception ex) {
			jdbcUtil.rollback();
			ex.printStackTrace();
		} finally {		
			jdbcUtil.commit();
			jdbcUtil.close();		// ResultSet, PreparedStatement, Connection 반환
		}		
		return result;
	}
	

	public int updateTalent(TalentDTO t) {
		
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
			tempParam[index++] = t.getStartDate();		
		}
		if (t.getDeadLine() != null) {		
			updateQuery += "DEADLINE = ?, ";	
			tempParam[index++] = t.getDeadLine();	
		}
		if (t.getWrittenDate() != null) {		
			updateQuery += "WRITTENDATE = ?, ";	
			tempParam[index++] = t.getWrittenDate();	
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
			updateQuery += "TALENTCATEGORYNAME = ?, ";	
			tempParam[index++] = t.getTalentCategoryName();	
		}
		if (t.getPostType() != -1) {		
			updateQuery += "POSTTYPE = ?, ";	
			tempParam[index++] = t.getPostType();	
		}
		if (t.getPostType() != -1) {		
			updateQuery += "PRICE = ? ";	
			tempParam[index++] = t.getPrice();	
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
			int result = jdbcUtil.executeUpdate();		// update 문 실행
			return result;			// update 에 의해 반영된 레코드 수 반환
		} catch (Exception ex) {
			jdbcUtil.rollback();
			ex.printStackTrace();
		}
		finally {
			jdbcUtil.commit();
			jdbcUtil.close();		// ResultSet, PreparedStatement, Connection 반환
		}		
		return 0;
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