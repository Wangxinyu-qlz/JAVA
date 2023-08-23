/*
* 子类父类 静态 普通 构造器 的执行顺序
* 1.父类静态
* 2.子类静态
* 3.父类普通
* 4.父类构造器
* 5.子类普通
* 6.子类构造器
*
* 静态代码块只能调用静态成员
* 普通代码块可以调用任意成员
* */
public class CodeBlockDetails03 {
    public static void main(String[] args) {
//AAA的static代码块   BBB的static代码块   AAA的普通代码块   AAA()构造器被调用   BBB的普通代码块   BBB()构造器被调用
        new BBB();
    }
}

class AAA {
    static {
        System.out.println("AAA的static代码块");
    }
    {
        System.out.println("AAA的普通代码块");
    }
    public AAA() {
//        super();//隐藏
//        2.调用普通代码块
        System.out.println("AAA()构造器被调用");
    }
}

class BBB extends AAA {
    static {
        System.out.println("BBB的static代码块");
    }
    {
        System.out.println("BBB的普通代码块");
    }
    public BBB() {
//        1.super();//隐藏
//        2.调用普通代码块
        System.out.println("BBB()构造器被调用");
    }
}
