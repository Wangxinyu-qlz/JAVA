import java.util.Scanner;

public class Inch {
    public static void main(String[] args) throws Exception{
        double foot = 0;
        double inch = 0;
        Scanner in = new Scanner(System.in);

        System.out.println("1.2-1.1="+(1.2-1.1));

        System.out.print("请输入英尺：");
        foot = in.nextDouble();
        System.out.print("请输入英寸：");
        inch = in.nextDouble();

        System.out.println("foot="+foot+","+"inch="+inch);

        System.out.println((int)((foot+inch/12.0)*0.3048*100)+"cm");//12 != 12.0浮点数flaot (int)(表达式)强制类型转换
        // /优先级大于%
        int a, b, c=0;
        int result = a = b = 3+c;//依次向左赋值
        // result = 2;
        int test1 = 12/4%2;
        int test2 = 12%4/2;
        System.out.println("result="+result+","+"test1="+test1+","+"test2="+test2);//result=3,test1=1,test2=0

    }   
}