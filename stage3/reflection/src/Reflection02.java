import base.Cat;

import java.lang.reflect.Method;

/**
 * @author qiaolezi
 * @version 1.0
 * 测试反射调用的性能以及优化方案
 */
public class Reflection02 {
	public static void main(String[] args) throws Exception{
		Reflection02 reflection02 = new Reflection02();
		reflection02.m1();
		reflection02.m2();
		reflection02.m3();
	}

	//传统方法调用hi()
	public void m1() {
		Cat cat = new Cat();
		long s = System.currentTimeMillis();
		for(int i = 0; i < 999999999; i++) {
			cat.hi();
		}
		long e = System.currentTimeMillis();
		System.out.println("传统方法调用hi()耗时：" + (e - s));
	}

	public void m2() throws Exception {
		Class<?> aClass = Class.forName("base.Cat");
		Object o = aClass.newInstance();
		Method hi = aClass.getMethod("hi");

		long s = System.currentTimeMillis();
		for(int i = 0; i < 999999999; i++) {
			hi.invoke(o);
		}
		long e = System.currentTimeMillis();
		System.out.println("反射方法调用hi()耗时：" + (e - s));
	}

	//反射优化：关闭访问检测
	public void m3() throws Exception {
		Class<?> aClass = Class.forName("base.Cat");
		Object o = aClass.newInstance();
		Method hi = aClass.getMethod("hi");
		hi.setAccessible(true);//在反射调用方法时，取消访问检查
		long s = System.currentTimeMillis();
		for(int i = 0; i < 999999999; i++) {
			hi.invoke(o);
		}
		long e = System.currentTimeMillis();
		System.out.println("反射方法调用hi()耗时：" + (e - s));
	}

}
