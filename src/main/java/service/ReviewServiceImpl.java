package service;

import java.util.List;

import persistence.DAOFactory;
import persistence.dao.ReviewDAO;
import service.dto.ReviewDTO;

public class ReviewServiceImpl implements ReviewService{
	
	private ReviewDAO dao = null;
	
	public ReviewServiceImpl() {
		DAOFactory factory = new DAOFactory();
		dao = factory.getReviewDAO();
	}

	@Override
	public int insertReview(ReviewDTO reviewDto) {
		return dao.insertReview(reviewDto);
	}

	@Override
	public int updateReviewLikes(ReviewDTO reviewDto) {
		return dao.updateReviewLikes(reviewDto);
	}

	@Override
	public int updateReviewContent(ReviewDTO reviewDto) {
		return dao.updateReviewContent(reviewDto);
	}

	@Override
	public int deleteReview(int reviewId) {
		return dao.deleteReview(reviewId);
	}

	@Override
	public List<ReviewDTO> getReviewListByWriter(int userId) {
		return dao.getReviewListByWriter(userId);
	}

	@Override
	public List<ReviewDTO> getReviewListByTalent(int talentId) {
		return dao.getReviewListByTalent(talentId);
	}

	@Override
	public int isAlreadyWritten(int matchingId, int writerId) {
		return dao.isAlreadyWritten(matchingId, writerId);
	}

}
