package sort;

/**
 * @program: algorithm
 * @author: Qiaolezi
 * @create: 2024-03-09 14:45
 * @description:
 **/
import java.util.*;
public class BinarySearchNum {
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int q[] = {0, 1, 2, 3, 5, 9, 100};
		int n = q.length;
		int m = in.nextInt();
		while(m-- > 0) {//m次问询
			int x = in.nextInt();
			int l = 0, r = n - 1;
			while(l < r) {
				int mid = (l + r) / 2;
				if(q[mid] >= x) {//大于等于就到左边找
					r = mid;
				} else {
					l = mid + 1;
				}
			}
			if(q[l] != x) {
				System.out.println("NULL");
			} else {
				System.out.println(l);
			}
		}
	}
}
