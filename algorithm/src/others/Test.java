package others;

import java.util.*;

public class Test {
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int n = in.nextInt();
		int m = in.nextInt();
		char[][] s = new char[n][m];
		String[] str = new String[n];
		for (int i = 0; i < n; i++) {
			str[i] = in.next();
		}
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < m; j++) {
				s[i][j] = str[i].charAt(j);
			}
		}

		//TODO 在边界时，需要往矩阵内判断
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < m; j++) {
				int num = 0;
				if (s[i][j] == '*') {
					System.out.print('*');
				} else if (s[i][j] == '?') {
					if (j - 1 >= 0 && s[i][j-1] == '*') {
						num++;
					}  //左
					if (j + 1 < m && s[i][j+1] == '*') {
						num++;
					}  //右
					if (i - 1 >= 0 && s[i-1][j] == '*') {
						num++;
					}// 上
					if (i + 1 < n && s[i + 1][j] == '*') {
						num++;
					}//下
					if (i - 1 >= 0 && j - 1 >= 0 && s[i-1][j-1] == '*') {
						num++;
					}//左上
					if (i - 1 >= 0 && j+1<m && s[i - 1][j+1] == '*') {
						num++;
					}//右上

					if (i +1 < n && j-1>=0 && s[i +1][j-1] == '*') {
						num++;
					}//左下
					if (i + 1 < n && j+1<m && s[i+ 1][j+1] == '*') {
						num++;
					}//右下
					System.out.print(num);
				}
			}
			System.out.print('\n');
		}
	}
}