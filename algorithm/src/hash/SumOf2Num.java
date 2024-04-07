package hash;
import java.util.*;
/**
 * @program: algorithm
 * @author: Qiaolezi
 * @create: 2024-04-06 16:51
 * @description:
 **/
public class SumOf2Num {
	public static void main(String[] args) {
		int[] nums = {1, 2, 5, 7, 6, 3, 4};
		int target = 3;
		for(int x : sum2Num(nums, target)) {
			System.out.print((x + 1)+ " ");
		}
	}

	public static int[] sum2Num(int[] nums, int target) {
		Map<Integer, Integer> map = new HashMap<>();
		for(int i=0; i<nums.length; i++) {
			if(map.containsKey(target - nums[i])) {
				return new int[]{map.get(target - nums[i]), i};
			} else {
				map.put(nums[i], i);
			}
		}
		return new int[0];
	}
}
