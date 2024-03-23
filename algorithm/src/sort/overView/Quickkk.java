package sort.overView;

import java.util.Scanner;

/**
 * @program: algorithm
 * @author: Qiaolezi
 * @create: 2024-03-23 11:21
 * @description:
 **/
public class Quickkk {
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int[] q = {2, 5, 32, 5, 6, 2, 3, 5, 2};
		int n = q.length;

		quick(q, 0, n - 1);

		for (int i = 0; i < n; i++) {
			System.out.print(q[i] + " ");
		}
	}

	public static void quick(int[] q, int l, int r) {
		//边界条件
		if (l >= r) {
			return;
		}
		int x = q[l];//分界点
		int i = l - 1, j = r + 1;
		while (i < j) {
			do {
				i++;
			} while (q[i] < x);
			do {
				j--;
			} while (q[j] > x);

			if (i < j) {
				int t = q[i];
				q[i] = q[j];
				q[j] = t;
			}
		}
		quick(q, l, j);
		quick(q, j+1, r);

	}
}
