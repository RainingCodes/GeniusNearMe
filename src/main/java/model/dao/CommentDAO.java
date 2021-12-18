package model.dao;
import java.io.IOException;
import java.io.InputStream;
import java.util.List;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import model.Comment;
import model.mapper.CommentMapper;

public class CommentDAO {
	
	private SqlSessionFactory sqlSessionFactory;
	
	public CommentDAO() {
		String resource = "mybatis-config.xml";
		InputStream inputStream;
		try {
			inputStream = Resources.getResourceAsStream(resource);
		} catch (IOException e) {
			throw new IllegalArgumentException(e);
		}
		sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);

	}
	
	public List<Comment> getCommentListByTalentId(int talentId){
		SqlSession sqlSession = sqlSessionFactory.openSession();
		try {
			return sqlSession.getMapper(CommentMapper.class).getCommentListByTalenttId(talentId);
		}finally {
			sqlSession.close();
		}
	}
	
	public List<Comment> getCommentListByUserId(int userId) {
		SqlSession sqlSession = sqlSessionFactory.openSession();
		try {
			return (List<Comment>)sqlSession.getMapper(CommentMapper.class).getCommentListByUserId(userId);
		}finally {
			sqlSession.close();
		}
	}
	
	public Integer insertComment(Comment comment) {
		SqlSession sqlSession = sqlSessionFactory.openSession();
		try {
			int result = sqlSession.getMapper(CommentMapper.class).insertComment(comment);
			if(result > 0) {
				sqlSession.commit();
			}
			return result;
		}finally {
			sqlSession.close();
		}
	}
	
	public int updateComment(Comment comment) {
		SqlSession sqlSession = sqlSessionFactory.openSession();
		try {
			int result = sqlSession.getMapper(CommentMapper.class).updateComment(comment);
			if(result > 0) {
				sqlSession.commit();
			}
			return result;
		}finally {
			sqlSession.close();
		}
	}
			
	public int deleteComment(int commentId) {
		SqlSession sqlSession = sqlSessionFactory.openSession();
		try {
			int result = sqlSession.getMapper(CommentMapper.class).deleteComment(commentId);
			if(result > 0) {
				sqlSession.commit();
			}
			return result;
		}finally {
			sqlSession.close();
		}
	}
}
