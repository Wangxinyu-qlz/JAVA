package string;

import java.util.Arrays;

/**
 * @program: algorithm
 * @author: Qiaolezi
 * @create: 2024-04-07 21:00
 * @description:
 **/
public class ReverseString {
	public static void main(String[] args) {
		String s = "qwerty";
		System.out.println(reverse(s, 0, 3));
	}


	public static String reverse(String s, int l, int r) {
		char[] str = s.toCharArray();
		for (int i = l, j = r; i < j; i++, j--) {
			char temp = s.charAt(i);
			str[i] = s.charAt(j);
			str[j] = temp;
		}
		return new String(str);
	}
}
