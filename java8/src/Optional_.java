/*
	Optional 类是一个可以为null的容器对象。
	如果值存在则isPresent()方法会返回true，调用get()方法会返回该对象。
	它可以保存类型T的值，或者仅仅保存null
	Optional提供很多有用的方法，这样我们就不用显式进行空值检测。
	很好的解决空指针异常。
 */
import java.util.Optional;

public class Optional_ {
	public static void main(String args[]) {

		Optional_ o = new Optional_();
		Integer value1 = null;
		Integer value2 = null;

		// Optional.ofNullable - 允许传递为 null 参数
		Optional<Integer> a = Optional.ofNullable(value1);

		// Optional.of - 如果传递的参数是 null，抛出异常 NullPointerException
		Optional<Integer> b = Optional.ofNullable(value2);
		System.out.println(o.sum(a, b));
	}

	public Integer sum(Optional<Integer> a, Optional<Integer> b) {

		// Optional.isPresent - 判断值是否存在

		System.out.println("第一个参数值存在: " + a.isPresent());
		System.out.println("第二个参数值存在: " + b.isPresent());

		// Optional.orElse - 如果值存在，返回它，否则返回默认值
		Integer value1 = a.orElse(new Integer(0));

		//Optional.get - 获取值，值需要存在
		//Integer value2 = b.get();
		Integer value2 = b.orElse(new Integer(0));
		return value1 + value2;
	}
}
