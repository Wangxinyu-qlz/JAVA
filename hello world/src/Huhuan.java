public class Huhuan 
{
    public static void huhuan(int a, int b)
    {
        int temp = 0;
        temp = a;
        a = b;
        b = temp;
    }
    public static void main(String[] args)
    {
        int a;
        int b;
        a = 1;
        b = 0;
        // 函数调用时只能传值
        huhuan(a, b);
        System.out.println(a+" "+b);//a=1,b=0
    }
}
