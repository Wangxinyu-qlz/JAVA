import java.util.*;

class Test1{
  public static void main(String[] args){
    Scanner in = new Scanner(System.in);
    int m = in.nextInt();
    int n = in.nextInt();
    
    int[][] ma = new int[m][n];

    for(int i = 0; i<m; i++){
      for(int j= 0; j<n; j++) {
        ma[i][j] = in.nextInt();
      }
    }
    for(int i = 0; i<n; i++){
      for(int j= 0; j<m; j++) {
        System.out.print(ma[j][i]);
	      System.out.print(' ');
      }
      System.out.print('\n');
    }
  }
}