package util;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.IOException;
import java.io.InputStream;

/**
 * @program: mybatis
 * @author: Qiaolezi
 * @create: 2024-05-24 12:10
 * @description:
 **/
public class MybatisUtils {
	static SqlSessionFactory sqlSessionFactory;

	static {
		String resource = "mybatis-config.xml";
		InputStream resourceAsStream = null;
		try {
			resourceAsStream = Resources.getResourceAsStream(resource);
		} catch (IOException ex) {
			throw new RuntimeException(ex);
		}
		sqlSessionFactory = new SqlSessionFactoryBuilder().build(resourceAsStream);
	}

	public static SqlSession getSqlSession() {
		return sqlSessionFactory.openSession();
	}
}
