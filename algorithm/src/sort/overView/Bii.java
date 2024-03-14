package sort.overView;

import java.util.*;
/**
 * @program: algorithm
 * @author: Qiaolezi
 * @create: 2024-03-10 12:36
 * @description:
 **/
public class Bii {
	public static void main(String[] args) {
		int n = 0, m=0;
		Scanner in = new Scanner(System.in);
		n = in.nextInt();
		m = in.nextInt();
		int[] q = new int[n];
		for(int i=0; i<n; i++) {
			q[i] = in.nextInt();
		}

		while(m-->0) {
			int x = in.nextInt();
			int l = 0, r = n - 1;
			while(l < r) {
				int mid = (l + r) / 2;
				if(q[mid] >= x) {
					r = mid;
				} else {
					l = mid + 1;
				}
			}

			if(q[l] != x) {
				System.out.println("-1 -1");
			} else{
				System.out.print(l + " ");
				l = 0;
				r = n - 1;
				while(l < r) {
					int mid  = (l + r + 1) / 2;
					if(q[mid] <= x) {
						l = mid;
					} else {
						r = mid  -1;
					}
				}
				System.out.println(l);
			}
		}
	}
}
