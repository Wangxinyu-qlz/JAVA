package qiaolezi.furniture.test;

import org.junit.Test;
import org.mybatis.generator.api.MyBatisGenerator;
import org.mybatis.generator.config.Configuration;
import org.mybatis.generator.config.xml.ConfigurationParser;
import org.mybatis.generator.internal.DefaultShellCallback;

import java.io.File;
import java.util.ArrayList;

/**
 * @program: furniture_ssm
 * @author: Qiaolezi
 * @create: 2024-05-08 14:03
 * @description: 逆向生成bean mapper接口和mapper.xml
 **/
public class MBGTest {
	@Test
	public void test() throws Exception {
		ArrayList<String> warnings = new ArrayList<>();
		boolean overwrite = true;

		//指定配置文件
		File file = new File("mybatis-generator.xml");
		ConfigurationParser cp = new ConfigurationParser(warnings);
		Configuration configuration = cp.parseConfiguration(file);
		DefaultShellCallback callback = new DefaultShellCallback(overwrite);
		MyBatisGenerator myBatisGenerator = new MyBatisGenerator(configuration, callback, warnings);
		myBatisGenerator.generate(null);
		System.out.println("逆向生成完毕！");
	}
}
