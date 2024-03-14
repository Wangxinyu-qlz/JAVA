package sort.overView;

import java.util.*;
/**
 * @program: algorithm
 * @author: Qiaolezi
 * @create: 2024-03-09 13:49
 * @description:
 **/
public class Mergesort {
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int n = in.nextInt();
		int[] q = new int[n];
		for(int i=0; i<n; i++){
			q[i] = in.nextInt();
		}

		merge(q, 0, n-1);
		for(int i=0; i<n; i++){
			System.out.print(q[i] + " ");
		}

	}

	public static void merge(int[] q, int l, int r){
		if(l >= r) {
			return;
		}
		int mid = (l +r) / 2;
		int k = 0, i = l, j =mid+1;
		int[] res = new int[q.length];
		merge(q, l, mid);
		merge(q, mid+1, r);

		while(i <= mid && j <=r){
			if(q[i] <= q[j]) {
				res[k++] = q[i++];
			} else {
				res[k++] = q[j++];
			}
		}
		if(i <= mid) {
			while (i<=mid) {
				res[k++] = q[i++];
			}
		}
		if(j <=r ) {
			while(j <= r) {
				res[k++] = q[j++];
			}
		}

		//TODO 这里的x=l，l是动态变化的
		for(int x=l, y=0; x <=r; x++, y++){
			q[x] = res[y];
		}
	}
}
