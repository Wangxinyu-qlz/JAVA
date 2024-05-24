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

	static{
		try{
			String source = "mybatis-config.xml";
			InputStream resourceAsStream = Resources.getResourceAsStream(source);
			sqlSessionFactory = new SqlSessionFactoryBuilder().build(resourceAsStream);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public static SqlSession getSqlSession(){
		return sqlSessionFactory.openSession();
	}
}
