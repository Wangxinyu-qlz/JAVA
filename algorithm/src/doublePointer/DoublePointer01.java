package doublePointer;

/**
 * @program: Java
 * @author: Qiaolezi
 * @create: 2024-03-06 10:51
 * @description:
 * 模板：
 * for(int i = 0; i < n; i++) {
 * 	while(j < i && check(i, j)) j++;
 * 	//每道题具体的逻辑
 * }
 * 双指针例子
 * 输入：给定一个字符串，单词之间用空格隔开
 * 输出：每行一个单词
 * abc def ghi
 * abc
 * def
 * ghi
 **/
public class DoublePointer01 {
	public static void main(String[] args) {
		String s = "abc def ghi";
		int n = s.length();

		for (int i = 0; i < n; i++) {
			/**
			 * 指针j指向i
			 * abc def ghi
			 * i
			 * j
			 * 指针j向后移动，遇到空格停下
			 * abc def ghi
			 * i
			 *    j
			 * 指针i指向j
			 * abc def ghi
			 *    i
			 *    j
			 */
			int j = i;
			while(j < n && s.toCharArray()[j] != ' ') {
				j++;
			}

			//每道题的具体逻辑
			for(int k = i; k < j; k++) {
				System.out.print(s.toCharArray()[k]);
			}
			System.out.println();

			i = j;
		}
	}
}
