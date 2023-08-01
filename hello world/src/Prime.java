import java.util.Scanner;

public class Prime {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        boolean isPrime = true;
        for ( int i = 2; i < n; i++ ){
            if( n % i == 0 ){
                isPrime = false;
                break;//完全离开循环  continue:离开这一轮进行下一轮
            }
        }
        if ( isPrime ){
            System.out.println(n+"是素数");
        }
        else{
            System.out.println(n+"不是素数");
        }

    }
}
