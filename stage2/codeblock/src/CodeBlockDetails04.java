public class CodeBlockDetails04 {
    public static void main(String[] args) {
//        1.进行类的加载
//          1.1 加载 父类A02
//          1.2 加载 B02
//          这里就进行静态相关的调用
//        2.创建对象
//          2.1 子类构造器
//          2.2
        new B02();
    }
}

class A02 { //父类
    private static final int n1 = getVal01();//1

    static {
        System.out.println("A02 的一个静态代码块..");//(2)
    }

    public int n3 = getVal02();//普通属性的初始化

    {
        System.out.println("A02 的第一个普通代码块..");//(5)
    }

    public A02() {//构造器
//隐藏
//super()
//普通代码和普通属性的初始化......
        System.out.println("A02 的构造器");//(7)
    }

    public static int getVal01() {
        System.out.println("getVal01");//(1)
        return 10;
    }

    public int getVal02() {
        System.out.println("getVal02");//(6)
        return 10;
    }
}

class B02 extends A02 { //
    private static final int n3 = getVal03();//3

    static {
        System.out.println("B02 的一个静态代码块..");//(4)
    }

    public int n5 = getVal04();//8

    {
        System.out.println("B02 的第一个普通代码块..");//(9)
    }

    public B02() {//构造器
//隐藏了super()
//普通代码块和普通属性的初始化...
        System.out.println("B02 的构造器");//(10)
// TODO Auto-generated constructor stub
    }

    public static int getVal03() {
        System.out.println("getVal03");//(3)
        return 10;
    }

    public int getVal04() {
        System.out.println("getVal04");//(8)
        return 10;
    } //一定要慢慢的去品..
}