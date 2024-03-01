package t2;
import t1.A;

import java.text.Annotation;

/**
 * @program: Java
 * @author: Qiaolezi
 * @create: 2024-02-29 18:34
 * @description:
 **/
public class test {
	public static void main(String[] args) {
		//new A();//Error:'A()' has protected access in 't1.A'
		//A<Object>() {};  有一个隐式的无参构造器，此句执行时，会调用A类的无参protected构造器
		A a = new A<Object>() {
		};
		System.out.println(a.getClass());//A的受保护的无参构造器  class t2.test$1
	}
}
