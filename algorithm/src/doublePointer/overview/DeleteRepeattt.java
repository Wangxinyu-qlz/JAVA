package doublePointer.overview;

/**
 * @program: algorithm
 * @author: Qiaolezi
 * @create: 2024-03-14 19:37
 * @description:
 **/
public class DeleteRepeattt {
	public static void main(String[] args) {
		int[] q = {1, 1, 1, 2, 2, 3, 4, 4, 4, 5};
		int n = q.length;
		int index = 0;
		for(int i=0, j=1; j<n; j++) {
			if(q[i] != q[j]) {
				q[i+1] = q[j];
				i++;
			}
			index = i;
		}
		for(int i=0; i<=index; i++) {
			System.out.print(q[i] + " ");
		}
	}
}
