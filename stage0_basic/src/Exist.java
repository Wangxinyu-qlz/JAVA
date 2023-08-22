import java.util.Scanner;

public class Exist {
    public static void main(String[] args){
        Scanner in = new Scanner(System.in);
        int[] data = {1, 5, 44, 65, 0};
        int x = in.nextInt();
        int loc = -1;
//      i离开for循环之后是超出数组下标的
        // for ( int i=0; i<data.length; i++ ){
        //     if( x == data[i] ){
        //         loc = i+1;
        //         break;
        //     }
        // }
        // if( loc == -1 ){
        //     System.out.println("没找到！");
        // }
        // else{
        //     System.out.println("找到了！是第"+loc+"个！");
        // }

        boolean found = false;
//      for each循环遍历 读出数组中的每一个元素
        for ( int k : data ){//将数组data中的每个元素拿出来赋给k
            if ( k == x ){
                found = true;
            }
        }
    }
}
