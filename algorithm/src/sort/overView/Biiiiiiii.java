package sort.overView;
import java.util.*;
/**
 * @program: algorithm
 * @author: Qiaolezi
 * @create: 2024-03-23 12:17
 * @description:
 * 	/**
 * 	 * 给定一个按照升序排列的长度为的整数数组，以及q个查询。
 * 	 * 对于每个查询，返回一个元素k的起始位置和终止位置(位置从0开始计数)。
 * 	 * 如果数组中不存在该元素，则返回“-1-1”。
 * 	 * 输入格式
 * 	 * 第一行包含整数n和q,表示数组长度和询问个数。
 * 	 * 第二行包含个整数(均在1~10000范围内)，表示完整数组。
 * 	 * 接下来q行，每行包含一个整数k,表示一个询问元素。
 * 	 * 输出格式
 * 	 * 共q行，每行包含两个整数，表示所求元素的起始位置和终止位置。
 * 	 * 如果数组中不存在该元素，则返回“。1-1”。
 * 	 * 数据范围
 * 	 * 1≤n≤100000
 * 	 * 1≤q≤10000
 * 	 * 1≤k≤10000
 * 	 * 样例：
 * 	 * 输入：
 * 	 * 6 3
 * 	 * 1  2  2  3  3  4
 * 	 * 3
 * 	 * 4
 * 	 * 5
 * 	 * 输出：
 * 	 * 3 4
 * 	 * 5 5
 * 	 * -1 -1
 */
public class Biiiiiiii {
	public static void main(String[] args) {
		int n = 0, m=0;
		Scanner in = new Scanner(System.in);
		n = in.nextInt();
		m = in.nextInt();
		int[] q = new int[n+10];
		for(int i=0; i<n; i++) {
			q[i] = in.nextInt();
		}

		for(int i=0; i< n; i++) {
			System.out.print(q[i] + " ");
		}
		while(m-->0) {
			int x = in.nextInt();
			int l = 0, r = n-1;
			while(l < r) {
				int mid = (l + r) / 2;
				if(q[mid] >=x) {
					r = mid;
				} else {
					l = mid+1;
				}
			}
			if(q[l] != x) {
				System.out.println("-1 -1");
			} else {
				System.out.print(l);
				l=0;
				r = n-1;
				while(l < r){
					int mid = (l + r +1) / 2;
					if(q[mid] <= x) {
						l = mid;
					} else {
						r = mid - 1;
					}
				}
				System.out.println(" " + r);
			}
		}
	}
}
