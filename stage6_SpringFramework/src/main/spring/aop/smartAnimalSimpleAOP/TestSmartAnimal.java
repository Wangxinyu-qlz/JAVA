package main.spring.aop.smartAnimalSimpleAOP;

import org.junit.jupiter.api.Test;

/**
 * @program: stage6_SpringFramework
 * @author: Qiaolezi
 * @create: 2024-04-22 17:41
 * @description:
 **/
public class TestSmartAnimal {
	@Test
	public void testSmartAnimal() {
		SmartAnimalProxyProvider smartAnimalProxyProvider = new SmartAnimalProxyProvider(new Monkey());

		SmartAnimal proxy = smartAnimalProxyProvider.getProxy();
		proxy.getSum(1.2, 2.1);
		System.out.println("=================");
		proxy.getSub(2.0, 1.0);
		System.out.println("Over~");
	}
}
