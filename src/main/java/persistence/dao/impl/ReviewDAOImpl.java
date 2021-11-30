package persistence.dao.impl;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import persistence.dao.ReviewDAO;
import persistence.util.JDBCUtil;
import service.dto.ReviewDTO;

public class ReviewDAOImpl implements ReviewDAO{
	
	private JDBCUtil jdbcUtil = null;
	
	private static String query = "SELECT REVIEWID, WRITTENDATE, LIKES, WRITERID, TALENTID, REVIEWCONTENT ";

	public ReviewDAOImpl() {
		jdbcUtil = new JDBCUtil();
	}
	
	public int insertReview(ReviewDTO reviewDto) {
		int result = -1;
		int generatedKey = -1;
		
		String insertQuery = "INSERT INTO REVIEW (REVIEWID, WRITTENDATE,"
				+ " LIKES, WRITERID, TALENTID, REVIEWCONTENT) "
				+ "VALUES (review_seq.nextval, ?, ?, ?, ?, ?) ";
		
		Object[] param = new Object[] { 
				new java.sql.Date(reviewDto.getWrittenDate().getTime()),
				reviewDto.getLikes(), reviewDto.getWriterId(),
				reviewDto.getTalentId(), reviewDto.getReviewContent()
				};
		jdbcUtil.setSql(insertQuery);
		jdbcUtil.setParameters(param);
		
		String key[]= {"REVIEWID"};
		
		try {
			result = jdbcUtil.executeUpdate(key);
			ResultSet rs = jdbcUtil.getGeneratedKeys();
			
			if(rs.next()) {
				generatedKey = rs.getInt(1);
			}
			System.out.println(reviewDto.getReviewContent() + "삽입 완료");
		}catch(SQLException ex) {
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
	public int updateReviewLikes(ReviewDTO r) {
		int result = -1;
		String updateQuery = "UPDATE REVIEW SET LIKES = ? WHERE REVIEWID = ? ";
		
		System.out.println(updateQuery);
		
		Object[] param = new Object[] {
				r.getLikes()+1,
				r.getReviewId()
			};
		
		jdbcUtil.setSql(updateQuery);
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
	
	public int updateReviewContent(ReviewDTO reviewDto) {
		int result = -1;
		String updateQuery = "UPDATE REVIEW SET REVIEWCONTENT = ? WHERE REVIEWID = ? ";
		
		System.out.println(updateQuery);
		
		Object[] param = new Object[] {
				reviewDto.getReviewContent(),
				reviewDto.getReviewId()
			};
		
		jdbcUtil.setSql(updateQuery);
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
	public int deleteReview(int reviewId) {
		int result = 0;
		String deleteQuery = "DELETE FROM REVIEW WHERE REVIEWID = ? ";
		
		jdbcUtil.setSql(deleteQuery);
		Object[] param = new Object[] { reviewId };
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
	public List<ReviewDTO> getReviewListByWriter(int userId){
		String searchQuery = query + "FROM REVIEW WHERE WRITERID = ? ";
		
		Object[] param = new Object[] {userId};
		jdbcUtil.setSql(searchQuery);
		jdbcUtil.setParameters(param);
		
		try {
			ResultSet rs = jdbcUtil.executeQuery();
			List<ReviewDTO> list = new ArrayList<ReviewDTO>();
			
			while(rs.next()) {
				ReviewDTO dto = new ReviewDTO();
				dto.setReviewId(rs.getInt("REVIEWID"));
				dto.setWrittenDate(rs.getDate("WRITTENDATE"));
				dto.setLikes(rs.getInt("LIKES"));
				dto.setWriterId(rs.getInt("WRITERID"));
				dto.setTalentId(rs.getInt("TALENTID"));
				dto.setReviewContent(rs.getString("REVIEWCONTENT"));

				list.add(dto);
			}
			return list;
		}catch(Exception ex) {
			ex.printStackTrace();
		}finally {
			jdbcUtil.close();
		}return null;
	}
	public List<ReviewDTO> getReviewListByTalent(int talentId){
String searchQuery = query + "FROM REVIEW WHERE TALENTID = ? ";
		
		Object[] param = new Object[] {talentId};
		jdbcUtil.setSql(searchQuery);
		jdbcUtil.setParameters(param);
		
		try {
			ResultSet rs = jdbcUtil.executeQuery();
			List<ReviewDTO> list = new ArrayList<ReviewDTO>();
			
			while(rs.next()) {
				ReviewDTO dto = new ReviewDTO();
				dto.setReviewId(rs.getInt("REVIEWID"));
				dto.setWrittenDate(rs.getDate("WRITTENDATE"));
				dto.setLikes(rs.getInt("LIKES"));
				dto.setWriterId(rs.getInt("WRITERID"));
				dto.setTalentId(rs.getInt("TALENTID"));
				dto.setReviewContent(rs.getString("REVIEWCONTENT"));

				list.add(dto);
			}
			return list;
		}catch(Exception ex) {
			ex.printStackTrace();
		}finally {
			jdbcUtil.close();
		}return null;
	}
}
