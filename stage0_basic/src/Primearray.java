import java.util.Scanner;

public class Primearray {
    public static void main(String[] args){
        Scanner in = new Scanner(System.in);
        int[] primes = new int[50];
        primes[0] = 2;
        int cnt = 1;//当前表中有cnt个素数，下一个素数要放在第cnt个位置
        MAIN_LOOP://最外层的循环被标记为主循环
        for ( int x=3; cnt<50; x++ ){//数组中素数个数小于50继续循环
            for ( int i=0; i<cnt; i++ ){
                if ( x%primes[i] == 0 ){
                    continue MAIN_LOOP;//结束当前的循环，去做主循环的下一轮
                }
            }
            primes[cnt++] = x;
        }
        for ( int k : primes ){
            System.out.print(k+" ");
        }
    }
}
