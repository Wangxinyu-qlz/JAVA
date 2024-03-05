package sort.overView;

import java.util.*;
/**
 * @program: Java
 * @author: Qiaolezi
 * @create: 2024-03-05 22:08
 * @description:
 **/
public class QuickS {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		int n = scanner.nextInt();
		int[] q = new int[n];
		for(int i=0; i<n; i++){
			q[i] = scanner.nextInt();
		}

		quick(q, 0, n-1);

		for(int i = 0; i < n; i++){
			System.out.println(q[i]);
		}
	}

	public static void quick(int[] q, int l, int r){
		if(l >= r) {
			return;
		}
		int x = q[l], i = l - 1, j = r + 1;
		while(i < j) {
			do{
				i++;
			} while(q[i] < x);//TODO 这里没有 =
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
