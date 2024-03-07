package main.spring.myspring;

import main.spring.bean.Monster;

/**
 * @program: stage6_SpringFramework
 * @author: Qiaolezi
 * @create: 2024-03-05 09:37
 * @description:
 **/
public class MyApplicationContextTest {
	public static void main(String[] args) throws Exception {
		MyApplicationContext ioc = new MyApplicationContext("beans.xml");
		Monster monster01 = (Monster)ioc.getBean("monster01");
		System.out.println(monster01);
	}
}
