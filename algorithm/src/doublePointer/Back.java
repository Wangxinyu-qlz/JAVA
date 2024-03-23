package doublePointer;

/**
 * @program: algorithm
 * @author: Qiaolezi
 * @create: 2024-03-09 17:02
 * @description:
 * #代表退格符
 * 从后向前遍历，如果是退格符skip++，表示需要多删除一个普通字符
 *            如果是普通字符，如果skip>0，就删除一个普通字符，skip--
 *            如果是普通字符，如果skip<=0，就去遍历下一个字符
 **/
public class Back {
	public static void main(String[] args) {
		String s = "######aq#";
		String t = "a";
		boolean b = backspaceCompare(s, t);
		System.out.println(b);
	}

	public static boolean backspaceCompare(String S, String T) {
		int i = S.length() - 1, j = T.length() - 1;
		int skipS = 0, skipT = 0;

		while (i >= 0 || j >= 0) {
			while (i >= 0) {
				if (S.charAt(i) == '#') {
					skipS++;
					i--;
				} else if (skipS > 0 && S.charAt(i)!='#') {
					skipS--;
					i--;
				} else {
					break;
				}
			}
			while (j >= 0) {
				if (T.charAt(j) == '#') {
					skipT++;
					j--;
				} else if (skipT > 0) {
					skipT--;
					j--;
				} else {
					break;
				}
			}
			if (i >= 0 && j >= 0) {
				if (S.charAt(i) != T.charAt(j)) {
					return false;
				}
			} else {
				if (i >= 0 || j >= 0) {
					return false;
				}
			}
			i--;
			j--;
		}
		return true;
	}
}
