import java.util.*;
class Tree{
  public static void main(String[] args){
    Scanner in = new Scanner(System.in);
    int l = in.nextInt();
    int m = in.nextInt();
    int[][] arr = new int[m][2];
    for(int i = 0; i < m; i++){
      arr[i][0] = in.nextInt();
      arr[i][1] = in.nextInt();
    }

    int[] len = new int[l+1];
	  Arrays.fill(len, 1);
    
    int sum = 0;
    for(int i = 0; i<m;i++){
      for(int j = arr[i][0]; j<=arr[i][1];j++){
          len[j] = 0;
      }
    }
    for(int i = 0; i<l+1;i++){
      if(len[i] == 1){
        sum++;
      }
    }
    System.out.print(sum);
  } 
}