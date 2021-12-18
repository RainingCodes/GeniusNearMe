package model.mapper;
import model.Comment;

public interface CommentMapper {
	
	Comment getCommentByUserId(int userId);
	Comment getCommentByCommentId(int commentId);
	public int insertComment(Comment comment);
	public int updateComment(Comment comment);
	public int deleteComment(int commentId);	
}
