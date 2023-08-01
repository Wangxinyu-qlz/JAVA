import java.util.Scanner;

public class Compare {
    public static void main(String[] args) throws Exception {
//      浮点数比较大小
        // double a = 1.0;
        // double b = 0.1+0.1+0.1+0.1+0.1+0.1+0.1+0.1+0.1+0.1;
        // System.out.println(a == b);//false
        // System.out.println("a="+a+",b="+b);//a=1.0,b=0.9999999999999999
        // System.out.println(Math.abs(a-b) < 1e-6);//true
//      初始化
        Scanner in = new Scanner(System.in);
        int balance = 0;
//          读入投币金额
        while(true)
        {
            System.out.print("请投币：");
            int amount = in.nextInt();
            // System.out.println(amount);
            // System.out.println(amount>=10);//true
            balance = balance + amount;
            if(balance >= 10)
            {
    //          打印车票
            System.out.println("*****************");
            System.out.println("*Java城际铁路专线*");
            System.out.println("*  无指定座位票  *");
            System.out.println("*   票价“10元   *");
            System.out.println("*****************");
    //          计算并打印找零
            System.out.println("找零：" + (balance - 10));
            balance = 0;
            break;
            }
        }
    }
}
