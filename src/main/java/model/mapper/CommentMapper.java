package model.mapper;
import java.util.List;
import model.Comment;

public interface CommentMapper {
	
	List<Comment> getCommentListByUserId(int userId);
	List<Comment> getCommentListByTalentId(int talentId);	
	public int insertComment(Comment comment);
	public int updateComment(Comment comment);
	public int deleteComment(int commentId);
}
