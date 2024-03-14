package doublePointer.overview;

/**
 * @program: algorithm
 * @author: Qiaolezi
 * @create: 2024-03-10 13:18
 * @description:
 **/
public class DeleteRepeat {
	public static void main(String[] args) {
		int[] q = {1, 2, 2, 2, 3, 4, 5, 6, 6, 6, 6, 77};
		int n = q.length;
		int index= 0;
		//因为j大一点，所以为了防止出界，j<n
		for(int i=0, j=1; j<n; j++) {
			if(q[i] != q[j]) {
				q[i+1] = q[j];
				i++;
			}
			index = i;
		}
		for(int i = 0; i<=index; i++) {
			System.out.print(q[i] + " ");
		}
	}
}
