package doublePointer;

import org.junit.jupiter.api.Test;

import java.util.Scanner;

/**
 * @program: Java
 * @author: Qiaolezi
 * @create: 2024-03-06 14:16
 * @description: 给定一个长度为的整数序列，请找出最长的不包含重复数字的连续子序列，输出它的长度。
 * 输入格式
 * 第一行包含整数n.
 * 第二行包含个整数(均在0-100000范围内)，表示整数序列。
 * 输出格式
 * 共一行，包含一个整数，表示最长的不包含重复数字的连续子序列的长度。
 * 数据范围
 * 1≤n≤100000
 **/
public class DoublePointer02 {
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int n = in.nextInt();
		int[] q = new int[n + 10];
		for (int i = 0; i < n; i++) {
			q[i] = in.nextInt();
		}
		int res = 0;
		int[] s = new int[n+10];
		for(int i=0, j=0; i<n; i++) {
			s[q[i]]++;//记录i指针 所指的元素 的数量
			while(s[q[i]] > 1) {//如果i指针所指元素数量>1，遇到了重复的元素，j右移，跳过
				s[q[j]] --;//j指针所指元素数量-1
				j ++;//j指针右移
			}
			res = Math.max(res, i - j + 1);
		}
		System.out.println(res);
	}
}
