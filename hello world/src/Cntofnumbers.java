import java.util.Scanner;

public class Cntofnumbers {
    public static void main(String[] args){
        Scanner in = new Scanner(System.in);
        int x;
        int[] numbers = new int[10];//自动初始化为0
        // for ( int i=0; i<numbers.length; i++ ){
        //     System.out.println(numbers[i]);
        // }
        x = in.nextInt();
        while( x!=-1 ){
            if ( x>=0 && x<=9 ){
                numbers[x]++;
            }
            x = in.nextInt();
        }
        for ( int i=0; i<numbers.length; i++ ){
            System.out.println("数字"+i+":"+numbers[i]+"个");
        }
    }
}
