/*
* 静态内部类
* */
public class StaticInnerClass01 {
    public static void main(String[] args) {
        Outer10 outer10 = new Outer10();
        outer10.m1();

//        外部其他类访问静态内部类
//        1.要满足访问权限（private不可直接访问）
        Outer10.Inner10 inner101 = new Outer10.Inner10();
        inner101.say();
//        2.使用方法返回一个静态内部类的对象实例
        Outer10.Inner10 inner10 = outer10.getInner10Instance();
        inner10.say();

//        把返回静态内部类的对象的  方法写成static
        Outer10.Inner10 inner10_ = Outer10.getInner10Instance_();
        inner10_.say();
    }
}

class Outer10 {
    private static String name = "张飞";
    private int n1 = 10;
//    Inner10是静态内部类
//    在外部类的成员位置
//    TODO 只能访问静态的成员，私有静态也可以
//    可以添加任意的访问修饰符
    static class Inner10 {
        private static String name = "lsp";
        public void say() {
            System.out.println("内部类的name=" + name);//ok  lsp
            System.out.println("外部类的name=" + Outer10.name);//  张飞
//            System.out.println(n1);//Error
        }

        public void show() {

        }
    }

    public void m1() {//外部类访问内部类
        Inner10 inner10 = new Inner10();
        inner10.say();
    }

    public Inner10 getInner10Instance() {
        return new Inner10();
    }

    static public Inner10 getInner10Instance_() {
        return new Inner10();
    }
}