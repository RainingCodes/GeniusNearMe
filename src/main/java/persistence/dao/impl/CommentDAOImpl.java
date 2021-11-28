package persistence.dao.impl;

import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import persistence.dao.CommentDAO;
import persistence.util.JDBCUtil;
import service.dto.CommentDTO;

public class CommentDAOImpl implements CommentDAO  {
	private JDBCUtil jdbcUtil = null;
	private static String query = "SELECT COMMENTID, "+
			"TALENTID, "+
			"CONTENT, "+
			"WRITERID ";
	
	public CommentDAOImpl() {
		jdbcUtil = new JDBCUtil();
	}
	
	//탤런트에 덧글 불러오기 위한 list 반환 메소드
	public List<CommentDTO> getCommentByTalentId(int talentId) {
		String searchQuery = query + "FROM COMMENTARY "+
				"WHERE TALENTID = ? ";

		Object[] param = new Object[] { talentId };
		jdbcUtil.setSql(searchQuery);
		jdbcUtil.setParameters(param);
		
		try {
			ResultSet rs = jdbcUtil.executeQuery();
			List<CommentDTO> list = new ArrayList<CommentDTO>();
			
			while(rs.next()) {
				CommentDTO dto = new CommentDTO();
				dto.setCommentId(rs.getInt("COMMENTID"));
				dto.setTalentId(rs.getInt("TALENTID"));
				dto.setContent(rs.getString("CONTENT"));
				dto.setWriterId(rs.getInt("WRITERID"));
				
				list.add(dto);
			}
			return list;
		}catch(Exception ex) {
			ex.printStackTrace();
		}finally {
			jdbcUtil.close();
		}return null;
	}
		
	//내가 작성한 덧글 list 반환 메소드
	public List<CommentDTO> getCommentByUserId(int userId) {
		String searchQuery = query + "FROM COMMENTARY "+
				"WHERE WRITERID = ? ";

		Object[] param = new Object[] { userId };
		jdbcUtil.setSql(searchQuery);
		jdbcUtil.setParameters(param);
		
		try {
			ResultSet rs = jdbcUtil.executeQuery();
			List<CommentDTO> list = new ArrayList<CommentDTO>();
			
			while(rs.next()) {
				CommentDTO dto = new CommentDTO();
				dto.setCommentId(rs.getInt("COMMENTID"));
				dto.setTalentId(rs.getInt("TALENTID"));
				dto.setContent(rs.getString("CONTENT"));
				dto.setWriterId(rs.getInt("WRITERID"));
				
				list.add(dto);
			}
			return list;
		}catch(Exception ex) {
			ex.printStackTrace();
		}finally {
			jdbcUtil.close();
		}return null;
	}

	//insert By commentDTO
	public int insertComment(CommentDTO commentDTO) {
		int result = 0;
		String insertQuery = "INSERT INTO COMMENTARY (COMMENTID, TALENTID, "
				+ "CONTENT, WRITERID) "
				+ "VALUES (comment_seq.nextval, ?, ?, ?) ";
		
		Object[] param = new Object[] { commentDTO.getTalentId(), commentDTO.getContent(), commentDTO.getWriterId()};
		
		jdbcUtil.setSql(insertQuery);
		jdbcUtil.setParameters(param);
		
		try {
			result = jdbcUtil.executeUpdate();
		}catch(Exception ex) {
			jdbcUtil.rollback();
			ex.printStackTrace();
		}finally {
			jdbcUtil.commit();
			jdbcUtil.close();
		}
		return result;	
	}
	
	//delete By commentId
	public int deleteComment(int commentId) {
		int result = 0;
		String DeleteQuery = "DELETE FROM COMMENTARY WHERE COMMENTID = ? ";
		
		Object[] param = new Object[] {commentId};
		
		jdbcUtil.setSqlAndParameters(DeleteQuery, param);
		
		try {
			result = jdbcUtil.executeUpdate();
			return result;
		}catch(Exception ex) {
			ex.printStackTrace();
		}finally {
			jdbcUtil.commit();
			jdbcUtil.close();
		}
		
		return result;
	}
}