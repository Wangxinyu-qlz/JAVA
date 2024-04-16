package main.test;

import main.spring.bean.BookStore;
import main.spring.bean.Employee;
import main.spring.bean.Master;
import main.spring.bean.Monster;
import main.spring.service.MemberService;
import org.junit.jupiter.api.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.io.File;


/**
 * @program: stage6_SpringFramework
 * @author: Qiaolezi
 * @create: 2024-03-04 22:36
 * @description:
 **/
public class springBeanTest {

	//测试 Bean 创建顺序
	@Test
	public void testBeanCreate() {
		ClassPathXmlApplicationContext ioc = new ClassPathXmlApplicationContext("beans.xml");
		System.out.println("OK~");
	}

	//通过 继承 配置Bean
	@Test
	public void setBeanByExtends() {
		ClassPathXmlApplicationContext ioc = new ClassPathXmlApplicationContext("beans.xml");

		Monster monster11 = ioc.getBean("monster11", Monster.class);
		System.out.println(monster11);

		//Error creating bean with name 'monster12': Bean definition is abstract
		//Monster abstractBean = ioc.getBean("monster12", Monster.class);

		Monster monster13 = ioc.getBean("monster13", Monster.class);
		System.out.println(monster13);
	}

	//通过FactoryBean获取Bean
	@Test
	public void setBeanByFactoryBean() {
		ClassPathXmlApplicationContext ioc = new ClassPathXmlApplicationContext("beans.xml");

		Monster factoryBean = ioc.getBean("factoryBean", Monster.class);
		System.out.println(factoryBean);

	}

	//通过实例工厂获取bean
	@Test
	public void setBeanByInstanceFactory() {
		ClassPathXmlApplicationContext ioc = new ClassPathXmlApplicationContext("beans.xml");

		Monster my_monster02 = ioc.getBean("my_monster02", Monster.class);
		Monster my_monster02_ = ioc.getBean("my_monster02", Monster.class);
		System.out.println(my_monster02);
		System.out.println(my_monster02_);
		//beans.xml中的实例对象只用了一次，id是唯一的
		System.out.println(my_monster02 == my_monster02_);//TODO true

		//这里的实例工厂不同
		Monster my_monster03 = ioc.getBean("my_monster03", Monster.class);
		System.out.println(my_monster02);
		System.out.println(my_monster03);
		System.out.println(my_monster02 == my_monster03);//false

	}

	//通过静态工厂获取bean
	@Test
	public void setBeanByStaticFactory() {
		ClassPathXmlApplicationContext ioc = new ClassPathXmlApplicationContext("beans.xml");

		Monster my_monster01 = ioc.getBean("my_monster01", Monster.class);
		System.out.println(my_monster01);
		Monster my_monster01_ = ioc.getBean("my_monster01_", Monster.class);
		System.out.println(my_monster01_);
		System.out.println(my_monster01_ == my_monster01);//true

	}

	//级联属性赋值
	@Test
	public void setBeanByRelation() {
		ClassPathXmlApplicationContext ioc = new ClassPathXmlApplicationContext("beans.xml");

		Employee employee = ioc.getBean("employee", Employee.class);
		System.out.println(employee);

	}

	//通过util:list名称空间给属性赋值
	@Test
	public void setBeanByUtilList() {
		ClassPathXmlApplicationContext ioc = new ClassPathXmlApplicationContext("beans.xml");

		BookStore bookStore = ioc.getBean("bookStore", BookStore.class);
		System.out.println("bookStore=" + bookStore);

	}


	//通过集合数组属性进行赋值
	@Test
	public void setBeanByCollection() {
		ClassPathXmlApplicationContext ioc = new ClassPathXmlApplicationContext("beans.xml");

		Master master = ioc.getBean("master", Master.class);
		System.out.println("master=" + master);

	}

	//通过内部bean设置Bean属性
	@Test
	public void setBeanByInnerBeanProperty() {
		ClassPathXmlApplicationContext ioc = new
				ClassPathXmlApplicationContext("beans.xml");
		MemberService memberService = (MemberService)ioc.getBean("memberService2");
		/**
		 * MemberDAOImplement无参构造器  被执行
		 * MemberDAOImplement::add()方法  被执行
		 */
		memberService.add();

	}

	//通过ref配置设置Bean属性
	@Test
	public void setBeanByRef() {
		ClassPathXmlApplicationContext ioc = new
				ClassPathXmlApplicationContext("beans.xml");
		MemberService memberService = (MemberService)ioc.getBean("memberService");
		/**
		 * MemberDAOImplement无参构造器  被执行
		 * MemberDAOImplement::add()方法  被执行
		 */
		memberService.add();

	}

	//通过p命名空间设置属性
	@Test
	public void setByPNameSpace() {
		ClassPathXmlApplicationContext ioc = new
				ClassPathXmlApplicationContext("beans.xml");
		Object monster06 = ioc.getBean("monster06", Monster.class);
		//Monster{id=6, name='后羿', skill='周日熄火了'}
		System.out.println(monster06);
	}
	//通过构造器设置属性
	@Test
	public void setByConstructor() {
		ClassPathXmlApplicationContext ioc = new
				ClassPathXmlApplicationContext("beans.xml");
		Object monster03 = ioc.getBean("monster03", Monster.class);
		//Monster{id=200, name='芈月', skill='镜花水月'}
		System.out.println(monster03);

		Monster monster04 = ioc.getBean("monster04", Monster.class);
		//Monster{id=4, name='镜', skill='老花镜'}
		System.out.println(monster04);

		Monster monster05 = ioc.getBean("monster05", Monster.class);
		//Monster{id=5, name='赔钱虎', skill='矮脚虎'}
		System.out.println(monster05);
	}
	@Test
	public void getMonster() {
		//1.创建容器ApplicationContext
		//2.该容器和容器配置文件关联
		//TODO ClassPath 类加载路径，不是src/beans.xml
		//ApplicationContext
		ApplicationContext ioc = new
				ClassPathXmlApplicationContext("beans.xml");
		//3.可以通过getBean()获取对应的对象，传入ID
		//  默认返回oObject，运行类型是Monster
		/**
		 * DeBug: beanFactory->beanDefinitionMap(concurrentHashMap)/singletonObjects->table（数组concurrentHashMap$Node）
		 * beanDefinitionMap->217->key/value->
		 * value:beanClass(main.spring.bean.Monster)/lazyInit/  propertyValues->propertyValueList->
		 * elementData->"bean property 'id'"...  （beans.xml文件中配置的信息）
		 * singletonObjects->table->217->hash.key(monster01)/
		 * value(monster01=Monster{id=1, name='牛魔', skill='撼天动地'})/next
		 */
		Object monster01 = ioc.getBean("monster01");
		//monster01=Monster{id=1, name='牛魔', skill='撼天动地'}
		System.out.println("monster01=" + monster01);
		//monster01运行类型=class main.spring.bean.Monster
		System.out.println("monster01运行类型=" + monster01.getClass());

		//这里需要转换类型才能直接.getId()
		System.out.println(((Monster)monster01).getMonsterId());

		//4.可以在获取的时候，直接指定Class类型
		Monster monster011 = ioc.getBean("monster01", Monster.class);
		Integer id = monster011.getMonsterId();
		System.out.println(id);
		
		//5.获取beans.xml中配置的bean的ID
		System.out.println("+++++++++++++++++++++++++++++");
		String[] beanDefinitionNames = ioc.getBeanDefinitionNames();
		for (String beanDefinitionName : beanDefinitionNames) {
			System.out.println(beanDefinitionName);//monster01
		}
		System.out.println("++++++++++++++++++++++++++++++");

		// 通过类型获取Bean 前提是配置文件中只有一个该类型的bean，否则抛出异常：
		//NoUniqueBeanDefinitionException
		//该方式的使用场景：xxxAction/Servlet/Controller 或者 xxxService 等
		// 在一个线程中只需要一个对象(单例)
		//Monster bean = ioc.getBean(Monster.class);
		//System.out.println(bean);
	}

	@Test
	public void getClassPath() {
		/**
		 * getResource():
		 * 查找具有给定名称的资源。搜索与给定类关联的资源的规则由该类的定义类装入器实现。
		 * 此方法委托给此对象的类装入器。如果此对象是由引导类加载器加载的，
		 * 则该方法将委托给 ClassLoader.getSystemResource。
		 * 在委派之前，使用以下算法从给定的资源名称构造绝对资源名称：
		 * 如果名称以'/' ('\u002f')开头，则资源的绝对名称是名称中'/'后面的部分。
		 * 否则，绝对名称的格式如下： modified_package_namename
		 * 其中modified_package_name是此对象的包名称，其中'/'替换为 '.' ('\u002e')。
		 */
		File file = new File(this.getClass().getResource("/").getPath());
		//class main.test.springBeanTest
		System.out.println("this.getClass()=" + this.getClass());
		//TODO 类的加载路径
		//file=C:\My_Code\Java\stage6_SpringFramework\target\classes
		System.out.println("file=" + file);
	}
}
