package service;

import java.util.List;

import persistence.DAOFactory;
import persistence.dao.CommentDAO;
import service.dto.CommentDTO;

public class CommentServiceImpl implements CommentService {
private CommentDAO dao = null;
	
	public CommentServiceImpl() {
		DAOFactory factory = new DAOFactory();
		dao = factory.getCommentDAO();
	}
	
	public List<CommentDTO> CommentListByTalentId(int talentId) {
		return dao.getCommentByTalentId(talentId);
	}
	public List<CommentDTO> CommentListByUserId(int userId) {
		return dao.getCommentByUserId(userId);
	}
	public int insertComment(CommentDTO commentDTO) {
		return dao.insertComment(commentDTO);
	}
	public int deleteComment(int commentId) {
		return dao.deleteComment(commentId);
	}
}
