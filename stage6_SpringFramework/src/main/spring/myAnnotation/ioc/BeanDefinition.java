package main.spring.myAnnotation.ioc;

/**
 * @program: stage6_SpringFramework
 * @author: Qiaolezi
 * @create: 2024-04-23 16:14
 * @description: 用于记录bean的信息：name scope bean的Class对象(反射生成对应的对象)
 **/
public class BeanDefinition {
	private String scope;
	private Class clazz;

	public String getScope() {
		return scope;
	}

	public void setScope(String scope) {
		this.scope = scope;
	}

	public Class getClazz() {
		return clazz;
	}

	public void setClazz(Class clazz) {
		this.clazz = clazz;
	}

	@Override
	public String toString() {
		return "BeanDefinition{" +
				"scope='" + scope + '\'' +
				", clazz=" + clazz +
				'}';
	}
}
