package sort.overView;

import java.util.*;

/**
 * @program: Java
 * @author: Qiaolezi
 * @create: 2024-03-05 20:05
 * @description:
 **/
public class Quick1 {
	public static void main(String[] args) {
		int[] test = {3, 2, 1, 0, 8, 4, 6, 7 ,5};
		int n = test.length;
		for(int i = 0; i< n; i++) {
			System.out.print(test[i] + " ");
		}

		quick(test, 0, n - 1);

		System.out.println("\n=====================");
		for(int i = 0; i < n; i++) {
			System.out.print(test[i]);
		}
	}

	public static void quick(int[] q, int l, int r){
		if(l >= r){return;}

		int x = q[l], i = l - 1, j = r + 1;

		while(i < j){
			do{
				i++;
			} while(q[i] < x);
			do{
				j--;
			}while(q[j] > x);
			if(i < j){
				int t = q[i];
				q[i] = q[j];
				q[j] = t;
			}
		}
		quick(q, l, j);
		quick(q, j+1, r);
	}
}
