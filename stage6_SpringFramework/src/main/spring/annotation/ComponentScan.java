package main.spring.annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * @program: stage6_SpringFramework
 * @author: Qiaolezi
 * @create: 2024-04-18 17:14
 * @description: 1.@Target(ElementType.TYPE): 指定ComponentScan注解可以修饰Type程序元素：Class, interface (including annotation type), or enum declaration
 * 2.@Retention(RetentionPolicy.RUNTIME)：指定ComponentScan注解的保留范围
 * 3.String value() default "";表示 ComponentScan 注解可以传入 value
 **/
@Target(ElementType.TYPE)
@Retention(RetentionPolicy.RUNTIME)
public @interface ComponentScan {
	String value() default "";
}
