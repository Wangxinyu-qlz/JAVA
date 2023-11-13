import java.util.HashSet;

/**
 * @author qiaolezi
 * @version 1.0
 */
public class HashSet_ {
	@SuppressWarnings({"all"})
	public static void main(String[] args) {
//		HashSet 可以存放 null，但是只能存放一个，不能有重复的元素
//		不保证存放顺序和取出顺序一致
		HashSet hashSet = new HashSet();
		hashSet.add(null);
		hashSet.add(null);
		System.out.println(hashSet.add("a"));//T
		System.out.println(hashSet.add("b"));//T
		System.out.println(hashSet.add("a"));//F #
		System.out.println(hashSet.add("c"));//T
		System.out.println(hashSet.add("d"));//T

		hashSet.remove("a");

		System.out.println(hashSet);//[null]

		System.out.println("==============");
		hashSet = new HashSet();
		System.out.println(hashSet);//[]
		System.out.println("==============");
		hashSet.add("d");
		hashSet.add("d");
		System.out.println(hashSet);

//		不同的Dog对象可以添加
		System.out.println("==============");
		hashSet.add(new Dog1("tom"));
		hashSet.add(new Dog1("tom"));
		System.out.println(hashSet);//[d, Dog1@4554617c, Dog1@1b6d3586]

//		TODO 为什么只添加一个"aaa"
//		String将equals方法重写了，比较的是内容
		System.out.println("==============");
		hashSet.add(new String("aaa"));
		hashSet.add(new String("aaa"));
		System.out.println(hashSet);//[aaa, d, Dog1{name='tom'}, Dog1{name='tom'}]
	}
}

class Dog1 {
	private String name;

	public Dog1(String name) {
		this.name = name;
	}

	@Override
	public String toString() {
		return "Dog1{" +
				"name='" + name + '\'' +
				'}';
	}
}
