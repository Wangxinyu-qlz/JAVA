package sort;

/**
 * @program: Java
 * @author: Qiaolezi
 * @create: 2024-03-05 15:18
 * @description:
 **/
public class QuickSort {
	public static void quickSort(int[] q, int l, int r) {
		if(l >= r){return;} //如果没有数或者只剩下一个数字，不需要排序

		//i j 取得是左右边界的两边的位置，因为是do{}while()循环
		int x = q[l], i = l - 1, j = r + 1;//分界点 左右指针

		while(i < j) {
			do{
				i++;
			} while (q[i] < x);
			do{
				j--;
			} while(q[j] > x);
			if(i < j) {
				int t = q[i];
				q[i] = q[j];
				q[j]  =t;
			}
		}
		//递归处理左右的子部分
		quickSort(q, l, j);
		quickSort(q, j + 1, r);
	}

	public static void main(String args[]) {
		int[] test = {2, 1, 0, 3, 5};
		for (int i = 0; i < test.length; i++) {
			System.out.print(test[i] + " ");
		}
		System.out.println("\n------------------------");
		quickSort(test, 0, test.length - 1);

		for (int i = 0; i < test.length; i++) {
			System.out.print(test[i] + " ");
		}
	}
}
