package hash;

import java.util.Arrays;
import java.util.HashSet;

/**
 * @program: algorithm
 * @author: Qiaolezi
 * @create: 2024-07-12 22:53
 * @description:
 **/
public class MaxContinueLength {
	public static void main(String[] args) {
		int[] nums = {0,3,7,2,5,8,4,6,0,1};
		//去重
		HashSet<Integer> set = new HashSet<>();
		for (int i = 0; i < nums.length; i++) {
			set.add(nums[i]);
		}
		//集合转换为数组
		Integer[] newnums = set.toArray(new Integer[0]);
		Arrays.sort(newnums);
		for(int i = 0; i < newnums.length; i++) {
			System.out.print(newnums[i] + " ");
		}
		int count = 1;
		int max = 1;
		for (int i = 1; i < newnums.length; i++) {
			count++;
			if (count > max) max = count;
			if (newnums[i] != newnums[i - 1] + 1) {
				count = 1;
			}
		}
		System.out.println();
		System.out.println(max);
	}
}
