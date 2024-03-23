package doublePointer.overview;

import java.util.Arrays;
import java.util.OptionalInt;

/**
 * @program: algorithm
 * @author: Qiaolezi
 * @create: 2024-03-14 09:27
 * @description:  最长的不包含重复数字的连续子序列的长度
 **/
public class MaxListwithNoRepeat {
	public static void main(String[] args) {
		int[] q= {1, 1, 2, 3, 4, 4, 5, 0, 1, 0};
		int n  = q.length;
		int[] res = new int[n];
		int sum = 0;
		for(int i=0, j=0; i< n; i++) {
			res[q[i]] ++;//记下当前数字的个数
			/**
			 * 1 2 2 3 3 3 5 4 6 7 8 9
			 * i
			 * j
			 */
			while(res[q[i]] > 1) {//如果当前数字的个数大于1，
				res[q[j]] --;
				j++;
			}
			sum = Math.max(sum, i - j + 1);//更新最长的序列的长度
		}
		System.out.println(sum);
	}
}
