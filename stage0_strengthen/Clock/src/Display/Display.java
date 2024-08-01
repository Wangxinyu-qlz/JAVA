package Clock.src.Display;
// 别人可以使用这个类定义变量
// 一个文件中只能有一个public类
public class Display 
{
// 私有成员变量****针对类，不针对对象****
// 只有在Display类（自己）中才可以访问
// 成员变量应当设为私有
    private int value = 0;
    private int limit = 0;

//  类变量 静态的 不属于任何对象->初始化和对象的创建没关系  通过一个对象将所有对象的step值都更改
    private static int step = 1;

    // 构造函数，小时和分钟应该有不同的limit：24/60
    public Display(int limit)
    {
        this.limit = limit;
    }
// 公用的  其他类可以访问
    public void increase()
    {
        value++;
        if ( value == limit )
        {
            value = 0;
        }
    }

//  friendly    和它位于同一个包中的其他类可以访问
    int test()
    {
        return 0;
    }

    public int getValue()
    {
        return value;
    }

    public static void f()
    {
        // value++;//ERROR
    }

//  static  类函数  不属于任何对象
    public static void main(String[] args) throws Exception
    {
        Display d1 = new Display(24);
        Display d2 = new Display(10);
        for ( int i=0; i<=60; i++ )
        {
            d1.increase();
            System.out.println(d1.getValue());
        }

        System.out.println(d1.step);//1
        System.out.println(d2.step);//1
        d1.step = 2;//d1->Display->step
        System.out.println(d1.step);//2
        System.out.println(d2.step);//2
        Display.step = 3;
        System.out.println(d1.step);//3
        System.out.println(d2.step);//3

        // increase();//ERRIR
        // Display.value = 3;//ERROR:value是成员变量，不是类变量
        d1.increase();
        Display.f();
        f();
        d1.f();
    }
}
