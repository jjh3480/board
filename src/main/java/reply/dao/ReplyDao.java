package reply.dao;

import java.io.IOException;
import java.io.InputStream;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import reply.model.ReplyVO;

public class ReplyDao implements ReplyDaoInf{
	
private SqlSessionFactory sqlSessionFactory;
	
	
	public ReplyDao() {
		String resource = "db/mybatis/mybatis-config.xml";
		InputStream inputStream = null;
		try {
			inputStream = Resources.getResourceAsStream(resource);
			sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
			
		} catch (IOException e) {
			e.printStackTrace();
		}
	}


	@Override
	public int insertReply(ReplyVO rvo) {
		SqlSession sqlSession = sqlSessionFactory.openSession();
		int result = sqlSession.insert("reply.insertReply", rvo);
		sqlSession.commit();
		sqlSession.close();
		return result;
	}

}
