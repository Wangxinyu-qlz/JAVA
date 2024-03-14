package sort.overView;

import java.util.Scanner;

/**
 * @program: algorithm
 * @author: Qiaolezi
 * @create: 2024-03-09 14:15
 * @description:
 **/
public class Binary {
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int q[] = {1, 2, 2, 2, 3, 3, 4, 5, 5, 6};
		System.out.println("input:");
		int x = in.nextInt();
		int l = 0, r = q.length - 1;

		while(l < r) {
			int mid = (l + r) / 2;
			if(q[mid] >= x) {
				r = mid;
			} else {
				l = mid + 1;
			}
		}
		if(q[l] !=  x) {
			System.out.println("-1 -1");
		} else {
			System.out.print(l + " ");
			l = 0;
			r = q.length - 1;
			while(l < r) {
				int mid = (l + r + 1) / 2;
				if(q[mid] <= x) {
					l = mid;
				} else {
					r = mid - 1;
				}
			}
			System.out.println(r);
		}

	}
}
