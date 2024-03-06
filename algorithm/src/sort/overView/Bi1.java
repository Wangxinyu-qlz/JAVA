package sort.overView;

import java.util.Scanner;

/**
 * @program: Java
 * @author: Qiaolezi
 * @create: 2024-03-06 09:22
 * @description: /**
 * * 给定一个按照升序排列的长度为的整数数组，以及q个查询。
 * * 对于每个查询，返回一个元素k的起始位置和终止位置(位置从0开始计数)。
 * * 如果数组中不存在该元素，则返回“-1-1”。
 * * 输入格式
 * * 第一行包含整数n和q,表示数组长度和询问个数。
 * * 第二行包含个整数(均在1~10000范围内)，表示完整数组。
 * * 接下来q行，每行包含一个整数k,表示一个询问元素。
 * * 输出格式
 * * 共q行，每行包含两个整数，表示所求元素的起始位置和终止位置。
 * * 如果数组中不存在该元素，则返回“。1-1”。
 * * 数据范围
 * * 1≤n≤100000
 * * 1≤q≤10000
 * * 1≤k≤10000
 * * 样例：
 * * 输入：
 * * 6 3
 * * 1  2  2  3  3  4
 * * 3
 * * 4
 * * 5
 * * 输出：
 * * 3 4
 * * 5 5
 * * -1 -1
 */
public class Bi1 {
	public static void main(String[] args) {
		int n, m;//数组长度，m个问询
		Scanner in = new Scanner(System.in);
		n = in.nextInt();
		int[] q = new int[n + 10];
		m = in.nextInt();
		for (int i = 0; i < n; i++) {
			q[i] = in.nextInt();
		}

		//m个问询
		while (m-- > 0) {
			int x = in.nextInt();
			//查询左侧
			int l = 0, r = n - 1;
			while (l < r) {
				int mid = (l + r) / 2;
				if (q[mid] >= x) {//左
					r = mid;
				} else {
					l = mid + 1;
				}
			}
			if (x != q[l]) {//没找到
				System.out.println("-1 -1");
			} else {//找到了
				//先输出结果
				System.out.print(l + " ");
				//初始化lr
				l=0;
				r = n-1;
				while(l < r){
					int mid = (l+r + 1) / 2;
					if(q[mid] <= x) {//右
						l = mid;
					}else{//左
						r = mid - 1;
					}
				}
				System.out.println(l);
			}
		}
	}
}
