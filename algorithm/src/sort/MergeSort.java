package sort;

/**
 * @program: Java
 * @author: Qiaolezi
 * @create: 2024-03-05 16:23
 * @description:
 **/
public class MergeSort {
	private static final int N = 10;
	private static int[] tmp= new int[N];
	public static void main(String args[]) {
		int[] test = {2, 1, 0, 3, 5};
		for (int i = 0; i < test.length; i++) {
			System.out.print(test[i] + " ");
		}
		System.out.println("\n------------------------");
		merge(test, 0, test.length - 1);

		for (int i = 0; i < test.length; i++) {
			System.out.print(test[i] + " ");
		}
	}

	private static void merge(int[] q, int l, int r) {
		if(l >= r){return;}
		//区间中点
		int mid = (l + r) / 2;

		//分别对两部分进行递归 注意是  mid +1
		merge(q, l, mid);
		merge(q, mid + 1, r);

		//数组合并
		//k:已经合并的数量，i:数组1的指针 j:数组2的指针
		int k = 0, i = l, j = mid + 1;
		while(i <= mid && j <= r) {
			if(q[i] <= q[j]) {
				tmp[k++] = q[i++];
			} else {
				tmp[k++] = q[j++];
			}
		}
		//判断第一个有没有循环完
		while(i <= mid) {
			tmp[k++] = q[i++];
		}
		//判断第二个有没有循环完
		while(j <= r) {
			tmp[k++] = q[j++];
		}

		//将数组拷贝回来
		for (int x = l, y = 0; x <= r; x++, y++) {
			q[x] = tmp[y];
		}
	}
}
