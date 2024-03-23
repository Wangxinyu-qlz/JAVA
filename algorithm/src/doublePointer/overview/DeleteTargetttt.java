package doublePointer.overview;

import java.util.Scanner;

/**
 * @program: algorithm
 * @author: Qiaolezi
 * @create: 2024-03-23 15:28
 * @description:删除目标元素
 **/
public class DeleteTargetttt {
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int m = in.nextInt();
		int[] q = {1, 1, 1, 2, 2, 5, 7, 9, 3, 1, 2, 1};
		int n = q.length;
		System.out.println("original array:");
		for (int i = 0; i < n; i++) {
			System.out.print(q[i] + " ");
		}
		System.out.println();

		//m个询问
		while (m-- > 0) {
			int index = 0;
			int x = in.nextInt();//要删除的元素
			for (int i = 0, j=0; i < n; i++) {
				if(q[i] != x) {
					q[j++] = q[i];
				}
				index = j;
			}

			for(int i=0; i<index; i++) {
				System.out.print(q[i] + " ");
			}
			System.out.println();
		}
	}
}
