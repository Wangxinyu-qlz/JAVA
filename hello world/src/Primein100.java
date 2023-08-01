import java.util.Scanner;

public class Primein100 {
    public static void main(String[] args){
        // Scanner in = new Scanner(System.in);
        int i, j;
        int n = 100;
        for ( i=2; i<=n; i++ ){
            for ( j=2; j<i; j++ ){
                if ( i%j == 0 ){
                    break;
                }
            }
            if( j==i )
            {
                System.out.print(i+" ");
            }
        }
        
    }
}
