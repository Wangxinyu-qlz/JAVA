package doublePointer;

/**
 * @program: algorithm
 * @author: Qiaolezi
 * @create: 2024-03-26 19:24
 * @description:
 **/
public class SquareArray {
	public static void main(String[] args) {
		int[] q = {-4, -3, -2, 0, 1, 2, 3, 4, 5, 6};
		//int[] q = {0, 1, 2, 3, 4, 5, 6};
		//int[] q = {-4, -3, -2, 0};
		int n = q.length;

		int[] res = new int[n];
		//int k = n - 1;
		if (q[0] >= 0) {
			for (int i = 0; i < n; i++) {
				res[i] = q[i] * q[i];
			}
		} else if (q[n - 1] <= 0) {
			for (int i = 0; i < n; i++) {
				res[n - 1 - i] = q[i] * q[i];
			}
		} else {
			for (int i = 0, j = n - 1, k = n - 1; i <= j; k--) {
				if (Math.abs(q[i]) >= Math.abs(q[j])) {
					res[k] = q[i] * q[i];
					i++;
				} else {
					res[k] = q[j] * q[j];
					j--;
				}
			}
		}

		for (int i = 0; i < n; i++) {
			System.out.print(res[i] + " ");
		}

	}
}
