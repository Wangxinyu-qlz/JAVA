package hash;

import java.util.HashMap;
import java.util.Map;

/**
 * @program: algorithm
 * @author: Qiaolezi
 * @create: 2024-04-06 17:20
 * @description:
 **/
public class FourNumsSum {
	public static void main(String[] args) {
		int[] a = {1, 2};
		int[] b = {-2, -1};
		int[] c = {-1, 2};
		int[] d = {0, 2};
		System.out.println(fourSumCount(a, b, c, d));
	}


	public static int fourSumCount(int[] nums1, int[] nums2, int[] nums3, int[] nums4) {
		//值是出现的次数，如果没出现就 0+1，如果出现就 (出现的次数)+1
		Map<Integer, Integer> countAB = new HashMap<Integer, Integer>();
		for (int u : nums1) {
			for (int v : nums2) {
				countAB.put(u + v, countAB.getOrDefault(u + v, 0) + 1);
			}
		}
		int cnt = 0;
		for (int u : nums3) {
			for (int v : nums4) {
				if (countAB.containsKey(-u - v)) {//如果有对应的Key(sum)
					cnt += countAB.get(-u - v);//把这个sum出现的次数加到cnt上
				}
			}
		}
		return cnt;
	}
}
