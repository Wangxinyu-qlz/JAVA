package doublePointer;

import java.util.*;
/**
 * @program: algorithm
 * @author: Qiaolezi
 * @create: 2024-03-09 15:57
 * @description:
 **/
public class DeleteRepeat {
	public static void main(String[] args) {
		int[] q = {1, 1, 1, 2, 2, 3, 4, 5, 5, 6};//应该返回6
		int n = q.length;
		int index = 0;
		for(int i=0, j=1; j<n; j++){
			if(q[i] != q[j]) {
				q[i+1] = q[j];
				i++;
			}
			index = i + 1;
		}
		System.out.println(index);
		for(int i = 0; i < n; i++) {
			System.out.print(q[i] + " ");
		}
	}
}
