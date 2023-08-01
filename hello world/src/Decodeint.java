import java.util.Scanner;

public class Decodeint {
    public static void main(String[] args){
        Scanner in = new Scanner(System.in);
        int number;
        number = in.nextInt();
        int result = 0;
        do{
            int digit = number % 10;
            result = result * 10 + digit;
            //print不换行println换行
            System.out.print(digit);
            number /= 10;
        }while(number > 0);
        System.out.println();
        System.out.println(result);
    }
}
