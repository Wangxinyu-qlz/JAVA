package doublePointer;

import java.util.*;
/**
 * @program: algorithm
 * @author: Qiaolezi
 * @create: 2024-03-09 15:00
 * @description:
 **/
public class DeleteTargetElements {
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int m = in.nextInt();
		int q[] = new int[100010];

		while(m-- > 0) {
			int n = in.nextInt();//数组的长度
			for(int i=0; i<n; i++){
				q[i] = in.nextInt();
			}
			int x = in.nextInt();//要删除的元素

			int index = 0;
			//遍历整个数组
			for(int i=0, j=0; i<n; i++){
				//TODO
				//j一直停留在目标元素哪里，i去遍历整个数组，如果找到了不同于目标元素的，就移动到j那里
				if(x!= q[i]) {
					q[j++] = q[i];
				}
				index = j;
			}
			for(int i=0; i<index; i++){
				System.out.print(q[i] + " ");
			}
		}
	}

}
