package sort.overView;

/**
 * @program: Java
 * @author: Qiaolezi
 * @create: 2024-03-05 20:56
 * @description:
 **/
public class Quick3 {
	public static void main(String[] args) {
		int[] test = {1, 2, 5, 2, 5, 8, 1, 245, 1, 0, -9, 523, 6, 21, 5, 21,};
		int n = test.length;
		for (int i = 0; i < n; i++) {
			System.out.print(test[i] + " ");
		}
		System.out.println("\n+++++++++++++++++++++++");

		quick(test, 0, n - 1);

		for (int i = 0; i < n; i++) {
			System.out.print(test[i] + " ");
		}
	}

	public static void quick(int[] q, int l, int r){
		if(l >= r) return;
		int x = q[l], i = l - 1, j = r + 1;

		while(i < j) {
			do{
				i++;
			}while(q[i] < x);
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
