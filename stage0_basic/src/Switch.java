import java.util.Scanner;

public class Switch {
    public static void main(String[] args){
        Scanner in = new Scanner(System.in);

        System.out.println("请输入一个整数：");
        int type = in.nextInt();
        switch( type )
        {
            case 1:
            case 2:
                System.out.println("你好！");
                break;
            case 3:
                System.out.println("晚上好！");//输入3,执行到case4中的break才会终止
            case 4:
                System.out.println("再见");
                break;
            default:
                System.out.println("啊？什么啊？");
                break;
        }
    }
}
