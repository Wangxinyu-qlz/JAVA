package sort.overView;

import java.util.Scanner;
/**
 * @program: algorithm
 * @author: Qiaolezi
 * @create: 2024-03-10 12:28
 * @description:
 **/
public class Mergee {
	public static void main(String[] args) {
		int[] q = {1, 2, 5, 7, 8, 9, -9, 1, 3, 5, 2};
		int n = q.length;
		merge(q, 0, n-1);
		for(int i=0; i<n; i++){
			System.out.print(q[i] + " ");
		}
	}

	public static void merge(int[] q, int l, int r) {
		if(l >= r) {
			return;
		}
		int mid = (l + r) / 2, i = l, j = mid + 1;
		merge(q, l, mid);
		merge(q, mid+ 1, r);
		int[] res = new int[q.length];
		int k = 0;
		while(i <= mid && j<=r) {
			if(q[i] <= q[j]) {
				res[k++] = q[i++];
			} else {
				res[k++] = q[j++];
			}
		}
		if(i<=mid) {
			while(i<=mid) {
				res[k++] = q[i++];
			}
		}
		if(j<=r) {
			while(j<=r) {
				res[k++] = q[j++];
			}
		}
		for(int x=l, y =0; x<=r; x++, y++){
			q[x] = res[y];
		}
	}
}
