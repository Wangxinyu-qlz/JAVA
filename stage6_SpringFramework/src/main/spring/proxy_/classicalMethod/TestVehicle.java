package main.spring.proxy_.classicalMethod;

import org.junit.jupiter.api.Test;

/**
 * @program: stage6_SpringFramework
 * @author: Qiaolezi
 * @create: 2024-04-22 15:13
 * @description:
 * TODO 某些类实现了同一个接口，
 *  在这些对象的某些方法执行前后，都需要执行一些相同的方法
 *  比如日志记录，权限校验，事务管理，安全检查等
 *  需要一种统一管理的方法，统一管理这些类
 **/
public class TestVehicle {
	@Test
	public void testRun(){
		Vehicle car = new Car();
		car.run();

		Vehicle ship = new Ship();
		ship.run();
	}
}
