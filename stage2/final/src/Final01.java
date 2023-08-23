/*
* final
*   1.不希望类被继承
*   2.不希望父类的某个方法被子类覆盖/重写
*   3.不希望某个类的属性值被修改
*   4.不希望某个局部变量被修改
* */
public class Final01 {
    public static void main(String[] args) {
        E e = new E();
//        e.TAX_RATE = 0.09;//Error final不允许被修改

    }
}

final class A {

}

//class B extends A { }//Error A类是final，不允许被继承

class C {
//    不允许重写 可以继承
    final public void hi() {

    }
}

class D extends C {
//    public void hi() {System.out.println("D重写了C类的hi方法");}//Error 不允许重写
}

class E {
    final public double TAX_RATE = 0.08;
}

class F {
    public void cry() {
        final double WUWUWU = 0.01;
//        WUWUWU = 0.09;Error  final修饰的不允许被修改
        System.out.println("WUWUWU=" + WUWUWU);
    }

}