package service;

import java.util.List;

import model.Comment;
import model.dao.CommentDAO;

public class CommentServiceImpl implements CommentService {
	private CommentDAO dao = null;
	
	public CommentServiceImpl() {
		dao = new CommentDAO();
	}

	@Override
	public List<Comment> getCommentListByTalentId(int talentId) {
		return dao.getCommentListByTalentId(talentId);
	}

	@Override
	public List<Comment> getCommentListByUserId(int userId) {
		return dao.getCommentListByUserId(userId);
	}

	@Override
	public int insertComment(Comment comment) {
		return dao.insertComment(comment);
	}

	@Override
	public int deleteComment(int commentId) {
		return dao.deleteComment(commentId);
	}


	
}
