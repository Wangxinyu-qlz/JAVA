package doublePointer.overview;

import java.util.*;
/**
 * @program: algorithm
 * @author: Qiaolezi
 * @create: 2024-03-23 12:00
 * @description:
 * 给定一个长度为的整数序列，请找出最长的不包含重复数字的连续子序列，输出它的长度。
 *  * 输入格式
 *  * 第一行包含整数n.
 *  * 第二行包含个整数(均在 0-100000 范围内)，表示整数序列。
 *  * 输出格式
 *  * 共一行，包含一个整数，表示最长的不包含重复数字的连续子序列的长度。
 *  * 数据范围
 *  * 1≤n≤100000
 **/
public class Length_ {
	public static void main(String[] args) {
		int[] q = {1, 2, 2, 3, 4, 4, 5, 6, 7};//4

		int n = q.length;
		int[] s = new int[n];
		int num = 0;
		for(int i=0, j=0; i<n; i++) {
			s[q[i]]++;
			while(s[q[i]] > 1) {
				s[q[j]]--;
				j++;
			}
			num = Math.max(num, i - j + 1);
		}

		System.out.println(num);
	}
}
