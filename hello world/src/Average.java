import java.util.Scanner;

public class Average {
    public static void main(String[] args){
        Scanner in = new Scanner(System.in);
        int sum;//总和
        int n;//输入的数字
        int count;//计数器
        double average;
        sum = 0;
        count = 0;
        // n = in.nextInt();
        // while(n != -1){
        //     sum += n;
        //     count ++;
        //     n = in.nextInt();
        // }
        do{
            n = in.nextInt();
            if(n != -1){
                sum += n;
                count ++;
            }
        }while(n != -1);
        if(count > 0){
            average = (double)sum/count;
            System.out.println("agerage:"+average);
        }
    }
}
