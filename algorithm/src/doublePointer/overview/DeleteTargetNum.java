package doublePointer.overview;

import java.util.*;
/**
 * @program: algorithm
 * @author: Qiaolezi
 * @create: 2024-03-14 16:08
 * @description:
 * 删除目标元素
 **/
public class DeleteTargetNum {
	public static void main(String[] args) {
		int[] q=  {1, 1, 1, 2, 2, 3, 3, 4, 5, 6, 6, 6};
		int n = q.length;
		Scanner in = new Scanner(System.in);
		int x = in.nextInt();
		int index = 0;
		for(int i=0, j=0; i<n; i++) {
			//如果 != 目标元素 j指针才会右移
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
