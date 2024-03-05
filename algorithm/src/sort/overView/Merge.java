package sort.overView;


/**
 * @program: Java
 * @author: Qiaolezi
 * @create: 2024-03-05 20:35
 * @description:
 **/
public class Merge {
	public static void main(String[] args) {
		int[] test = {1, 2, 5, 2, 5, 8, 1, 245, 1, 0, -9, 523, 6, 21, 5, 21,};
		int n = test.length;
		for (int i = 0; i < n; i++) {
			System.out.print(test[i] + " ");
		}
		System.out.println("\n+++++++++++++++++++++++");

		merge(test, 0, n - 1);

		for (int i = 0; i < n; i++) {
			System.out.print(test[i] + " ");
		}
	}

	private static int[] tmp = new int[100];

	public static void merge(int[] q, int l, int r) {
		if (l >= r) {
			return;
		}
		int mid = (l + r) / 2;

		merge(q, l, mid);
		merge(q, mid + 1, r);

		//合并两部分
		int k = 0, i = l, j = mid + 1;
		//把至少一个数组遍历完
		while (i <= mid && j <= r) {
			if (q[i] < q[j]) {
				tmp[k++] = q[i++];
			} else {
				tmp[k++] = q[j++];
			}
		}
		//另一个数组中剩下的塞进tmp[]
		if (i <= mid) {
			while (i <= mid) {
				tmp[k++] = q[i++];
			}
		}
		if (j <= r) {
			while (j <= r) {
				tmp[k++] = q[j++];
			}
		}

		//tmp[] -> q[]
		for (int x = l, y = 0; x <= r; x++, y++) {
			q[x] = tmp[y];
		}
	}
}
