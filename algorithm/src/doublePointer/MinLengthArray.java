package doublePointer;

import java.util.Scanner;

/**
 * @program: algorithm
 * @author: Qiaolezi
 * @create: 2024-03-26 19:46
 * @description: 给定一个含有 n 个正整数的数组和一个正整数 target 。
 * 找出该数组中满足其总和大于等于 target 的长度最小的 连续
 * 子数组
 * [numsl, numsl+1, ..., numsr-1, numsr] ，并返回其长度。如果不存在符合条件的子数组，返回 0 。
 * <p>
 * 示例 1：
 * 输入：target = 7, nums = [2,3,1,2,4,3]
 * 输出：2
 * 解释：子数组 [4,3] 是该条件下的长度最小的子数组。
 * <p>
 * 示例 2：
 * 输入：target = 4, nums = [1,4,4]
 * 输出：1
 * <p>
 * 示例 3：
 * 输入：target = 11, nums = [1,1,1,1,1,1,1,1]
 * 输出：0
 **/
public class MinLengthArray {
	//public static void main(String[] args) {
	//	int[] q = {4, 5, 3, 1, 5, 3, 4, 9, 0, 2, -1, 3, 4};
	//	int s = 100;
	//
	//	int n = q.length;
	//	int a = 0, b = n - 1;
	//	int sum = 0;
	//	int length = n;
	//	int t = sum(q, 0, n-1);
	//
	//	//时间超限
	//	for (int i = 0, j = 0; j < n; j++) {
	//		sum = sum(q, i, j);
	//		if (sum >= s) {
	//			if ((j - i) < (b - a)) {
	//				a = i;
	//				b = j;
	//			}
	//			length = Math.min(length, j - i + 1);
	//			sum = 0;
	//			i ++;
	//			j = i - 1;
	//		}
	//	}
	//	if(t < s) {
	//		System.out.println(0);
	//	} else{
	//		System.out.print(a + " " + b + "\n长度是：" + length);
	//	}
	//}
	//
	//public static int sum(int[] q, int a, int b) {
	//	int sum = 0;
	//	for(int i = a; i<=b; i++) {
	//		sum += q[i];
	//	}
	//	return sum;
	//}

	public static void main(String[] args) {
		int[] q = {4, 5, 3, 1, 6, 6};
		int n = q.length;

		Scanner in = new Scanner(System.in);
		int sum = 0;
		int a= 0, b =0;
		int result = Integer.MAX_VALUE;
		int x = 6;

		for (int i = 0, j = 0; j < n; j++) {
			sum += q[j];
			while (sum >= x) {
				result = Math.min(result, j - i +1);
				sum -= q[i];
				i++;
			}
			a = i - 1;
			b = j;
		}
		System.out.println(result);
		System.out.println(a + " " + b);
	}
}
