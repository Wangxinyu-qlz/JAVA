package doublePointer.overview;

/**
 * @program: algorithm
 * @author: Qiaolezi
 * @create: 2024-03-14 17:34
 * @description: '#'代表退格
 * 判断两个字符串退格之后是否相等
 **/
public class Backward {
	public static void main(String[] args) {
		String s = "aq##";
		String t = "a#c#";
		boolean tf = back(s, t);
		System.out.println(tf);
	}

	public static boolean back(String s, String t) {
		int i = s.length() - 1;
		int j = t.length() - 1;
		int skips = 0;
		int skipt = 0;
		while (j >= 0 || i >= 0) {//两个字符串只要有一个不空，就一直比
			while (i >= 0) {
				//TODO 这里的逻辑：如果#，就skips++左移。如果s(i)！= "#"（条件可以删除），且skips>0，继续左移。如果skips归零，无法退格，退出
				if (s.charAt(i) == '#') {
					skips++;
					i--;
				} else if (s.charAt(i) != '#' && skips > 0) {
					skips--;
					i--;
				} else {
					break;
				}
			}

			//对t进行同样的操作
			while (j >= 0) {
				if (t.charAt(j) == '#') {
					skipt++;
					j--;
				} else if (t.charAt(j) == '#' && skipt > 0) {
					skipt--;
					j--;
				} else {
					break;
				}
			}

			//TODO 注意这里的逻辑
			if(i>=0 && j>=0) {
				if(s.charAt(i) != t.charAt(j)) {//字符不一致
					return false;
				}
			} else {//有一个指针遍历到了-1
				if(i>=0 || j>=0) {//但是另一个指针还没有到-1（一个结束了另一个还没结束）--》说明两个字符串长度不一样
					return false;
				}
			}
			i--;
			j--;
		}
		return true;
	}
}
