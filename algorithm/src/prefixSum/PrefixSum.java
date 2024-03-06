package prefixSum;

import java.util.Random;

/**
 * @program: Java
 * @author: Qiaolezi
 * @create: 2024-03-05 22:55
 * @description: 输入一个长度为n的整数序列。
 * 接下来再输入m个询问，每个询问输入一对l,r。
 * 对于每个询问，输出原序列中从第个数到第个数的和。
 * 输入格式
 * 第一行包含两个整数n和m.
 * 第二行包含个整数，表示整数数列。
 * 接下来行，每行包含两个整数l和r，表示一个询问的区间范围。
 * 输出格式
 * 共m行，每行输出一个询问的结果。
 * 数据范围
 * 1≤l≤r≤n,
 * 1≤n,m≤100000
 * 一1000≤数列中元素的值≤1000
 **/
public class PrefixSum {
	public static void main(String[] args) {
		int[] q = new int[5+10];
		for(int i=1; i<=5; i++) {
			q[i] = (int)(Math.random() * 5 + 1);
		}
		for(int i =1; i<=5;  i++) {
			System.out.print(q[i] + " ");
		}
		System.out.println("\n");
		int[] sum = new int[6];
		sum[0] = 0;
		//写入 O(n)
		for(int i=1; i<=5; i++) {
			sum[i] = q[i] + sum[i-1];
		}

		//查询：O(1)
		System.out.println("数组q的[l, r]区间的和为：sum[r] - sum[l-1]="+ (sum[5] - sum[0]));
	}

}
