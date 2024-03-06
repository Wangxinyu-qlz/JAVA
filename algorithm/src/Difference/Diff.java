package Difference;

import java.util.Scanner;

/**
 * @program: Java
 * @author: Qiaolezi
 * @create: 2024-03-05 23:26
 * @description: 差分
 * TODO 不太理解
 * 假想一个b[]，a[]是b[]的前缀和，b[]是a[]的差分
 * 假设a1 a2 a3 ...an 构造一个b1 b2 b3 bn, 使得：
 * ai = b1 + b2 + b3 + ... + bn;
 * 假设a[]中全0,a1 = [1, 1] + a1 ...an = [n, n] = an;
 * 输入一个长度为n的整数序列。
 * 接下来输入个操作，每个操作包含三个整数：l, r, c,表示将序列中[l,r]之间的每个数加上c
 * 请你输出进行完所有操作后的序列。
 * 输入格式
 * 第一行包含两个整数n和m.
 * 第二行包含个整数，表示整数序列。
 * 接下来m行，每行包含三个整数l,【，c,表示一个操作。
 * 输出格式
 * 共一行，包含n个整数，表示最终序列。
 * 数据范围
 * 1≤n,m≤100000,
 * 1≤l≤r≤n,
 * -1000≤c≤1000,
 * -1000≤
 * 整数序列中元素的值≤1000
 **/
public class Diff {
	//[l, r]区间内的元素+c
	public static void insert(int[] b, int l, int r, int c){
		b[l] += c;
		b[r+1] -=c;
	}

	public static void main(String[] args) {
		int n, m;
		Scanner in = new Scanner(System.in);
		n = in.nextInt();
		int[] a = new int[n+10];
		m = in.nextInt();//问询
		for(int i=1; i<=n; i++){
			a[i] = in.nextInt();
		}
		int[] b = new int[n+10];
		//假设a[]中全0,a1 = [1, 1] + a1 ...an = [n, n] = an;
		for(int i=1; i<=n;i++){
			insert(b, i, i, a[i]);
		}

		while(m-->0){
			int l = in.nextInt();
			int r = in.nextInt();
			int c = in.nextInt();
			//对差分数组进行插入操作
			insert(b, l, r, c);
		}

		//将b数组变成自己的前缀和
		for(int i=1; i<=n; i++){
			b[i] += b[i-1];
		}

		for(int i=1; i<=n; i++){
			System.out.print(b[i] + " ");
		}
	}
}
