package service;

import java.util.List;

import model.Comment;

public interface CommentService {
	public List<Comment> CommentListByTalentId(int talentId);
	public List<Comment> CommentListByUserId(int userId);
	public int insertComment(Comment commentDTO);
	public int deleteComment(int commentId);
}
