package sort.overView;

import java.util.*;
/**
 * @program: Java
 * @author: Qiaolezi
 * @create: 2024-03-06 08:46
 * @description: 快速排序
 * 1.q[l]
 * 2.左指针->  <-右指针
 * 3.递归
 **/
public class Quick4 {
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int n = in.nextInt();
		int[] q = new int[n];
		for(int i=0; i<n; i++){
			q[i] = in.nextInt();
		}

		quick(q, 0, n-1);
		for(int i=0; i<n; i++){
			System.out.print(q[i] + " ");
		}
	}

	public static void quick(int[] q, int l, int r) {
		if(l >= r){return;}
		int x = q[l], i = l-1, j = r + 1;

		while(i<j) {
			do{
				i++;
			}while(q[i] < x); //TODO < 没有等号
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
