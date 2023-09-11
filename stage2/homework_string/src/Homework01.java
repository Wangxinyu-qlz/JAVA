import java.util.Arrays;

/**
 * @author qiaolezi
 * @version 1.0
 * 功能："abcdef"->"aedcbf";
 */
public class Homework01 {
	public static void main(String[] args) {
		String s = "abcdef";
		String news = reverse(s, 2, 5);
		System.out.println(news);
	}

	public static String reverse(String str, int start, int end) {
		char[] chars = str.toCharArray();//TODO 转换为char数组
		char temp = ' ';
		for (int i = start - 1, j = end - 1; i < j; i++, j--) {
			temp = chars[i];
			chars[i] = chars[j];
			chars[j] = temp;
		}
		return Arrays.toString(chars);
	}
}
