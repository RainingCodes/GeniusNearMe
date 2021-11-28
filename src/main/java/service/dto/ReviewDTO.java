package service.dto;

import java.util.Date;

public class ReviewDTO {
	private int reviewId = -1;
	private Date writtenDate = null;
	private int likes = -1;
	private int writerId = -1;
	private int talentId = -1;
	private String reviewContent = null;
	
	public ReviewDTO() {
		
	}
	
	public ReviewDTO(int reviewId, Date writtenDate, int likes, int writerId, int talentId, String reviewContent) {
		super();
		this.reviewId = reviewId;
		this.writtenDate = writtenDate;
		this.likes = likes;
		this.writerId = writerId;
		this.talentId = talentId;
		this.reviewContent = reviewContent;
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

}
