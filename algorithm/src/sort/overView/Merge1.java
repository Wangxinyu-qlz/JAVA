package sort.overView;

import java.util.*;
/**
 * @program: Java
 * @author: Qiaolezi
 * @create: 2024-03-06 09:05
 * @description:
 * 0.边界条件
 * 1.mid= (l+r) / 2
 * 2.递归
 * 3.处理数组：处理完一个，处理另一个剩下的，拷贝
 **/
public class Merge1 {
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
		int mid = (l + r) / 2, i = l, j  = mid + 1, k = 0;
		//辅助数组
		int[] res = new int[1000];
		merge(q, l, mid);
		merge(q, mid+1, r);

		//处理一个数组
		while(i<=mid && j<=r) {
			if(q[i] <= q[j]) {
				res[k++] = q[i++];
			}else{
				res[k++] = q[j++];
			}
		}
		if(i<=mid){
			while(i<=mid) {
				res[k++] = q[i++];
			}
		}
		if(j<=r) {
			while(j<=r){
				res[k++] = q[j++];
			}
		}

	//	copy
		for(int x=l, y=0; x<=r; x++, y++){
			q[x] = res[y];
		}
	}
}
