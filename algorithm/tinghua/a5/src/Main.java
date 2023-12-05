import java.util.*;

class Main {
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int t = in.nextInt();
		int[][] test = new int[t][7];
		for (int i = 0; i < t; i++) {//t组测试
			test[i][0] = in.nextInt();//整数n
			for(int j = 1; j<=test[i][0]; j++){
				test[i][j] = in.nextInt();
			}
			for(int j = test[i][0]+1; j<=2*test[i][0]; j++){
				test[i][j] = in.nextInt();
			}
		}

		for (int i = 0; i < t; i++) {
			for(int j=test[i][0]+1; j<=2*test[i][0]; j++){//对遍历每个查询
				int max = 0;
				int x = test[i][j];//当前查询的大小
				for(int k = 1; k<=j-test[i][0]; k++){
					if(test[i][k] > max) max = test[i][k];
				}
				if(max<=x){
					System.out.print(max);
				} else{
					System.out.print(-1);
				}
				if(i<t-1){
					System.out.println();
				}
			}
		}
	}

}


//import java.util.*;
//
//class Main {
//	public static void main(String[] args) {
//		Scanner in = new Scanner(System.in);
//		int t = in.nextInt();
//		int[] result = new int[10000];
//		for(int i=0; i<10000; i++){
//			result[i] = -2;
//		}
//		for (int i = 0; i < t; i++) {//t组测试
//			int n = in.nextInt();
//			int test[] = new int[2*n+1];
//			test[0] = n;//整数n个查询
//			for(int j = 1; j<=2*n; j++){
//				test[j] = in.nextInt();
//			}
//
//			for(int j=n+1; j<=2*n; j++){//对遍历每个查询
//				int max = 0;
//				int x = test[j];
//				for(int k = 1; k<=j-test[0]; k++){
//					if(test[k] > max) max = test[k];
//				}
//				if(max<=x){
//					result[j-n+1] = max;
//				} else{
//					result[j-n+1] = -1;
//				}
//			}
//
//		}
//		for(int i=0; result[i]!=-2; i++){
//			System.out.println(result[i]);
//		}
//	}
//
//}