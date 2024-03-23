package doublePointer.overview;

/**
 * @program: algorithm
 * @author: Qiaolezi
 * @create: 2024-03-23 15:52
 * @description:
 **/
public class Dr {
	public static void main(String[] args) {
		int[] q = {1, 1, 1, 2, 3, 3, 4, 5, 6};
		int n = q.length;

		int index = 0;
		for(int i= 0, j=0; j<n; j++) {
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
