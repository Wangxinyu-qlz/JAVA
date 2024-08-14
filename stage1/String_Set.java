import java.util.HashSet;

/**
 * @program: Java
 * @author: Qiaolezi
 * @create: 2024-08-09 11:58
 * @description:
 **/
public class String_Set {
	public static void main(String[] args) {
		String a = "aaa";
		String a1 = "a";
		HashSet<String> set  = new HashSet<>();
		set.add(a);
		set.add(a1);
		System.out.println(set);//[aaa, a]
		a1 += "aa";
		System.out.println(set);//[aaa, a]
	}
}
