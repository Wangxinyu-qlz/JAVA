package hash;

import java.util.HashSet;
import java.util.Set;

/**
 * @program: algorithm
 * @author: Qiaolezi
 * @create: 2024-04-06 15:38
 * @description:
 **/
public class IntegersectionArray {
	public static void main(String[] args) {
		int[] nums1 = {1, 2, 3, 4, 5, 6, 2, 1};
		int[] nums2 = {-9, 0, 5, 6, 2, 1};
		int[] intersection = getIntersection(nums1, nums2);
		for (int num : intersection) {
			System.out.print(num + " ");
		}
	}

	public static int[] getIntersection(int[] nums1, int[] nums2) {
		Set<Integer> s1 = new HashSet<Integer>();
		Set<Integer> s2 = new HashSet<Integer>();
		for (int num : nums1) {
			s1.add(num);
		}
		for (int num : nums2) {
			s2.add(num);
		}

		return intersection(s1, s2);
	}

	public static int[] intersection(Set<Integer> s1, Set<Integer> s2) {
		if(s1.size() < s2.size()) {
			return intersection(s2, s1);
		}

		HashSet<Integer> intersectionSet = new HashSet<Integer>();
		for(int num : s1) {
			if(s2.contains(num)) {
				intersectionSet.add(num);
			}
		}

		int[] intersection = new int[intersectionSet.size()];
		int index = 0;
		for(int num : intersectionSet) {
			intersection[index++] = num;
		}

		return intersection;
	}
}
