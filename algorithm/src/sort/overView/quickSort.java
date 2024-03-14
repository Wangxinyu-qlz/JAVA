package sort.overView;

import javax.swing.*;
import java.util.*;
/**
 * @program: algorithm
 * @author: Qiaolezi
 * @create: 2024-03-09 14:08
 * @description:
 **/
public class quickSort {
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int n = in.nextInt();
		int q[] = new int[n];
		for(int i=0; i<n; i++){
			q[i] = in.nextInt();
		}

		quick(q, 0, n-1);

		for(int i=0; i< n; i++){
			System.out.print(q[i] + " ");
		}

	}

	public static void quick(int[] q, int l, int r){
		if(l>= r) {
			return;
		}

		int x = q[l];
		int i = l - 1, j = r + 1;
		while(i < j) {
			do{
				i++;
			}while(q[i] < x);
			do{
				j--;
			}while(q[j] > x);
			if(i < j) {
				int t = q[i];
				q[i] = q[j];
				q[j] = t;
			}
		}

		quick(q, l, j);
		quick(q, j+1, r);

	}

}
