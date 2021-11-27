package service.dto;

public class CommentDTO {
	private int commentId;
	private int talentId;
	private String content;
	private int writerId;
	
	public CommentDTO() {
		commentId = -1;
		talentId = -1;
		content = null;
		writerId = -1;
	}
	public CommentDTO(int talentId, String content, int writerId) {
		super();
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
	@Override
	public String toString() {
		return "CommentDTO [commentId=" + commentId + ", talentId=" + talentId + ", content=" + content + ", writerId="
				+ writerId + "]";
	}
	
	
}
