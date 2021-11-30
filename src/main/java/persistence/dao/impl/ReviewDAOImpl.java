package persistence.dao.impl;

import java.sql.ResultSet;
import java.text.SimpleDateFormat;
import java.util.Date;
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
		}
		};
	public int updateReview(ReviewDTO reviewDto);//리뷰 수정
	public int deleteReview(int reviewId);//리뷰 삭제
	public List<ReviewDTO> getReviewListByWriter(int userId);//내가 작성한 리뷰 목록
	public List<ReviewDTO> getReviewListByTalent(int talentId);//게시글에 따른 리뷰 리스트
}
