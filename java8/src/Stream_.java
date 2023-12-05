import java.util.Arrays;
import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;

/*
	stream()         − 为集合创建串行流
	parallelStream() − 为集合创建并行流
 */
public class Stream_ {
	public static void main(String[] args) {
		List<String> strings = Arrays.asList("abc", "", "bc", "efg", "abcd", "", "jkl");
		// 并行  获取空字符串的数量
		//Returns true if, and only if, length() is 0.
		long count = strings.parallelStream().filter(String::isEmpty).count();//
		System.out.println("空串有" + count + "个");
		//将空串过滤掉
		List<String> filtered = strings.stream().
				filter(string -> !string.isEmpty()).
				collect(Collectors.toList());
		for (String s : filtered) {
			System.out.println(s);
		}
		System.out.println("长度大于2的字符串的个数是：" + filtered.stream().filter(string -> string.length() > 2).count());
		System.out.println("按照长度排序：");
		filtered.stream().sorted((a, b) -> a.length() - b.length()).forEach(System.out::println);
		System.out.println("------------------------------------");


		//	输出元素对应的平方数
		List<Integer> numbers = Arrays.asList(3, 2, 2, 3, 7, 3, 5);
		// 获取对应的平方数,去掉重复的
		List<Integer> squaresList = numbers.stream().map(i -> i * i).distinct().collect(Collectors.toList());
		squaresList.forEach(System.out::println);
		System.out.println("------------------------------------");

		//输出10个随机数，limit(10)打印10条
		Random random = new Random();
		random.ints().limit(10).forEach(System.out::println);//只输出10个随机数，但是会一直算
		System.out.println("------------------------------------");
	}
}
