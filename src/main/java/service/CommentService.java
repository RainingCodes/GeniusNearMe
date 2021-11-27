package service;

import java.util.List;

import service.dto.CommentDTO;

public interface CommentService {
	public List<CommentDTO> CommentListByTalentId(int talentId);
	public List<CommentDTO> CommentListByUserId(int userId);
	public int insertComment(CommentDTO commentDTO);
	public int deleteComment(int commentId);
}
