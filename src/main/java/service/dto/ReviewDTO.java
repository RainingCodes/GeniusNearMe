package service.dto;

import java.util.Date;

public class ReviewDTO {
	private int reviewId = -1;
	private Date writtenDate = null;
	private int likes = -1;
	private int writerId = -1;
	private int talentId = -1;
	private String reviewContent = null;
	private int matchingId = -1;
	
	public ReviewDTO() {
		
	}
	
	public ReviewDTO( Date writtenDate, int likes, int writerId, int talentId, String reviewContent, int matchingId) {
		super();
		this.writtenDate = writtenDate;
		this.likes = likes;
		this.writerId = writerId;
		this.talentId = talentId;
		this.reviewContent = reviewContent;
		this.matchingId = matchingId;
	}
	
	public ReviewDTO(int reviewId, Date writtenDate, int likes, int writerId, int talentId, String reviewContent, int matchingId) {
		super();
		this.reviewId = reviewId;
		this.writtenDate = writtenDate;
		this.likes = likes;
		this.writerId = writerId;
		this.talentId = talentId;
		this.reviewContent = reviewContent;
		this.matchingId = matchingId;
	}


	public int getReviewId() {
		return reviewId;
	}

	public void setReviewId(int reviewId) {
		this.reviewId = reviewId;
	}

	public Date getWrittenDate() {
		return writtenDate;
	}

	public void setWrittenDate(Date writtenDate) {
		this.writtenDate = writtenDate;
	}

	public int getLikes() {
		return likes;
	}

	public void setLikes(int likes) {
		this.likes = likes;
	}

	public int getWriterId() {
		return writerId;
	}

	public void setWriterId(int writerId) {
		this.writerId = writerId;
	}

	public int getTalentId() {
		return talentId;
	}

	public void setTalentId(int talentId) {
		this.talentId = talentId;
	}

	public String getReviewContent() {
		return reviewContent;
	}

	public void setReviewContent(String reviewContent) {
		this.reviewContent = reviewContent;
	}

	public int getMatchingId() {
		return matchingId;
	}

	public void setMatchingId(int matchingId) {
		this.matchingId = matchingId;
	}

}
