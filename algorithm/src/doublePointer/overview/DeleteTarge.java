package doublePointer.overview;

import java.util.Scanner;

/**
 * @program: algorithm
 * @author: Qiaolezi
 * @create: 2024-03-10 13:00
 * @description:
 **/
public class DeleteTarge {
	public static void main(String[] args) {
		int[] q = {1, 3, 5, 2, 1, 0, -9, 4};
		int n = q.length;
		Scanner in = new Scanner(System.in);
		int x = in.nextInt();
		int index = 0;
		for (int i = 0, j = 0; i < n; i++) {
			//TODO  if不是while
			//j一直停留在目标元素哪里，i去遍历整个数组，如果找到了不同于目标元素的，就移动到j那里
			if (x != q[i]) {
				q[j++] = q[i];
			}
			index = j;
		}

		for (int i = 0; i < index; i++) {
			System.out.print(q[i] + " ");
		}

	}
}
