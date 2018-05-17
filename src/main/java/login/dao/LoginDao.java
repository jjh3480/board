package login.dao;

import java.io.IOException;
import java.io.InputStream;
import login.model.LoginVO;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

public class LoginDao implements LoginDaoInf {
	
	private SqlSessionFactory sqlSessionFactory;
	
	public LoginDao() {
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
	public LoginVO LoginCheck(String id) {
		SqlSession session = sqlSessionFactory.openSession();
		LoginVO lvo = session.selectOne("login.LoginCheck",id);
		
		session.close();
		
		return lvo;
	}
}
