package main.spring.annotation;

import main.spring.myspring.MyApplicationContext;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import java.io.File;
import java.net.URL;
import java.util.concurrent.ConcurrentHashMap;

/**
 * @program: stage6_SpringFramework
 * @author: Qiaolezi
 * @create: 2024-04-18 17:26
 * @description: 该类 的作用类似于 Spring原生ioc容器
 **/
public class MySpringApplicationContext {
	private Class configClass;
	//ioc中存放的是通过反射创建的对象（基于注解方式）
	private final ConcurrentHashMap<String, Object> ioc =
			new ConcurrentHashMap<>();//singletonObjects

	public MySpringApplicationContext(Class configClass) {
		this.configClass = configClass;
		//this.configClass=class main.spring.annotation.MySpringConfig
		//System.out.println("this.configClass=" + this.configClass);

		//获取扫描的包
		//1.获取MySpringConfig配置的@ComponentScan(value = "main.spring.component")
		ComponentScan componentScan = (ComponentScan) this.configClass.getDeclaredAnnotation(ComponentScan.class);
		//2.通过componentScan得到要扫描的包
		String path = componentScan.value();
		//System.out.println("要扫描的包=" + path);

		//得到要扫描的包下的所有的资源（.class文件，在out/target目录下）
		//1.得到一个类的加载器
		ClassLoader classLoader = MyApplicationContext.class.getClassLoader();
		//2.通过 类的加载器 获取到 要扫描的包的url
		String convertedPath = path.replace(".", "/");
		URL resource = classLoader.getResource(convertedPath);
		//System.out.println("resource" + resource);
		//3.将要加载的资源(.class)路径下的文件进行遍历-->io
		File file = new File(resource.getFile());//目录是特殊的文件
		if (file.isDirectory()) {
			File[] files = file.listFiles();
			for (File f : files) {
				//System.out.println("=================");
				//C:\My_Code\Java\stage6_SpringFramework\target\classes\main\spring\component\UserDao.class
				//System.out.println(f.getAbsolutePath());
				//获取到 main.spring.component.UserDao
				String fileAbsolutePath = f.getAbsolutePath();

				//这里只处理.class文件，先进行过滤
				if (fileAbsolutePath.endsWith(".class")) {
					//1.获取类名
					String className = fileAbsolutePath.substring(
							fileAbsolutePath.lastIndexOf("\\") + 1,
							fileAbsolutePath.indexOf(".class"));
					//System.out.println("className=" + className);
					//2.获取类的完整的路径(全类名)
					String classFullName = path + "." + className;
					//System.out.println(classFullName);
					//3.判断该类是否要注入到容器中，查看该类是否有注解(@Component @Service @Controller @Repository)
					try {
						//aClass是该类的Class对象
						//也可以使用Class.forName(classFullName)得到Class对象
						//区别：Class.forName()会调用该类的静态方法，下面的方式不会
						Class<?> aClass = classLoader.loadClass(classFullName);
						//aClass.isAnnotationPresent(Component.class)判断该类有没有添加该注解
						if (aClass.isAnnotationPresent(Component.class) ||
								aClass.isAnnotationPresent(Controller.class) ||
								aClass.isAnnotationPresent(Repository.class) ||
								aClass.isAnnotationPresent(Service.class)) {
							//演示给bean自定义id Component注解指定value
							if(aClass.isAnnotationPresent(Component.class)) {
								Component component = aClass.getDeclaredAnnotation(Component.class);
								String id = component.value();
								if(!"".endsWith(id)){
									className = id;
								}
							}

							//这时就可以反射对象，放入容器中
							Class<?> class_ = Class.forName(classFullName);
							Object instance = class_.newInstance();
							//放入容器中
							//StringUtils
							ioc.put(StringUtils.uncapitalize(className), instance);

						}
					} catch (Exception e) {
						throw new RuntimeException(e);
					}
				}

			}
		}


	}


	//编写方法返回容器的对象
	public Object getBean(String name) {
		return ioc.get(name);
	}

	public Class getConfigClass() {
		return configClass;
	}

	public void setConfigClass(Class configClass) {
		this.configClass = configClass;
	}
}
