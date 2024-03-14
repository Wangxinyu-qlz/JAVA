package doublePointer.overview;

import java.util.*;

/**
 * @program: algorithm
 * @author: Qiaolezi
 * @create: 2024-03-09 14:37
 * @description:
 * 模板：
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
public class Sting_ {
	public static void main(String[] args) {
		String s = "abc aef hello";
		int n = s.length();
		for(int i=0; i<n; i++){
			int j = i;
			while(j < n && s.toCharArray()[j] != ' ') {
				j ++;
			}
			for(int k = i; k<j; k++){
				System.out.print(s.toCharArray()[k]);
			}
			System.out.println();
			i = j;
		}
	}
}
