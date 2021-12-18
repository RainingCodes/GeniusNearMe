package model;

public class Comment {
	private int commentId;
	private int talentId;
	private String content;
	private int writerId;
	
	public Comment() {
		this.commentId = -1;
		this.talentId = -1;
		this.content = null;
		this.writerId = -1;
	}
	
	public Comment(int commentId, int talentId, String content, int writerId) {
		super();
		this.commentId = commentId;
		this.talentId = talentId;
		this.content = content;
		this.writerId = writerId;
	}
	
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
