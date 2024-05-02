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
 * @create: 2024-04-30 16:39
 * @description:
 **/
public class MyBatisUtils {

	private static final SqlSessionFactory sqlSessionFactory;

	//编写静态代码块，初始化sqlSessionFactory 只会执行一次
	static {
		try {
			String resource = "mybatis-config.xml";
			InputStream resourceAsStream = Resources.getResourceAsStream(resource);

			sqlSessionFactory = new
					SqlSessionFactoryBuilder().build(resourceAsStream);
			//sqlSessionFactory: org.apache.ibatis.session.defaults.DefaultSqlSessionFactory@536aaa8d
			//System.out.println("sqlSessionFactory: " + sqlSessionFactory);
		} catch (IOException e) {
			throw new RuntimeException(e);
		}
	}

	//返回SqlSession对象-会话
	public static SqlSession getSqlSession() {
		return sqlSessionFactory.openSession();
	}
}
