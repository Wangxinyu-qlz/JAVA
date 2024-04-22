package main.spring.aop.proxy_;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * @program: stage6_SpringFramework
 * @author: Qiaolezi
 * @create: 2024-04-22 15:23
 * @description:
 **/
public class VehicleProxyProvider {
	//表示真正要执行的对象，该对象需要实现 Vehicle 接口
	private final Vehicle target_vehicle;

	public VehicleProxyProvider(Vehicle target_vehicle) {
		this.target_vehicle = target_vehicle;
	}

	//返回一个代理对象
	//TODO 非常重要
	// Proxy.newProxyInstance()可以返回一个代理对象
	// ClassLoader loader 类加载器
	// Class<?>[] interfaces 将来要代理的对象的接口信息
	// InvocationHandler h 调用处理器/对象   invoke()方法
	public Vehicle getProxy() {
		//得到类加载器
		ClassLoader classLoader = target_vehicle.getClass().getClassLoader();
		//得到要代理对象的 接口信息，底层通过接口完成
		Class<?>[] interfaces = target_vehicle.getClass().getInterfaces();
		//创建InvocationHandler
		//因为InvocationHandler 是接口，所以可以通过 匿名对象 的方式来创建对象
		//invoke() 方法 在执行 target_vehicle的 方法时 被调用
		/*
		 * public interface InvocationHandler {
		 *     public Object invoke(Object proxy, Method method, Object[] args)
		 *        throws Throwable;
		 * }
		 */
		InvocationHandler invocationHandler = new InvocationHandler() {
			/**
			 *
			 * @param proxy the proxy instance that the method was invoked on 代理对象
			 *              main.spring.proxy_.proxy_.Ship@1b26f7b2
			 *
			 * @param method the {@code Method} instance corresponding to
			 * the interface method invoked on the proxy instance.  The declaring
			 * class of the {@code Method} object will be the interface that
			 * the method was declared in, which may be a superinterface of the
			 * proxy interface that the proxy class inherits the method through.
			 * 通过代理对象调用方法时的 那个方法
			 * 比如：代理对象.run()  car.run()
			 *               public abstract void main.spring.proxy_.proxy_.Vehicle.run()
			 *
			 * @param args an array of objects containing the values of the
			 * arguments passed in the method invocation on the proxy instance,
			 * or {@code null} if interface method takes no arguments.
			 * Arguments of primitive types are wrapped in instances of the
			 * appropriate primitive wrapper class, such as
			 * {@code java.lang.Integer} or {@code java.lang.Boolean}.
			 *
			 * @return 代理对象.run(xx)的执行结果
			 * @throws Throwable
			 */
			@Override
			public Object invoke(Object proxy, Method method, Object[] args)
					throws Throwable {

				System.out.println("交通工具开始运行了...");
				//反射基础
				//method: public abstract void main.spring.proxy_.proxy_.Vehicle.run()
				//target_vehicle: Ship@1700
				//args: null  指的是run()方法的参数
				//这里通过反射+动态绑定机制，会执行到被代理对象的方法
				//执行完毕就返回
				Object result = method.invoke(target_vehicle, args);
				System.out.println("交通工具停止运行...");

				return result;
			}
		};

		/*
	    *public static Object newProxyInstance(ClassLoader loader,
                                      Class<?>[] interfaces,
                                      InvocationHandler h)*/

		return (Vehicle) Proxy.newProxyInstance(classLoader, interfaces, invocationHandler);

	}
}
