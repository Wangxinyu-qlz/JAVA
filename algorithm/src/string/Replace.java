package string;

import java.util.Arrays;

/**
 * @program: algorithm
 * @author: Qiaolezi
 * @create: 2024-04-08 10:29
 * @description:
 **/
public class Replace {
	public static void main(String[] args) {
		String s = "i am new here";
		s = replace(s);
		System.out.println(s);
	}

	public static String replace(String s) {
		char[] str = s.toCharArray();
		int n = s.length();
		int l = 0;
		for (int i = 0; i < n; i++) {
			if (str[i] == ' ') {
				l += 2;
			}
			l++;
		}
		str = Arrays.copyOf(str, l);
		for (int i = n - 1, j = l - 1; i > 0; i--) {
			if (str[i] == ' ') {
				str[j] = '0';
				str[j - 1] = '2';
				str[j - 2] = '%';
				j = j - 3;
			} else {
				str[j] = str[i];
				j--;
			}

		}
		return new String(str);
	}
}
