public class CodeBlockDetails02 {
    public static void main(String[] args) {
//        优先级：static > 普通 > 构造器
//        优先级相同，根据定义的先后顺序调用
//      输出结果：
//      getN1被调用...         （static）
//      A 静态代码块 01         （static）
//      getN2被调用...         （普通）
//      A 普通代码块 01         （普通）
//      A（）的无参构造器被调用   （构造器）
        A a = new A();
    }
}

class A {
    private int n2 = getN2();

    {
        System.out.println("A 普通代码块 01");
    }

    private static int n1 = getN1();

    static {
        System.out.println("A 静态代码块 01");
    }

    public static int getN1() {
        System.out.println("getN1被调用...");
        return 100;
    }
    public int getN2() {
        System.out.println("getN2被调用...");
        return 200;
    }

    public A () {
        System.out.println("A（）的无参构造器被调用");
    }
}