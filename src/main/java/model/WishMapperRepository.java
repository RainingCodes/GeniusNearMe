package model;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import model.mapper.WishMapper;

public class WishMapperRepository {
	private SqlSessionFactory sqlSessionFactory;
	
	public WishMapperRepository() {
		String resource = "mybatis-config.xml";
		InputStream inputStream;
		try {
			inputStream = Resources.getResourceAsStream(resource);
		} catch (IOException e) {
			throw new IllegalArgumentException(e);
		}
		sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
	}
	
	public Wish selectWish(Wish wish) {
		SqlSession sqlSession = sqlSessionFactory.openSession();
		try {
			return sqlSession.getMapper(WishMapper.class).selectWish(wish);			
		} finally {
			sqlSession.close();
		}
	}
	public List<Wish> selectAllWishListByUserId(int userId){
		SqlSession sqlSession = sqlSessionFactory.openSession();
		try {
			return sqlSession.getMapper(WishMapper.class).selectAllWishListByUserId(userId);			
		} finally {
			sqlSession.close();
		}
	}
	
	public int insertWish(Wish wish) {
		SqlSession sqlSession = sqlSessionFactory.openSession();
		try {
			int result = sqlSession.getMapper(WishMapper.class).insertWish(wish);
			if (result > 0) {
				sqlSession.commit();
			} 
			return result;
		} finally {
			sqlSession.close();
		}
	}
	
	public int deleteWish(Wish wish) {
		SqlSession sqlSession = sqlSessionFactory.openSession();
		try {
			int result = sqlSession.getMapper(WishMapper.class).deleteWish(wish);
			if (result > 0) {
				sqlSession.commit();
			} 
			return result;	
		} finally {
			sqlSession.close();
		}
	}
}
