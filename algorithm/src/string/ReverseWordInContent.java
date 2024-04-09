package string;

/**
 * @program: algorithm
 * @author: Qiaolezi
 * @create: 2024-04-08 11:17
 * @description:
 **/
public class ReverseWordInContent {
	public static void main(String[] args) {
		String s = "the sky is blue";
		System.out.println(s);
		s = deleteSpaces(s);
		System.out.println(s);
		s = reverseWord(s, 0, s.length() - 1);
		System.out.println(s);
		s = reverseWordInContent(s);
		System.out.println(s);
	}

	public static String reverseWordInContent(String s) {
		int n = s.length();
		int slow = 0;
		for(int i=0; i<=n; i++) {
			if(i==n || s.charAt(i) == ' ') {
				s = reverseWord(s, slow, i-1);
				slow = i+1;
			}
		}
		return s;
	}

	public static String reverseWord(String s, int l, int r) {
		char[] str = s.toCharArray();
		while(l < r) {
			char tmp = str[l];
			str[l] = str[r];
			str[r] = tmp;
			l++;
			r--;
		}
		return new String(str);
	}

	public static String deleteSpaces(String s) {
		char[] str = s.toCharArray();
		int n = s.length();
		int slow = 0;
		for (int i = 0; i < n; i++) {
			if (str[i] != ' ') {
				if(slow != 0) {
					str[slow++] = ' ';
				}
				while (i < n && str[i] != ' ') {
					str[slow++] = str[i++];
				}
			}
		}
		char[] tmp = new char[slow];
		for(int i = 0; i< slow; i++) {
			tmp[i] = str[i];
		}
		return new String(tmp);
	}
}
