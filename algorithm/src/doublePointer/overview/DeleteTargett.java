package doublePointer.overview;

import java.util.*;
/**
 * @program: algorithm
 * @author: Qiaolezi
 * @create: 2024-03-14 19:30
 * @description:
 **/
public class DeleteTargett {
	public static void main(String[] args) {
		int[] q = {1, 2, 5, 2};
		int n = q.length;

		Scanner in = new Scanner(System.in);
		int x = in.nextInt();
		int index = 0;
		for(int i=0, j = 0; i<n; i++) {
			if(x != q[i]) {
				q[j++] = q[i];
			}
			index = j;
		}
		for(int i=0; i<index; i++) {
			System.out.print(q[i] + " ");
		}
	}
}
