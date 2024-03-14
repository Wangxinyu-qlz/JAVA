package doublePointer.overview;

import java.util.*;
/**
 * @program: algorithm
 * @author: Qiaolezi
 * @create: 2024-03-10 12:47
 * @description:
 *  * for(int i = 0; i < n; i++) {
 *  * 	while(j < i && check(i, j)) j++;
 *  * 	//每道题具体的逻辑
 *  * }
 *  * 双指针例子
 *  * 输入：给定一个字符串，单词之间用空格隔开
 *  * 输出：每行一个单词
 *  * abc def ghi
 *  * abc
 *  * def
 *  * ghi
 **/
public class Stringkong {
	public static void main(String[] args) {
		String s = "hello world";
		int n = s.length();
		for(int i=0; i<n; i++) {
			int j = i;
			while(j < n && s.toCharArray()[j] != ' ') {
				j++;
			}
			for(int i1 = i; i1 <j; i1++) {
				System.out.print(s.toCharArray()[i1]);
			}
			System.out.println();
			i = j;
		}
	}
}
