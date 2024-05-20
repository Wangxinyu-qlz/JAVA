package main.spring.practice.aop.proxy_DinamicalProxy_log;

import org.junit.jupiter.api.Test;

/**
 * @program: pom.xml
 * @author: Qiaolezi
 * @create: 2024-05-20 22:34
 * @description:
 **/
public class TestSmartDog {
	@Test
	public void test() {
		SmartDog smartDog = new SmartDog();
		ProxyProvider_ proxyProvider = new ProxyProvider_(smartDog);
		Calculator calculator = proxyProvider.getCalculator();
		Integer add = calculator.add(1, 1);
		Integer subtract = calculator.subtract(1, 1);
		Double multiply = calculator.multiply(1.0, 1.0);
		Double divide = calculator.divide(1.0, 0.0);

		int i = calculator.divide_e(1, 0);

	}
}
