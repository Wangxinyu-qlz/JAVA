package qiaolezi.springboot;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletComponentScan;
import org.springframework.context.ConfigurableApplicationContext;

/**
 * @program: quickstart
 * @author: Qiaolezi
 * @create: 2024-05-29 15:19
 * @description:
 **/
//扫描指定目录下的原生方式注入的Servlet
@ServletComponentScan(basePackages = "qiaolezi")
//标识这是一个springboot项目 scanBasePackages 指定扫描包以及子包
@SpringBootApplication(scanBasePackages = {"qiaolezi", })
public class MainApp {
	public static void main(String[] args) {
		//启动springboot程序 / 项目
		ConfigurableApplicationContext ioc = SpringApplication.run(MainApp.class, args);

		//查看ioc容器中有哪些组件
		//String[] beanDefinitionNames = ioc.getBeanDefinitionNames();
		//for (String beanDefinitionName : beanDefinitionNames) {
		//	System.out.println(beanDefinitionName);
		//}

		//ClassPathXmlApplicationContext ac = new ClassPathXmlApplicationContext("beans.xml");
		//Monster bean = ac.getBean(Monster.class);
		//System.out.println(bean);

		//@Configuration start
		//Monster monster = (Monster) ioc.getBean("monster_mayi");
		//Monster monster2 = (Monster) ioc.getBean("monster_mayi");
		//System.out.println(monster + "  " + monster.hashCode());
		//System.out.println(monster2 + "  " + monster2.hashCode());

		//测试@Configuration(proxyBeanMethods = true/false)
		//BeanConfig beanConfig = ioc.getBean(BeanConfig.class);
		//Monster monster = beanConfig.monster01();
		//Monster monster1 = beanConfig.monster01();
		//proxyBeanMethods = true
			//monster = Monster{id=200, name='蚂蚁', age=500, skill='钳子'} 168870325
			//monster1 = Monster{id=200, name='蚂蚁', age=500, skill='钳子'} 168870325
		//proxyBeanMethods = false
			//monster = Monster{id=200, name='蚂蚁', age=500, skill='钳子'} 1482344533
			//monster1 = Monster{id=200, name='蚂蚁', age=500, skill='钳子'} 1538849250
		//System.out.println("monster = " + monster + " " + monster.hashCode());
		//System.out.println("monster1 = " + monster1 + " " + monster1.hashCode());
		//如果直接通过容器获取对象，proxyBeanMethods = false无效
			//bean = Monster{id=200, name='蚂蚁', age=500, skill='钳子'} 1642356615
			//bean1 = Monster{id=200, name='蚂蚁', age=500, skill='钳子'} 1642356615
		//Monster bean = ioc.getBean(Monster.class);
		//Monster bean1 = ioc.getBean(Monster.class);
		//System.out.println("bean = " + bean + " " + bean.hashCode());
		//System.out.println("bean1 = " + bean1 + " " + bean1.hashCode());

		////  第一个配置类
		//Monster mayi = ioc.getBean("monster_mayi", Monster.class);
		//System.out.println(mayi);
		////	第二个配置类
		//Monster niu = ioc.getBean("monster02", Monster.class);
		//System.out.println(niu);

		//============@Import====================
		//Dog dog = ioc.getBean("qiaolezi.springboot.bean.Dog", Dog.class);
		////qiaolezi.springboot.bean.Dog
		//System.out.println(dog);
		//Cat cat = ioc.getBean("qiaolezi.springboot.bean.Cat", Cat.class);
		//System.out.println(cat);
		//
		////============@ConditionalOnBean==================
		////TODO 可以解决循环注入的问题
		////@ConditionalOnBean(name = "monster_?")
		////和Bean配置顺序有关，如果在之后配置Bean，会找不到
		//Dog dog01 = ioc.getBean("dog01", Dog.class);
		//System.out.println(dog01);
		//// 和配置类的加载顺序也有关，测试发现根据配置类的名字排序进行注入
		//Cat cat_test = ioc.getBean("cat_test", Cat.class);
		//System.out.println(cat_test);
		//
		//
		////@ConditionalOnMissingBean(name = "monster_")
		//Cat cat01 = ioc.getBean("cat01", Cat.class);
		//System.out.println(cat01);

		//============@ImportResource==================
		//Monster monster = ioc.getBean("monster", Monster.class);
		//System.out.println(monster);

		//Car car = ioc.getBean("car", Car.class);
		//System.out.println(car);
	}
}
