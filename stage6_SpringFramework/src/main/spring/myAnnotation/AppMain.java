package main.spring.myAnnotation;

import main.spring.myAnnotation.component.MonsterService;
import main.spring.myAnnotation.ioc.MySpringApplicationContext;
import main.spring.myAnnotation.ioc.MySpringConfig;

/**
 * @program: stage6_SpringFramework
 * @author: Qiaolezi
 * @create: 2024-04-23 15:49
 * @description:
 **/
public class AppMain {
	public static void main(String[] args) {
		MySpringApplicationContext mySpringApplicationContext =
				new MySpringApplicationContext(MySpringConfig.class);

		//Object monsterService1 = mySpringApplicationContext.getBean("monsterService");
		//Object monsterService2 = mySpringApplicationContext.getBean("monsterService");
		//Object monsterDao1 = mySpringApplicationContext.getBean("monsterDao");
		//Object monsterDao2 = mySpringApplicationContext.getBean("monsterDao");
		//System.out.println(monsterService1);
		//System.out.println(monsterService2);
		//System.out.println(monsterDao1);
		//System.out.println(monsterDao2);
		//
		//Object bean = mySpringApplicationContext.getBean("xxx");
		//System.out.println(bean);//Error

		//测试依赖注入
		MonsterService monsterService = (MonsterService)mySpringApplicationContext.getBean("monsterService");
		monsterService.ok();

		System.out.println("OK!");
	}
}
