package persistence.dao;

import java.util.List;

import service.dto.ReviewDTO;

public interface ReviewDAO {
	public int insertReview(ReviewDTO reviewDto); //리뷰 추가
	public int updateReview(ReviewDTO reviewDto);//리뷰 수정
	public int deleteReview(int reviewId);//리뷰 삭제
	public List<ReviewDTO> getReviewListByWriter(int userId);//내가 작성한 리뷰 목록
	public List<ReviewDTO> getReviewListByTalent(int talentId);//게시글에 따른 리뷰 리스트

}
