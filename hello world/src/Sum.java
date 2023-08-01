import java.util.Scanner;

public class Sum {
    public static void main(String[] args){
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        double sum = 0.0;
        int sign = 1;
        for ( int i=1; i<=n; i++,sign = -sign ){
            sum += 1.0/i*sign;
            // sign = -sign;//+ - + - 
            // i++;sign = -sign;
        }

        System.out.println("Sum="+sum);
        System.out.printf("sum=%.2f", sum);//四舍五入
    }
}
