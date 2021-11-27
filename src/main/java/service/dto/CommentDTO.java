package service.dto;

public class CommentDTO {
	private int commentId;
	private int talentId;
	private String content;
	private int writerId;
	
	public int getCommentId() {
		return commentId;
	}
	public void setCommentId(int commentId) {
		this.commentId = commentId;
	}
	public int getTalentId() {
		return talentId;
	}
	public void setTalentId(int talentId) {
		this.talentId = talentId;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public int getWriterId() {
		return writerId;
	}
	public void setWriterId(int writerId) {
		this.writerId = writerId;
	}
	
	
}
