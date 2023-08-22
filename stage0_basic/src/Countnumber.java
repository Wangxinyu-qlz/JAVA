import java.util.Scanner;

public class Countnumber {
    public static void main(String[] args){
        Scanner in = new Scanner(System.in);
        System.out.println("请输入一个整数：");
        int number;
        number = in.nextInt();
        int n;
        int count;
        n = number;
        count = 0;
        //di...whiel循环解决了0的判断 
        do{
            n = n / 10;
            count ++;
        }while(n != 0);

        System.out.println(number+"是一个"+count+"位数");
        }
}
