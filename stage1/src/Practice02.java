/**
 * 动态扩充数组
 * */
import java.util.Scanner;

public class Practice02 {
    public static double t(){
        double a = 1.1 * 3;
        int b = 1;
        return b;
    }
    public static void main(String[] args){
        double a = t();
        System.out.println(a);
        int[] a1 = {1, 2, 3};
        Scanner in = new Scanner(System.in);
        System.out.println("请输入您要填充的数字，输入0结束：");
        while(true){
            int n = in.nextInt();
            if(n == 0){
                System.out.println("结束了！");
                break;
            }
            int[] a2 = new int[a1.length + 1];
            for(int i = 0; i < a1.length; i++){
                a2[i] = a1[i];
            }
            a2[a2.length - 1] = n;
            a1 = a2;
            for (int j : a2) {
                System.out.print(j + "\t");
            }
            System.out.print("\n");
        }
    }
}
