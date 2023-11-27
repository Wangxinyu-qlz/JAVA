import java.util.*;

class Test2 {
	public static void main(String[] args) {

		Scanner in = new Scanner(System.in);
		int n = in.nextInt();//线段数量
		int[] x = new int[n];//x坐标
		int[] y = new int[n];//y坐标
		for (int i = 0; i < n; i++) {
			x[i] = in.nextInt();
		}
		for (int i = 0; i < n; i++) {
			y[i] = in.nextInt();
		}
		int m = in.nextInt();//m个询问
		int[][] point = new int[m][2];
		for (int i = 0; i < m; i++) {
			point[i][0] = in.nextInt();
			point[i][1] = in.nextInt();
		}

		Arrays.sort(x);
		Arrays.sort(y);
		for (int i = 0; i < point.length; i++) {//m个问询
			int sum = 0;
			int left = 0;
			int right = x.length - 1;//

			while(left <= right){
				int mid = (right + left) / 2;
				//下界判定
				if(mid - 1 < 0){//下界无法判定当前线与OP有无交点
					if((double) point[i][0] / x[mid] + (double) point[i][1] / y[mid] >= 1.0){
						sum = 1;
					} else {
						sum = 0;
					}
					break;
				}
				//上界判定
				if(mid+1 >= x.length){sum = x.length;break;}
				//二分法逼近
				if( (double) point[i][0] / x[mid] + (double) point[i][1] / y[mid] >= 1.0 &&
				(double) point[i][0] / x[mid+1] + (double) point[i][1] / y[mid+1] < 1.0){
					sum = mid + 1;
					break;
				} else if((double) point[i][0] / x[mid] + (double) point[i][1] / y[mid] >= 1.0){//点在线的上面或右上，即有交点
					left = mid + 1;
				} else if((double) point[i][0] / x[mid] + (double) point[i][1] / y[mid] < 1.0){//没有交点
					right = mid - 1;
				}
			}
			System.out.println(sum);
		}
	}
}