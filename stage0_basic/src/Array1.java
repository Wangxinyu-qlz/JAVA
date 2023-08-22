import java.util.Scanner;

public class Array1 {
    public static void main(String[] args){
        Scanner in = new Scanner(System.in);
        int x = in.nextInt();
        int[] numbers = new int[100];
        // int[] array = {2, 3,1, 5, 4};
        double sum = 0;
        int cnt = 0;
        while( x!=-1 ){
            numbers[cnt] = x;
            sum += x;
            cnt ++;
            x = in.nextInt();
        }
        if( cnt>0 ){
            double average = sum/cnt;
//          numbers.length表示数组numbers的长度
            for( int i=0; i<numbers.length; i++ ){
                if( numbers[i] > average ){
                    System.out.println(numbers[i]);
                }
            }
            System.out.println(average);
        }
    }
}
