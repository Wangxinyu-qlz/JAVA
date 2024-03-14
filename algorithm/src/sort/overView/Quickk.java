package sort.overView;

import java.util.*;
/**
 * @program: algorithm
 * @author: Qiaolezi
 * @create: 2024-03-10 12:22
 * @description:
 **/
public class Quickk {
	public static void main(String[] args) {
		 int[] q = {1, 2, 5, 7, 8, 9, -9, 1, 3, 5, 2};
		 int n = q.length;
		 quick(q, 0, n-1);
		 for(int i = 0; i<n; i++){
			 System.out.print(q[i] + " ");
		 }
	}

	public static void quick(int[] q, int l, int r) {
		if(l >= r) {
			return;
		}
		int x = q[l], i = l - 1, j = r + 1;
		while(i < j) {
			do{
				i++;
			}while(q[i] < x);
			do{
				j--;
			}while(q[j] > x);

			//交换
			if(i < j) {
				int t = q[i];
				q[i] = q[j];
				q[j] = t;
			}
		}

		quick(q, l, j);;
		quick(q, j+1, r);
	}
}
