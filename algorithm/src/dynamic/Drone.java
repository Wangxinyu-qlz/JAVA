package dynamic;

import java.util.Scanner;

/**
 * @program: Java
 * @author: Qiaolezi
 * @create: 2024-08-11 19:24
 * @description: 时间限制：3000MS内存限制：589824KB
 * 题目描述：在一个m*n的二维网格中，我们的无人机从左上角出发去到右下角。
 * 无人机初始电量是一个正整数，如果电量降低到0或以下，那么会立即炸机坠毁。
 * 路上经过的所有网格有不同的物理特性，导致无人机经过时消耗的电量不一样（负整数代表消耗的电量值）：
 * 有些网格如此奇妙，对于无人机来说如同瞬间通过不消耗电量（网格数值为0）：
 * 还有一些网格无人机经过会增加电量（正整数代表增加的电量）：
 * 为了尽快到达右下角，无人机每次只向右或向下移动一步。
 * 请编程计算并返回能够确保无人机到达右下角的最低初始电量。
 **/
public class Drone {
	public static void main(String[] args) {
		//int[][] grid = {{-2, -3, 3}, {-5, -10, 1}, {10, 30, -5}};
		//result = 7
		Scanner in = new Scanner(System.in);
		int grid_rows = in.nextInt();
		int grid_cols = in.nextInt();
		int[][] grid = new int[grid_rows][grid_cols];

		for (int i = 0; i < grid_rows; i++) {
			for (int j = 0; j < grid_cols; j++) {
				grid[i][j] = in.nextInt();
			}
		}

		int res = Drone.calculateMinimumHP(grid);
		System.out.println(res);
	}

	public static int calculateMinimumHP(int[][] grid) {
		int rows = grid.length;
		int cols = grid[0].length;
		int[][] dp = new int[rows][cols];

		// 初始化右下角的 dp 值
		dp[rows - 1][cols - 1] = Math.max(1, 1 - grid[rows - 1][cols - 1]);

		// 初始化最后一列
		for (int i = rows - 2; i >= 0; i--) {
			dp[i][cols - 1] = Math.max(1, dp[i + 1][cols - 1] - grid[i][cols - 1]);
		}

		// 初始化最后一行
		for (int j = cols - 2; j >= 0; j--) {
			dp[rows - 1][j] = Math.max(1, dp[rows - 1][j + 1] - grid[rows - 1][j]);
		}

		// 逆向填充 dp 表格
		for (int i = rows - 2; i >= 0; i--) {
			for (int j = cols - 2; j >= 0; j--) {
				int minHP = Math.min(dp[i + 1][j], dp[i][j + 1]);
				dp[i][j] = Math.max(1, minHP - grid[i][j]);
			}
		}

		return dp[0][0];
	}
}
