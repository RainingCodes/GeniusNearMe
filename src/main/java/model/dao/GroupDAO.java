package model.dao;

import java.io.IOException;
import java.io.InputStream;
import model.Group;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;


public class GroupDAO {
	private SqlSessionFactory sqlSessionFactory;
	private final String namespace = "mapper.GroupMapper";
	public GroupDAO() {
		String resource = "mybatis-config.xml";
		InputStream inputStream;
		try {
			inputStream = Resources.getResourceAsStream(resource);
		} catch (IOException e) {
			throw new IllegalArgumentException(e);
		}
		sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);

	}
	
	public Group getGroupByGroupId(int groupId) {
		SqlSession sqlSession = sqlSessionFactory.openSession();
		try {
			return (Group) sqlSession.selectOne(
					namespace + ".selectGroupByGroupId", groupId);
		}finally {
			sqlSession.close();
		}
	}
}
