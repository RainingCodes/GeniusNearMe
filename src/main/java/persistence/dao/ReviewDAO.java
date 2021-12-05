package persistence.dao;

import java.util.List;

import service.dto.ReviewDTO;

public interface ReviewDAO {
	public int insertReview(ReviewDTO reviewDto); //리뷰 추가
	public int updateReviewLikes(ReviewDTO reviewDto);//리뷰 하트 +1
	public int updateReviewContent(ReviewDTO reviewDto);//리뷰 내용 수정
	public int deleteReview(int reviewId);//리뷰 삭제
	public List<ReviewDTO> getReviewListByWriter(int userId);//내가 작성한 리뷰 목록
	public List<ReviewDTO> getReviewListByTalent(int talentId);//게시글에 따른 리뷰 리스트
	public int isAlreadyWritten(int matchingId, int writerId); //작성된 리뷰가 있는지 검사 있으면 1 없으면 0

}
