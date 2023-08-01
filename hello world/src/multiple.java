import java.util.Scanner;

public class multiple {
    public static void main(String[] args){
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int factor = 1;
        for ( int i=1; i<=n; i++ ){
            factor = factor * i;
        }
        System.out.println(factor);
    }
}
