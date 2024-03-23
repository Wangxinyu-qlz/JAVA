package sort.overView;

/**
 * @program: algorithm
 * @author: Qiaolezi
 * @create: 2024-03-23 11:36
 * @description:
 **/
public class Mergeee {
	public static void main(String[] args) {
		int[] q = {3, 2, 1, 58, 2, 58, 52, 5, 5};
		int n = q.length;

		merge(q, 0, n - 1);

		for (int i = 0; i < n; i++) {
			System.out.print(q[i] + " ");
		}
	}

	public static void merge(int[] q, int l, int r) {
		if (l >= r) {
			return;
		}
		int mid = (l + r) / 2;
		int i = l, j = mid+1;
		int[] res = new int[q.length];
		int k = 0;
		merge(q, l, mid);
		merge(q, mid + 1, r);


		while (i <= mid && j <= r) {
			if (q[i] <= q[j]) {
				res[k++] = q[i++];
			}
			if (q[i] >= q[j]) {
				res[k++] = q[j++];
			}
		}

		if (i <= mid) {
			while (i <= mid) {
				res[k++] = q[i++];
			}
		}
		if (j <= r) {
			while (j <= r) {
				res[k++] = q[j++];
			}
		}

		for (int x = l, y = 0; x <= r; x++, y++) {
			q[x] = res[y];
		}
	}
}
