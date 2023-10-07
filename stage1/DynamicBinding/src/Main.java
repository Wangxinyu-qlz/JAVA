public class Main {
    public static void main(String[] args) {
        A a = new B();
//        属性没有动态绑定，取决于编译类型，哪里声明，哪里使用
        System.out.println(a.i);//10
//        调用对象方法时，该方法和该对象的@@@运行类型@@@/内存地址动态绑定
//        执行B中的sum方法，使用B中定义的i(20)
        System.out.println(a.sum());//40
        System.out.println(a.sum1());//30
//        @@@a的运行类型是B@@
        System.out.println(a.sum2());//30 A中的sum2()@@@调用B中的getI()@@@，因为它的运行类型是B
        System.out.println(a.sum3());//20
    }
}
class A {
    public int i = 10;
    public int sum() {
        return getI() + 10;
    }
    public int sum1() {
        return i + 10;
    }
    public int getI() {
        return i;
    }
    public int sum2() {
        return getI() + 10;//此处去子类B中调用getI()方法，使用B中的i(20)
    }
    public int sum3() {
        return i + 10;
    }
}
class B extends A {
    public int i = 20;
    @Override
    public int sum() {
        return i + 20;
    }
    @Override
    public int sum1() {
        return i + 10;
    }
    @Override
    public int getI() {
        return i;
    }
}