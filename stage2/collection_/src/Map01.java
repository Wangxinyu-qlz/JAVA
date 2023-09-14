import java.util.HashMap;
import java.util.Map;

/**
 * @author qiaolezi
 * @version 1.0
 */
public class Map01 {
	public static void main(String[] args) {
//		接口实现类的特点，使用实现类HashMap
//		1.Map与Collection并列存在，用于保存具有映射关系的数据：Key-Value(双列元素)
//      2.Map 中的 Key 和 Value 可以使任何引用类型的数据
//		3.Key不允许重复
//		4.Value可以重复
//		5.Key 可以为 null, Value也可以为 null
//		注意 Key 为 null，只能有一个，Value可以有多个
//		6.常用String类作为Key，实际上可以使用任何类型
//		TODO HashMap 线程不安全
		Map map = new HashMap<>();
		map.put("no1", "tomi");//K-V
		map.put("no2", "joy");//k-v
		map.put("no3", "tomi");//k-v
		map.put("no1", "t");//有相同的Key时，等价于替换
		map.put(null, null);//k-v
		map.put(null, "abc");//替换
		map.put("no4", null);//k-v
		map.put("no5", null);//k-v

//		通过 get 方法传入 Key，返回对应的 Value
		System.out.println(map.get(null));//abc
		System.out.println("map=" + map);//map={no2=joy, no1=t, no3=tomi}
	}
}
