package persistence.dao;

import java.util.List;
import service.dto.CommentDTO;

public interface CommentDAO {
		
	//탤런트에 덧글 불러오기 위한 list 반환 메소드
	public List<CommentDTO> getCommentByTalentId(int talentId);
	
	//내가 작성한 덧글 list 반환 메소드
	public List<CommentDTO> getCommentByUserId(int userId);

	//insert By commentDTO
	public int insertComment(CommentDTO commentDTO);

	//delete By commentId
	public int deleteComment(int commentId);

}