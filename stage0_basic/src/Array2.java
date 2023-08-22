import java.util.Scanner;

public class Array2 {
    public static void main(String[] args){
        Scanner in = new Scanner(System.in);
        int[] a = new int[3];
        int[] b;
        int[] c = {4, 5, 6};
        b = a;//a b是数组的管理者
        for ( int i=0; i<a.length; i++ ){
            a[i] = in.nextInt();//1 2 3
        }
        for ( int i=0; i<b.length; i++ ){
            System.out.println(b[i]);//1 2 3
        }
        a[0] = 100;
        for ( int i=0; i<b.length; i++ ){
            System.out.println(b[i]);//100 2 3
        }
        for ( int i=0; i<c.length; i++ ){
            c[i]++;
        }
        for ( int i=0; i<c.length; i++ ){
            System.out.println(c[i]);//5 6 7
        }
        int[] d = {1, 1, 1};
        int[] e = {1, 1, 1};
        System.out.println(d==e);//flase
        System.out.println(a==b);//true  (b=a)

        int[] f = new int[d.length];
        for ( int i=0; i<f.length; i++ ){
            f[i] = d[i];
        }
        for ( int i=0; i<f.length; i++ ){
            System.out.println(f[i]);
        }

    }
}
