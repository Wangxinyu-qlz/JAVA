package main.spring.practice.aop.proxy_DinamicalProxy_log;

/**
 * @program: pom.xml
 * @author: Qiaolezi
 * @create: 2024-05-20 22:24
 * @description:
 **/
public class SmartDog implements Calculator{
	@Override
	public Integer add(Integer x, Integer y) {
		return x + y;
	}

	@Override
	public Integer subtract(Integer x, Integer y) {
		return x - y;
	}

	@Override
	public Double multiply(Double x, Double y) {
		return x * y;
	}

	@Override
	public Double divide(Double x, Double y) {
		return x / y;
	}

	@Override
	public int divide_e(int x, int y) {
		return x / y;
	}
}
