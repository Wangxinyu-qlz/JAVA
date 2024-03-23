package doublePointer.overview;

/**
 * @program: algorithm
 * @author: Qiaolezi
 * @create: 2024-03-23 16:07
 * @description:
 **/
public class Backkkkkkk {
	public static void main(String[] args) {
		String s = "q#e#r###qwe";
		String t = "r#q#c###qwe";

		System.out.println(back(s, t));
	}

	public static boolean back(String s, String t) {
		int i = s.length() - 1;
		int j = t.length() - 1;
		int skips = 0, skipt = 0;
		//TODO 这里的i j指的是指针的位置，数组的下标从0开始的，需要这里也要从0开始
		while (i >= 0 || j >= 0) {
			//TODO 处理退格符号
			while (i >= 0) {
				if (s.charAt(i) == '#') {
					skips++;
					i--;
				} else if (skips > 0) {
					skips--;
					i--;
				} else {
					break;
				}
			}
			while (j >= 0) {
				if (s.charAt(j) == '#') {
					skipt++;
					j--;
				} else if (skipt > 0) {
					skipt--;
					j--;
				} else {
					break;
				}
			}

			if (i >= 0 && j >= 0) {
				if (s.charAt(i) != t.charAt(j)) {
					return false;
				}
			} else {
				if (i >= 0 || j >= 0) {
					return false;
				}
			}
			//TODO 从下一个开始比较
			i--;
			j--;
		}
		return true;
	}

}
