package doublePointer.overview;

/**
 * @program: algorithm
 * @author: Qiaolezi
 * @create: 2024-03-14 17:25
 * @description:
 **/
public class DeleteRepeatEle {
	public static void main(String[] args) {
		int[] q = { 1, 1, 1, 2, 2, 3, 3, 4};
		int n = q.length;
		int index = 0;
		for(int i=0, j=1; j<n; j++) {
			while(q[i] != q[j]) {
				//如果上一次q[i]==q[j], 说明这次需要将i指针的下一个替换掉，然后i指针后移
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
