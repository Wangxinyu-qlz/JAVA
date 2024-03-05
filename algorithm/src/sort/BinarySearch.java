package sort;

import org.junit.jupiter.api.Test;

import java.util.Scanner;

/**
 * @program: Java
 * @author: Qiaolezi
 * @create: 2024-03-05 17:03
 * @description:
 **/
public class BinarySearch {
	/**
	 * 整数二分模板
	 *
	 * @param l
	 * @param r
	 * @return
	 */
	public static int biSearch1(int l, int r) {
		int mid = (l + r) / 2;
		//if(check(mid)) {
		//	r = mid;
		//} else {
		//	l = mid + 1;
		//}
		return l;
	}

	/**
	 * 整数二分模板
	 *
	 * @param l
	 * @param r
	 * @return
	 */
	public static int biSearch2(int l, int r) {
		int mid = (l + r + 1) / 2;
		//if(check(mid)) {
		//	l = mid;
		//} else {
		//	r = mid - 1;
		//}
		return l;
	}

	/**
	 * 浮点数二分模板
	 * 浮点数二分可以无限二分
	 * l-r < 0.00000001（某个范围）就可以认为是一个数
	 * 演示的是开平方
	 * @param: x
	 * @return: l
	 */
	public static double biSearch3_float(double x) {
		double l = 0, r = x;
		while(r - l > 1e-6){//当区间不到要求的时候，就一直循环
			double mid = (r + l) / 2;
			if(mid * mid >= x) {
				r = mid;
			} else {
				l = mid;
			}
		}
		return l;
	}
	@Test
	public void test_biSearch3_float() {
		double x = 100.0;
		System.out.println(biSearch3_float(x));
	}

	/**
	 * 给定一个按照升序排列的长度为的整数数组，以及q个查询。
	 * 对于每个查询，返回一个元素k的起始位置和终止位置(位置从0开始计数)。
	 * 如果数组中不存在该元素，则返回“-1-1”。
	 * 输入格式
	 * 第一行包含整数n和q,表示数组长度和询问个数。
	 * 第二行包含个整数(均在1~10000范围内)，表示完整数组。
	 * 接下来q行，每行包含一个整数k,表示一个询问元素。
	 * 输出格式
	 * 共q行，每行包含两个整数，表示所求元素的起始位置和终止位置。
	 * 如果数组中不存在该元素，则返回“。1-1”。
	 * 数据范围
	 * 1≤n≤100000
	 * 1≤q≤10000
	 * 1≤k≤10000
	 * 样例：
	 * 输入：
	 * 6 3
	 * 1  2  2  3  3  4
	 * 3
	 * 4
	 * 5
	 * 输出：
	 * 3 4
	 * 5 5
	 * -1 -1
	 */
	private static final int N = 100010;
	private static int n, m;//n个元素，m个询问
	private static int[] q = new int[N];

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		n = scanner.nextInt();
		m = scanner.nextInt();
		for (int i = 0; i < n; i++) {
			q[i] = scanner.nextInt();
		}
		while (m-- > 0) {
			int x;
			x = scanner.nextInt();

			int l = 0, r = n - 1;
			//找目标值的左边界
			while (l < r) {
				int mid = (l + r) >> 1;
				if (q[mid] >= x) {
					r = mid;
				} else {
					l = mid + 1;
				}
			}

			//没有符合的数字
			if (q[l] != x) {
				System.out.println("-1 -1");
			} else {
				System.out.print(l + " ");
				//找目标值的右边界
				//注意这里需要对左右边界进行初始化，因为是两次独立的查询
				l = 0;
				r = n - 1;
				while (l < r) {
					int mid = (l + r + 1) >> 1;
					if (q[mid] <= x) {
						l = mid;
					} else {
						r = mid - 1;
					}
				}
				System.out.println(l);
			}
		}
	}
}
