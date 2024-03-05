package sort.overView;

/**
 * @program: Java
 * @author: Qiaolezi
 * @create: 2024-03-05 15:50
 * @description:
 **/
public class Quick {
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

	private static void quick(int[] q, int l, int r) {
		//处理边界，只有一个数字，没有数字
		if(l >= r){return;}
		//确定分界线和  左右指针  使用i-1做递归的分界线
		int x = q[(l + r + 1) / 2], i = l - 1, j = r + 1;

		//使用j+1做分界线
		//int x = q[(l + r) / 2], i = l - 1, j = r + 1;
		//int x = q[l], i = l - 1, j = r + 1;

		//左右指针逼近
		while(i < j) {
			//左指针右移
			do{
				i++;
			} while(q[i] < x);
			//右指针左移
			do{
				j--;
			} while (q[j] > x);
			//交换
			if(i < j) {
				int t = q[i];
				q[i] = q[j];
				q[j] = t;
			}
		}

		//分治 分段处理
		quick(q, l, i - 1);
		quick(q, i, r);

		//q[(l + r) / 2]      q[l]
		//quick(q, l, j);
		//quick(q, j + 1, r);
	}
}
