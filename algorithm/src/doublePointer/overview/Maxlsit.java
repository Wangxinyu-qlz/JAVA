package doublePointer.overview;

import java.util.*;
/**
 * @program: algorithm
 * @author: Qiaolezi
 * @create: 2024-03-09 14:27
	给定一个长度为的整数序列，请找出最长的不包含重复数字的连续子序列，输出它的长度。
 * 输入格式
 * 第一行包含整数n.
 * 第二行包含个整数(均在 0-100000 范围内)，表示整数序列。
 * 输出格式
 * 共一行，包含一个整数，表示最长的不包含重复数字的连续子序列的长度。
 * 数据范围
 * 1≤n≤100000
 **/
public class Maxlsit {
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int n = in.nextInt();
		int q[] = new int[n];
		for(int i=0; i<n; i++){
			q[i] = in.nextInt();
		}
		int sum = 0;
		int[] res = new int[n];
		for(int i=0, j=0; i< n; i++){
			res[q[i]]++;//把当前元素的个数+1（统计进数组）
			while(res[q[i]] > 1) {//有重复的元素
				res[q[j]]--;//把这个重复的元素踢出去
				j++;//j指针向右移动一个
			}
			//TODO 更新序列的长度
			sum = Math.max(sum, i - j + 1);
		}

		System.out.println(sum);
	}
}
