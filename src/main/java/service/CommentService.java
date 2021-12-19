package service;

import java.util.List;
import model.Comment;

public interface CommentService {
	public List<Comment> getCommentListByTalentId(int talentId);
	public List<Comment> getCommentListByUserId(int userId);
	public int insertComment(Comment commentDTO);
	public int deleteComment(int commentId);
}
