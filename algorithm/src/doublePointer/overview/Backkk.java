package doublePointer.overview;

/**
 * @program: algorithm
 * @author: Qiaolezi
 * @create: 2024-03-14 19:42
 * @description:
 **/
public class Backkk {
	public static void main(String[] args) {
		String s = "aa##";
		String t = "a#q#";
		System.out.println(back(s, t));
	}

	public static boolean back(String s, String t) {
		int i = s.length() - 1, j = t.length() - 1;
		int skips = 0, skipt = 0;
		while (i >= 0 || j >= 0) {
			//先处理s
			while (i >= 0) {
				if (s.charAt(i) == '#') {//退格+1，左移
					skips++;
					i--;
				} else if (skips > 0) {//退格-1，左移
					skips--;
					i--;
				} else {//没有退格了，结束
					break;
				}
			}
			//后处理t
			while (j >= 0) {
				if(t.charAt(j) == '#') {
					skipt++;
					j--;
				}else if(skipt > 0) {
					skipt--;
					j--;
				} else {
					break;
				}
			}

			if (i >= 0 && j >= 0) {//两个都没结束
				if (s.charAt(i) != t.charAt(j)) {//无法匹配
					return false;
				}
			} else {//至少有一个结束了
				if (i >= 0 || j >= 0) {//另一个还没结束
					return false;
				}
			}
			//从前一个开始，继续以上处理
			i--;
			j--;
		}

		return true;
	}
}
