package main.spring.myAnnotation.ioc;

import main.spring.myAnnotation.annotation.Component;
import main.spring.myAnnotation.annotation.ComponentScan;
import main.spring.myAnnotation.annotation.Scope;
import main.spring.myspring.MyApplicationContext;
import org.springframework.util.StringUtils;

import java.io.File;
import java.net.URL;
import java.util.concurrent.ConcurrentHashMap;

/**
 * @program: stage6_SpringFramework
 * @author: Qiaolezi
 * @create: 2024-04-23 15:36
 * @description:
 **/
public class MySpringApplicationContext {
	private Class configClass;
	//BeanDefinition对象
	private final ConcurrentHashMap<String, BeanDefinition> beanDefinitionMap = new ConcurrentHashMap<>();
	//单例池
	private final ConcurrentHashMap<String, Object> singletonObject = new ConcurrentHashMap<>();

	//该方法完成对指定包的扫描，并将bean信息封装到BeanDefinition对象，放入到Map
	public void beanDefinitionScan(Class configClass) {
		this.configClass = configClass;

		//获取扫描的包
		//1.获取MySpringConfig配置的@ComponentScan(value = "main.spring.component")
		ComponentScan componentScan = (ComponentScan) this.configClass.getDeclaredAnnotation(ComponentScan.class);
		//2.通过componentScan得到要扫描的包
		String path = componentScan.value();

		//得到要扫描的包下的所有的资源（.class文件，在out/target目录下）
		//1.得到一个类的加载器->APP 类加载器
		ClassLoader classLoader = MyApplicationContext.class.getClassLoader();
		//2.通过 类的加载器 获取到 要扫描的包的url
		String convertedPath = path.replace(".", "/");
		URL resource = classLoader.getResource(convertedPath);
		System.out.println("扫描的包：" + resource);
		//3.将要加载的资源(.class)路径下的文件进行遍历-->io
		File file = new File(resource.getFile());//目录是特殊的文件
		if (file.isDirectory()) {
			File[] files = file.listFiles();
			for (File f : files) {
				//获取到 main.spring.component.UserDao
				String fileAbsolutePath = f.getAbsolutePath();
				System.out.println("===============");

				//这里只处理.class文件，先进行过滤
				if (fileAbsolutePath.endsWith(".class")) {
					//1.获取类名
					String className = fileAbsolutePath.substring(fileAbsolutePath.lastIndexOf("\\") + 1, fileAbsolutePath.indexOf(".class"));
					//2.获取类的完整的路径(全类名)
					String classFullName = path + "." + className;
					//3.判断该类是否要注入到容器中，查看该类是否有注解(@Component @Service @Controller @Repository)
					try {
						//aClass是该类的Class对象
						Class<?> clazz = classLoader.loadClass(classFullName);
						if (clazz.isAnnotationPresent(Component.class)) {
							//如果该类有@Component注解，是spring bean
							System.out.println("是Spring bean=" + clazz + "    类名=" + className);
							//1.得到Component注解
							Component componentAnnotation = clazz.getDeclaredAnnotation(Component.class);
							//2.得到value值（beanName）
							String beanName = componentAnnotation.value();
							if ("".equals(beanName)) {//没有配置beanName
								//使用小写首字母的类名作为beanName
								beanName = StringUtils.uncapitalize(className);
							}
							//3.将bean的信息封装到BeanDefinition对象，放入到beanDefinitionMap中
							BeanDefinition beanDefinition = new BeanDefinition();
							beanDefinition.setClazz(clazz);
							//4.获取scope
							if (clazz.isAnnotationPresent(Scope.class)) {
								Scope declaredAnnotation = clazz.getDeclaredAnnotation(Scope.class);
								beanDefinition.setScope(declaredAnnotation.value());
							} else {
								beanDefinition.setScope("singleton");
							}
							//将beanDefinition对象放入到Map
							beanDefinitionMap.put(beanName, beanDefinition);


						} else {
							System.out.println("不是Spring bean=" + clazz + "    类名=" + className);
						}
					} catch (Exception e) {
						throw new RuntimeException(e);
					}
				}

			}
		}

	}

	public MySpringApplicationContext(Class configClass) {
		beanDefinitionScan(configClass);
		System.out.println("beanDefinitionMap=" + beanDefinitionMap);
	}

	//编写方法返回容器的对象
	public Object getBean(String name) {
		return null;
	}

	public Class getConfigClass() {
		return configClass;
	}

	public void setConfigClass(Class configClass) {
		this.configClass = configClass;
	}
}
