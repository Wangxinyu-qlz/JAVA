package sort.overView;

import java.util.Scanner;

/**
 * @program: Java
 * @author: Qiaolezi
 * @create: 2024-03-05 21:51
 * @description:
 **/
public class Bi {
	public static double sq(double x) {
		double l=0, r = x;
		while(r - l > 1e-6) {
			double mid = (r + l) / 2;
			if(mid* mid >= x) {
				r = mid;
			}else {
				l = mid;
			}
		}
		return l;
	}
	public static void main(String[] args) {
		int[] q = { 1, 2, 2, 3, 3, 3, 4, 5, 5};
		int n = q.length;
		int l = 0, r = n - 1;
		Scanner scanner = new Scanner(System.in);
		System.out.println("===========输入一个数字，返回数组中的界限=============");
		int x = scanner.nextInt();
		while(l < r) {
			int mid = (l + r) / 2;
			if(q[mid] >= x) {//左边找
				r = mid;
			}else {
				l = mid + 1;
			}
		}
		if(q[l] != x) {//没有这样的数字
			System.out.println("-1 -1");
		} else {
			//找到了先输出左边界
			System.out.print(l + " ");
			//继续二分查找右边界之前，初始化一下lr
			l = 0;
			r = n  -1;
			while(l < r) {
				int mid = (l + r + 1) / 2;
				if(q[mid] <= x) {
					l = mid;
				}else {
					r = mid - 1;
				}
			}
			System.out.println(l);
		}

		System.out.println("=============开平方===========");
		double v = scanner.nextDouble();
		System.out.println("开方结果：" + sq(v));
	}
}
