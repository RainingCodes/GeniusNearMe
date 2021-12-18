package model;

import java.io.Serializable;

@SuppressWarnings("serial")
public class Comment implements Serializable{
	private int commentId;
	private int talentId;
	private String content;
	private int writerId;

	public Comment() {
		commentId = -1;
		talentId = -1;
		content = null;
		writerId = -1;
	}
	
	public Comment(int talentId, String content, int writerId) {
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
