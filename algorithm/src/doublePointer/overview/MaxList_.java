package doublePointer.overview;
import java.util.*;

/**
 * @program: algorithm
 * @author: Qiaolezi
 * @create: 2024-03-10 12:52
 * @description: 给定一个长度为n的整数序列，请找出最长的不包含重复数字的连续子序列，输出它的长度。
 * 输入格式
 *      第一行包含整数n.
 *      第二行包含个整数(均在 0-100000 范围内)，表示整数序列。
 * 输出格式
 *      共一行，包含一个整数，表示最长的不包含重复数字的连续子序列的长度。
 * 数据范围
 *      1≤n≤100000
 **/
public class MaxList_ {
	public static void main(String[] args) {
		int[] q = {1, 2, 2, 2, 3, 3, 4, 5, 6};
		int n = q.length;
		int[] res = new int[n];
		int sum = 0;
		for(int i=0, j=0; i<n; i++) {
			res[q[i]]++;//当前元素的个数+1
			while(res[q[i]] > 1) {//有重复的元素
				res[q[j]] --;//j指针指向的元素是重复的，把这个元素的个数-1,j指针右移
				j++;
			}
			//更新序列的长度
			sum = Math.max(sum, i - j +1);
		}
		System.out.println(sum);
	}
}
