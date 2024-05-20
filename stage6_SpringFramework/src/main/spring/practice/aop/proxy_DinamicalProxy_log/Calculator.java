package main.spring.practice.aop.proxy_DinamicalProxy_log;

/**
 * @program: pom.xml
 * @author: Qiaolezi
 * @create: 2024-05-20 22:24
 * @description:
 **/
public interface Calculator {
	Integer add(Integer x, Integer y);
	Integer subtract(Integer x, Integer y);
	Double multiply(Double x, Double y);
	Double divide(Double x, Double y);
	int divide_e(int x, int y);
}
